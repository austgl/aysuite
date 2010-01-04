/* ***********************************************
 * author :  Anyhome
 * email  :  ayhome@gmail.com 
 * function: 
 * @date 2009-12-24
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
import org.anyhome.Encrypt;
import org.anyhome.Permission;
import org.anyhome.models.MyPermissionValue;
import org.anyhome.models.MyUser;

import com.et.ar.exception.ActiveRecordException;
import com.et.mvc.Controller;
import com.et.mvc.FreeMarkerView;
import com.et.mvc.JsonView;
import com.et.mvc.TextView;

/**
 * @author anyhome
 *
 */
public class PermissionController extends Controller{
	public FreeMarkerView index(int id){
		FreeMarkerView view = new FreeMarkerView();
		List<MyPermissionValue> myPermissionValue = new ArrayList<MyPermissionValue>();
		if (id == 0){
			for (String s:Permission.PopedomType().keySet()){
				MyPermissionValue PermissionValue = new MyPermissionValue();
				PermissionValue.setPermissName(s);
				PermissionValue.setPermissValue(Permission.PopedomType().get(s));
				myPermissionValue.add(PermissionValue);
			}
		}else 
		if(id > 0){
			for (String s:Permission.PopedomType().keySet()){
				MyPermissionValue PermissionValue = new MyPermissionValue();
				if (Permission.PopedomType().get(s)==id){
					PermissionValue.setPermissName(s);
					PermissionValue.setPermissValue(Permission.PopedomType().get(s));
				}							
				myPermissionValue.add(PermissionValue);
			}			
		}
		view.setAttribute("myPermission", myPermissionValue);
		return view;
	}	 
	
	public FreeMarkerView FMGetAllUser() throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		List<MyUser> myUser = MyUser.findAll(MyUser.class);
		view.setAttribute("myUser", myUser);		
		return view;
	}
	
	public TextView UserLogin() throws Exception{
		String s="用户名或密码错误";
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		passWord = Encrypt.MD5(passWord);
		MyUser myUser = MyUser.findFirst(MyUser.class,"U_LoginName=? and U_Password=?",
				new Object[]{userName,passWord});		
		if (myUser!=null){
			session.setAttribute("MyUserTicket", myUser);	
			s="";
			//response.sendRedirect(request.getContextPath()+"/desktop");
		}
		return new TextView(s);
	}
	
	public JsonView UserLogout(int id) throws Exception{
		session.removeAttribute("MyUserTicket");
		String key = id + "-Roles";
		Permission.cache.remove(key);		
		response.sendRedirect(request.getContextPath());
		return new JsonView();		
	}
	
}
