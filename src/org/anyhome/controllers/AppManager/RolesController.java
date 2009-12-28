/* ***********************************************
 * author :  Anyhome
 * email  :  ayhome@gmail.com 
 * function: 
 * @date 2009-12-20
 * history:  created by Anyhome
 * ***********************************************/
 
/**
 * 
 */
package org.anyhome.controllers.AppManager;

import java.util.ArrayList;
import java.util.List;

import org.anyhome.Permission;
import org.anyhome.controllers.AdminController;
import org.anyhome.models.MyApplications;
import org.anyhome.models.MyModule;
import org.anyhome.models.MyPermissionValue;
import org.anyhome.models.MyRoleApplication;
import org.anyhome.models.MyRolePermission;
import org.anyhome.models.MyRoles;
import org.anyhome.models.MyUser;
import org.anyhome.models.MyUserRoles;

import com.et.ar.exception.ActiveRecordException;
import com.et.mvc.FreeMarkerView;
import com.et.mvc.JsonView;

/**
 * @author anyhome
 *
 */
public class RolesController extends AdminController {

	public FreeMarkerView index() throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		List<MyRoles> myRoles = MyRoles.findAll(MyRoles.class);
		view.setAttribute("myRoles", myRoles);
		return view;
	}
	
	public FreeMarkerView Details(int id) throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		MyRoles myRoles = MyRoles.find(MyRoles.class, id);
		List<MyApplications> myApp = MyApplications.findAll(MyApplications.class);
		List<MyRoleApplication> myRoleApp = MyRoleApplication.findAll(MyRoleApplication.class, 
				"A_RoleID=?",new Object[]{id});
		view.setAttribute("myRoles", myRoles);
		view.setAttribute("myApp", myApp);
		view.setAttribute("myRoleApp", myRoleApp);
		return view;
	}
	
	public JsonView SaveCreate(MyRoles myRoles) throws ActiveRecordException{
		if (myRoles.save())
			return null;
		return new JsonView();
	}
	
	public JsonView SaveEdit(int id) throws Exception{
		String[] AppID = request.getParameterValues("ApplicationID");
		MyRoles myRoles = MyRoles.find(MyRoles.class, id);
		myRoles = MyRoles.updateModel(myRoles, request.getParameterMap());
		myRoles.save();
		MyRoleApplication.deleteAll(MyRoleApplication.class, "A_RoleID=?", 
							new Object[]{id});
		for(String i:AppID)
		{
			MyRoleApplication myRoleApp = new MyRoleApplication();
			myRoleApp.setA_ApplicationID(Integer.parseInt(i));
			myRoleApp.setA_RoleID(id);
			myRoleApp.save();			
		}
		 
		return new JsonView();
	}
	/**
	 * 根据角色ID列出所有用户ID
	 * @param id
	 * @return
	 * @throws ActiveRecordException
	 */
	public FreeMarkerView RolesUser(int id) throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		List<MyUserRoles> myUserRoles =MyUserRoles.findAll(MyUserRoles.class,"R_RoleID=?",
				new Object[]{id});
		List<MyUser> myUser = MyUser.findAll(MyUser.class,
				"U_Type<>0",new Object[]{});
		view.setAttribute("myUserRoles", myUserRoles);
		view.setAttribute("RoleID", id);
		view.setAttribute("myUser", myUser);
		return view;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public JsonView SaveRolesUser(int id) throws Exception{
		MyUserRoles.deleteAll(MyUserRoles.class, "R_RoleID", new Object[]{id});
		String[] UserID = request.getParameterValues("UserID");
		for(String i:UserID)
		{
			MyUserRoles myUserRoles = new MyUserRoles();
			myUserRoles.setR_UserID(Integer.parseInt(i));
			myUserRoles.setR_RoleID(id);
			if (myUserRoles.save()){		
				String key = i.toString() + "-Roles";
				Permission.cache.remove(key);
			}
		}		
		return new JsonView();
	}
	
	public JsonView CreateRolesUser(int id) throws ActiveRecordException{
		int userId = Integer.parseInt(request.getParameter("userId"));
		MyUserRoles myUserRoles = new MyUserRoles ();
		myUserRoles.setR_RoleID(id);
		myUserRoles.setR_UserID(userId);
		if(myUserRoles.save()){
			String key = userId + "-Roles";
			Permission.cache.remove(key);
		}
		return new JsonView();
	}
	public JsonView DeleteRolesUser(int id) throws Exception{
		int userId = Integer.parseInt(request.getParameter("userId"));
		//MyUserRoles myUserRoles = MyUserRoles.findFirst(MyUserRoles.class, " R_UserID=? and R_RoleID=?",
				//new Object[]{userId,id});
		//myUserRoles.destroy();
		MyUserRoles.deleteAll(MyUserRoles.class, " R_UserID=? and R_RoleID=?",
				new Object[]{userId,id});
		return new JsonView();
	}
	
	public FreeMarkerView RolePermisson(int id) throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		List<MyRolePermission> myRolePermission = MyRolePermission.findAll(MyRolePermission.class,
				"P_RoleID=?",new Object[]{id});
		List<MyModule> myModule = MyModule.findAll(MyModule.class,
				"M_IsSystem=1",new Object[]{});		
		view.setAttribute("myRolePermission", myRolePermission);
		view.setAttribute("myModule", myModule);
		view.setAttribute("RoleID", id);
		
		List<MyPermissionValue> myPermissionValue = new ArrayList<MyPermissionValue>();		
		for (String s:Permission.PopedomType().keySet()){
			MyPermissionValue PermissionValue = new MyPermissionValue();
			PermissionValue.setPermissName(s);
			PermissionValue.setPermissValue(Permission.PopedomType().get(s));
			myPermissionValue.add(PermissionValue);
		}		
		view.setAttribute("myPermission", myPermissionValue);
		return view;
	}
	
	public JsonView GetRolePermisson(int id) throws ActiveRecordException{
		String pageCode = request.getParameter("pageCode");
		List<MyPermissionValue> myPermissValue = new ArrayList<MyPermissionValue>();
		MyRolePermission RolePermisson = MyRolePermission.findFirst(MyRolePermission.class,
				"P_RoleID=? and P_PageCode=?",new Object[]{id,pageCode});
		if (RolePermisson != null){
			int PermissValue = RolePermisson.getP_Value();
			for (String s:Permission.PopedomType().keySet()){
				if ((PermissValue & Permission.PopedomType().get(s) )==Permission.PopedomType().get(s)){
					MyPermissionValue PermissionValue = new MyPermissionValue();
					PermissionValue.setPermissName(s);
					PermissionValue.setPermissValue(Permission.PopedomType().get(s));
					myPermissValue.add(PermissionValue);					
				}				
			}			
		}
		return new JsonView(myPermissValue);		
	}
	
	public JsonView UpdateRolePermisson(int id) throws ActiveRecordException{		
		String pageCode = request.getParameter("pageCode");
		int p_Value = Integer.parseInt(request.getParameter("p_Value"));
		int ApplicationID  = Integer.parseInt(request.getParameter("ApplicationID"));
		MyRolePermission RolePermisson = MyRolePermission.findFirst(MyRolePermission.class,
				"P_RoleID=? and P_PageCode=?",new Object[]{id,pageCode});
		MyRolePermission RP = new MyRolePermission();
		RP.setP_ApplicationID(ApplicationID);
		RP.setP_PageCode(pageCode);
		RP.setP_RoleID(id);
		RP.setP_Value(p_Value);
		if (RolePermisson!=null){
			RolePermisson.destroy();
			String key = ApplicationID+ "-"+pageCode;
			Permission.cache.remove(key);
		}
		if (p_Value>0)
			RP.save();
		return new JsonView();
	}
	
	public JsonView Delete(int id) throws Exception{
		MyRoles myRoles =  MyRoles.find(MyRoles.class, id);
		myRoles.destroy();
		return new JsonView();
	}
}
