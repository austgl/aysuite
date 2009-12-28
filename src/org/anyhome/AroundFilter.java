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
package org.anyhome;

import org.anyhome.models.MyModule;
import org.anyhome.models.MyUser;

import com.et.mvc.Controller;
import com.et.mvc.filter.AroundHandler;

/**
 * @author anyhome
 *
 */
public class AroundFilter implements AroundHandler {

	/* (non-Javadoc)
	 * @see com.et.mvc.filter.AroundHandler#after(com.et.mvc.Controller)
	 */
	@Override
	public boolean after(Controller controller) throws Exception {
		return true;
	}
	
	
	/* (non-Javadoc)
	 * @see com.et.mvc.filter.AroundHandler#before(com.et.mvc.Controller)
	 */
	@Override
	public boolean before(Controller controller) throws Exception {
		if (controller.getSession().getAttribute("MyUserTicket")==null){
			controller.getResponse().sendRedirect(controller.getControllerPath() );
			return false;
		}
		
		MyUser MyUserTicket = (MyUser)controller.getSession().getAttribute("MyUserTicket");
		
		
		if (MyUserTicket.getU_Type()==0)			
			return true;		
		else if (MyUserTicket.getU_Type()==1){
			String actionName = controller.getActionName();
			String controllerName = controller.getControllerName();
			String pageCode = "";
			int appId=0;
			int userid = MyUserTicket.getUserID();
			int PermissonValue = 0;		
			if (actionName.toLowerCase()=="index"){
				actionName = "list";
			}	
			actionName = actionName.toLowerCase();	
			actionName = actionName.replace("save", "");
			for (String s:Permission.PopedomType().keySet()){
				if (actionName==s.toLowerCase())
					PermissonValue = Permission.PopedomType().get(s);
			}
			if (controllerName.toLowerCase()=="applications")
				controllerName="application";
			if (!controllerName.toLowerCase().equals("desktop")){
				MyModule myModule =MyModule.findFirst(MyModule.class,
						"M_Directory=?",new Object[]{controllerName});
				if (myModule!=null){
					pageCode = myModule.getM_PageCode();
					appId = myModule.getM_ApplicationID();
				}
				if (controllerName=="desktop")
					return true;
				else
					return Permission.CheckPermission(userid, appId, pageCode, PermissonValue);		
			}
		}
		return true;
	}

}
