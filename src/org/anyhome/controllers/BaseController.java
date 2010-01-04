/* ***********************************************
 * author :  Anyhome
 * email  :  ayhome@gmail.com 
 * function: 
 * @date 2009-12-25
 * history:  created by Anyhome
 * ***********************************************/
 
/**
 * 
 */
package org.anyhome.controllers;

import java.util.ArrayList;
import java.util.List;
import org.anyhome.DateBinder;
import org.anyhome.DateConverter;
import org.anyhome.Permission;
import org.anyhome.models.MyHelpers;
import org.anyhome.models.MyPermissionValue;
import org.anyhome.models.MyUser;

import com.et.ar.ConvertUtil;
import com.et.ar.exception.ActiveRecordException;
import com.et.mvc.Controller;
import com.et.mvc.binding.DataBinders;
import com.et.mvc.filter.AroundFilter;
import com.et.mvc.filter.BeforeFilter;
import com.et.mvc.filter.BeforeFilters;

/**
 * @author anyhome
 *
 */

@BeforeFilters({
	@BeforeFilter(execute="Auth"),
	@BeforeFilter(execute="InitPages")
})
@AroundFilter(execute=org.anyhome.AroundFilter.class)
public class BaseController extends Controller {
	
	protected MyUser MyUserTicket;
	
	static{ 
		ConvertUtil.register(new DateConverter(), java.sql.Date.class); 
		//java.lang.String
		DataBinders.register(java.util.Date.class, new DateBinder());
	} 

	protected boolean InitPages() throws ActiveRecordException{
		MyHelpers Helpers = new MyHelpers();
		Helpers.setAction(super.getActionName());
		Helpers.setController(super.getControllerName());
		Helpers.setUrl(super.request.getRequestURL().toString());
		Helpers.setUri(super.request.getRequestURI());
		Helpers.setContextPath(super.request.getContextPath());
		//---		
		String ss = super.getControllerName().toLowerCase();
		if (ss!="desktop"){
			if (MyUserTicket!=null){
				List<String> lst = new ArrayList<String>();
				if (MyUserTicket.getU_Type()!=0){	
					lst = Permission.CheckAndPermiss(MyUserTicket.getUserID(),super.getControllerName());					
				}else{
					for (String s:Permission.PopedomType().keySet()){
						lst.add(s);				
					}
				}
				Helpers.setPermission(lst);
			}
		}
		super.getRequest().setAttribute("Helpers", Helpers);
		return true;
	}	
	
	protected Boolean Auth() throws Exception{
		if (session.getAttribute("MyUserTicket") == null){
			response.sendRedirect(super.request.getContextPath());
            return false;
        }
		MyUserTicket = (MyUser)session.getAttribute("MyUserTicket");
		request.setAttribute("MyUserTicket", MyUserTicket);
        return true;
	}
}
