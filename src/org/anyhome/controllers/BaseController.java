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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.anyhome.CacheManager;
import org.anyhome.Permission;
import org.anyhome.models.MyHelpers;
import org.anyhome.models.MyPermissionValue;
import org.anyhome.models.MyUser;

import com.et.ar.exception.ActiveRecordException;
import com.et.mvc.Controller;
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
					int PermissValue = Permission.PermissionValue(super.getControllerName());
					System.out.println("PermissValue"+PermissValue);
					for (String s:Permission.PopedomType().keySet()){
						if ((PermissValue & Permission.PopedomType().get(s))==Permission.PopedomType().get(s)){
							MyPermissionValue PermissionValue = new MyPermissionValue();
							PermissionValue.setPermissName(s);
							PermissionValue.setPermissValue(Permission.PopedomType().get(s));							
							lst.add(s);					
						}				
					}					
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
