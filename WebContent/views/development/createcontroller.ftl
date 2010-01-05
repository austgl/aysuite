
/* ***********************************************
 * author :  Anyhome
 * email  :  ayhome@gmail.com 
 * function: 
 * @date 2010-1-4
 * history:  created by Anyhome
 * ***********************************************/
 
/**
 * 
 */
package org.anyhome.controllers.PublicInfo;

import java.util.List;

import org.anyhome.controllers.MemberController;
import org.anyhome.models.My${myDevelopment.controllerName?cap_first};

import com.et.ar.exception.ActiveRecordException;
import com.et.mvc.FreeMarkerView;
import com.et.mvc.JsonView;

/**
 * @author anyhome
 *
 */
public class ${myDevelopment.controllerName?cap_first}Controller extends MemberController {
	
	public FreeMarkerView index() throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		List<My${myDevelopment.controllerName?cap_first}> my${myDevelopment.controllerName?cap_first} = My${myDevelopment.controllerName?cap_first}.findAll(My${myDevelopment.controllerName?cap_first}.class);
		view.setAttribute("my${myDevelopment.controllerName?cap_first}", my${myDevelopment.controllerName?cap_first});
		return view;
	}
	
	public FreeMarkerView Create (){
		return new FreeMarkerView();
	}
	
	public JsonView SaveCreate(My${myDevelopment.controllerName?cap_first} my${myDevelopment.controllerName?cap_first}) throws ActiveRecordException{
		if(my${myDevelopment.controllerName?cap_first}.save())
			return null;
		return new JsonView();		
	}
	
	public FreeMarkerView Edit(int id) throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		My${myDevelopment.controllerName?cap_first} my${myDevelopment.controllerName?cap_first}=My${myDevelopment.controllerName?cap_first}.find(My${myDevelopment.controllerName?cap_first}.class, id);
		view.setAttribute("my${myDevelopment.controllerName?cap_first}", my${myDevelopment.controllerName?cap_first});
		return view;
	}
	
	public JsonView SaveEdit(int id) throws Exception  {
		My${myDevelopment.controllerName?cap_first} my${myDevelopment.controllerName?cap_first}=My${myDevelopment.controllerName?cap_first}.find(My${myDevelopment.controllerName?cap_first}.class, id);
		my${myDevelopment.controllerName?cap_first} = My${myDevelopment.controllerName?cap_first}.updateModel(my${myDevelopment.controllerName?cap_first}, request.getParameterMap());
		if(my${myDevelopment.controllerName?cap_first}.save())
			return null;
		return new JsonView(); 
	}
	
	public JsonView Delete(int id) throws ActiveRecordException{
		My${myDevelopment.controllerName?cap_first} my${myDevelopment.controllerName?cap_first}=My${myDevelopment.controllerName?cap_first}.find(My${myDevelopment.controllerName?cap_first}.class, id);
		my${myDevelopment.controllerName?cap_first}.destroy();
		return new JsonView();
	}

}
