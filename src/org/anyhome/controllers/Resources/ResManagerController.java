/* ***********************************************
 * author :  Anyhome
 * email  :  ayhome@gmail.com 
 * function: 
 * @date 2009-12-29
 * history:  created by Anyhome
 * ***********************************************/
 
/**
 * 
 */
package org.anyhome.controllers.Resources;

import java.util.ArrayList;
import java.util.List;

import org.anyhome.Permission;
import org.anyhome.controllers.MemberController;
import org.anyhome.models.MyResources;
import org.anyhome.models.MyRolePermission;

import com.et.ar.exception.ActiveRecordException;
import com.et.mvc.FreeMarkerView;
import com.et.mvc.JsonView;

/**
 * @author anyhome
 *
 */
public class ResManagerController extends MemberController {
	public FreeMarkerView index() throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		return view;		
	}
	
	public FreeMarkerView List() throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		String AdminId = request.getParameter("AdminId");
		if (AdminId==null || AdminId=="")
			AdminId="0";
		List<MyResources> myResources = new ArrayList<MyResources>();
		if (AdminId=="0")
			myResources = MyResources.findAll(MyResources.class);
		else{
			myResources = MyResources.findAll(MyResources.class,"R_UserID=?",
					new Object[]{AdminId});
		}
		view.setAttribute("R_UserID", AdminId);
		view.setAttribute("myResources", myResources);
		return view;		
	}
	
	public FreeMarkerView Edit(int id) throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		MyResources myResources = MyResources.find(MyResources.class, id);
		view.setAttribute("myResources", myResources);
		return view;
	}
	
	public JsonView SaveEdit(int id) throws Exception{
		MyResources myResources = MyResources.find(MyResources.class, id);
		myResources = MyResources.updateModel(myResources, request.getParameterMap());
		if (myResources.save())
			return null;
		return new JsonView();
	}
	
	public FreeMarkerView Create(){
		return new FreeMarkerView();
	}
	
	public JsonView SaveCreate(MyResources myResources) throws ActiveRecordException{
		if (myResources.save()){
			return null;
		}
		return new JsonView();
	}
	
	public JsonView Delete(int id) throws ActiveRecordException{
		MyResources myResources = MyResources.find(MyResources.class, id);
		myResources.destroy();
		return new JsonView();
	}	

}
