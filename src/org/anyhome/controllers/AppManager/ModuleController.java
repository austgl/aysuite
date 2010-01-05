/* ***********************************************
 * author :  Anyhome
 * email  :  ayhome@gmail.com 
 * function: 
 * @date 2009-11-16
 * history:  created by Anyhome
 * ***********************************************/
 
/**
 * 
 */
package org.anyhome.controllers.AppManager;

import java.util.List;
import org.anyhome.controllers.AdminController;
import org.anyhome.models.MyModule;

import com.et.ar.exception.ActiveRecordException;
import com.et.mvc.FreeMarkerView;
import com.et.mvc.JsonView;
import com.et.mvc.TextView;

/**
 * @author Ayhome
 *
 */
public class ModuleController extends AdminController {

	public FreeMarkerView index() throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		List<MyModule> myModule = MyModule.findAll(MyModule.class);	
		view.setAttribute("myModule", myModule);
		return view;
	}
	
	public FreeMarkerView Create(){
		FreeMarkerView view = new FreeMarkerView();

		return view;
	}


	public JsonView SaveCreate(MyModule myModule) throws ActiveRecordException{
		if(myModule.save()){
			if (myModule.getM_ParentID()==0){
				MyModule m = new MyModule();
				m.setM_ApplicationID(myModule.getM_ApplicationID());
				m.setM_Close(myModule.getM_Close());
				m.setM_CName(myModule.getM_CName());
				m.setM_Directory(myModule.getM_Directory());
				m.setM_Icon(myModule.getM_Icon());
				m.setM_IsSystem(myModule.getM_IsSystem());
				m.setM_ParentID(myModule.getModuleID());
				m.setM_PageCode(myModule.getM_PageCode()+"001");
				m.save();
			}			
			return null;
		}
		//return ;
		return new JsonView();
		
	}	
	public FreeMarkerView Edit(){
		FreeMarkerView view = new FreeMarkerView();

		return view;
	}

	
	public TextView SaveEdit(int id) throws Exception{
		MyModule myModule = MyModule.find(MyModule.class, id);
		myModule = MyModule.updateModel(myModule, request.getParameterMap());
		if(myModule.save())
			return null;
		return new TextView();
	}
	
	
	public FreeMarkerView CreateModule(){
		FreeMarkerView view = new FreeMarkerView();

		return view;
	}
	
	public FreeMarkerView EditModule(){
		FreeMarkerView view = new FreeMarkerView();

		return view;
	}
	
	public FreeMarkerView ModuleList(int id) throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		MyModule myModule = MyModule.findFirst(MyModule.class,"ModuleID=?",
				new Object[]{id});
		view.setAttribute("myModule", myModule);
		return view;
	}

	public JsonView GetAllJson() throws ActiveRecordException{
		List<MyModule> myModule = MyModule.findAll(MyModule.class);
		return new JsonView(myModule);
	}
	public TextView Delete(int id) throws ActiveRecordException{
		MyModule myModule =MyModule.find(MyModule.class, id);
		myModule.destroy();
		return new TextView();
	}	
}
