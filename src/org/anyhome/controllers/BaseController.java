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

import java.util.HashMap;
import java.util.Map;

import org.anyhome.CacheManager;
import org.anyhome.models.MyHelpers;
import org.anyhome.models.MyUser;

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
	protected CacheManager cache = CacheManager.getInstance();
	protected MyUser MyUserTicket;
	protected boolean InitPages(){
		MyHelpers Helpers = new MyHelpers();
		Helpers.setAction(super.getActionName());
		Helpers.setController(super.getControllerName());
		Helpers.setUrl(super.request.getRequestURL().toString());
		Helpers.setUri(super.request.getRequestURI());
		Helpers.setContextPath(super.request.getContextPath());
		super.getRequest().setAttribute("Helpers", Helpers);
		return true;				
	}		
	protected static Map<String, Integer> PopedomType(){
		Map<String, Integer> popedomType = new HashMap<String, Integer>();
		popedomType.put("Details", 2);		
		popedomType.put("Create", 4);
		popedomType.put("Edit", 8);
		popedomType.put("Delete", 16);
		popedomType.put("Orderby", 32);
		popedomType.put("Print", 64);
		popedomType.put("List", 128);
		return popedomType;		
	}		
	
	protected Boolean Auth() throws Exception{
		if (session.getAttribute("MyUserTicket") == null){
			response.sendRedirect("desktop/../" );
            return false;
        }
		MyUserTicket = (MyUser)session.getAttribute("MyUserTicket");
		request.setAttribute("MyUserTicket", MyUserTicket);
        return true;
	}
}
