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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.anyhome.AMF3View;
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
		if(myModule.save())
			return null;
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
	
	public AMF3View List(int id) throws ActiveRecordException{
		List<MyModule> myModule = MyModule.findAll(MyModule.class,"M_ParentID=? and M_Close=0",
				new Object[]{id});
		List<Map> lst = new ArrayList<Map>(); 
		for(MyModule items:myModule)
		{
			lst.add(PojoToMap(items));
		}
		return new AMF3View(lst);
	}
	public TextView Delete(int id) throws ActiveRecordException{
		MyModule myModule =MyModule.find(MyModule.class, id);
		myModule.destroy();
		return new TextView();
	}	
}
