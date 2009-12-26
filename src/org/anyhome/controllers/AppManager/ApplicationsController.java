/* ***********************************************
 * author :  Anyhome
 * email  :  ayhome@gmail.com 
 * function: 
 * @date 2009-10-30
 * history:  created by Anyhome
 * ***********************************************/
 
package org.anyhome.controllers.AppManager;

import java.util.List;
import org.anyhome.AMF3View;
import org.anyhome.controllers.AdminController;
import org.anyhome.models.MyApplications;
import org.anyhome.models.MyUser;

import com.et.ar.exception.ActiveRecordException;
import com.et.mvc.FreeMarkerView;


public class ApplicationsController extends AdminController {
	
	/*
	public AMF3View index() throws Exception{
		List<MyApplications> myApp = MyApplications.findAll(MyApplications.class);
		List<Map> lst = new ArrayList<Map>(); 
		for(MyApplications items:myApp)
		{
			lst.add(PojoToMap(items));
		}
		return new AMF3View(lst);
	}
	*/
	public FreeMarkerView index() throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();		
		List<MyApplications> myApp = MyApplications.findAll(MyApplications.class);
		view.setAttribute("myApp", myApp);
		return view;	
	}
	public FreeMarkerView Edit(int id){
		return new FreeMarkerView();
	}
	
	public FreeMarkerView SaveEdit(int id) throws Exception{
		MyApplications myApp = MyApplications.find(MyApplications.class, id);
		myApp = MyApplications.updateModel(myApp, request.getParameterMap());
		if (myApp.save()){
			return null;
		}
		return new FreeMarkerView();
	}
	
	public FreeMarkerView Create(){
		return new FreeMarkerView();
	}
	
	public FreeMarkerView SaveCreate(MyApplications myApp) throws Exception{
		 if (myApp.save()){
	            return null;
	        }
		 return new FreeMarkerView();
		//return myApp.getA_AppName();
	}
	
	public void Details(int id){
		
	}
	
	public FreeMarkerView Delete(int id) throws ActiveRecordException{
		MyApplications myApp = MyApplications.find(MyApplications.class, id);
		myApp.destroy();	
		return new FreeMarkerView();
	}
	
	public AMF3View test() throws ActiveRecordException{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		MyUser myUser = MyUser.findFirst(MyUser.class,"U_LoginName=?",
				new Object[]{userName});
		return new AMF3View(myUser);		
	}		
}

