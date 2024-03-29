/* ***********************************************
 * author :  Anyhome
 * email  :  ayhome@gmail.com 
 * function: 
 * @date 2009-10-29
 * history:  created by Anyhome
 * ***********************************************/
 
package org.anyhome.controllers.AppManager;


import java.util.ArrayList;
import java.util.List;

import org.anyhome.Encrypt;
import org.anyhome.controllers.AdminController;
import org.anyhome.models.MyGroup;
import org.anyhome.models.MyUser;

import com.et.ar.exception.ActiveRecordException;
import com.et.mvc.FreeMarkerView;
import com.et.mvc.JsonView;

public class UserController extends AdminController {

	public FreeMarkerView index() throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		List<MyUser> myUser = MyUser.findAll(MyUser.class);
		List<MyGroup> myGroup = MyUser.findAll(MyGroup.class);		
		view.setAttribute("myUser", myUser);
		view.setAttribute("myGroup", myGroup);
		return view;
	}	
	
	public FreeMarkerView UserByGroup()throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		String id = request.getParameter("id");
		if (id=="" || id==null)
			id="0";
		List<MyUser> myUser = new ArrayList<MyUser>();
		if(id=="0")
			myUser = MyUser.findAll(MyUser.class);
		else
			myUser = MyUser.findAll(MyUser.class,"U_GroupID=?",
					new Object[]{id});
		view.setAttribute("myUser", myUser);
		return view;		
	}
	
	public FreeMarkerView Edit(int id) throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		MyUser myUser = MyUser.find(MyUser.class, id);
		view.setAttribute("mySuer", myUser);
		return view;		
	}
	
	public JsonView SaveEdit(int id) throws Exception{
		MyUser myUser = MyUser.find(MyUser.class, id);
		myUser = MyUser.updateModel(myUser, request.getParameterMap());
		myUser.save();
		return new JsonView();
	}
	
	public FreeMarkerView Details(int id) throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		MyUser myUser = MyUser.find(MyUser.class, id);
		view.setAttribute("myUser", myUser);
		return view;		
	}
	
	public FreeMarkerView Create(){
		return new FreeMarkerView();
	}
	
	public JsonView SaveCreate(MyUser myUser) throws ActiveRecordException{
		myUser.setU_Password(Encrypt.MD5(myUser.getU_Password()));
		if (myUser.save())
			return null;
		return new JsonView();
	}
	
	public JsonView Delete(int id) throws ActiveRecordException{
		MyUser myUser = MyUser.find(MyUser.class, id);
		myUser.destroy();
		return new JsonView();
	}
}
