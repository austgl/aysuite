/* ***********************************************
 * author :  Anyhome
 * email  :  ayhome@gmail.com 
 * function: 
 * @date 2009-12-19
 * history:  created by Anyhome
 * ***********************************************/
 
/**
 * 
 */
package org.anyhome.controllers.AppManager;

import java.util.List;

import org.anyhome.controllers.AdminController;
import org.anyhome.models.MyGroup;

import com.et.ar.exception.ActiveRecordException;
import com.et.mvc.FreeMarkerView;
import com.et.mvc.JsonView;

/**
 * @author anyhome
 *
 */
public class GroupController extends AdminController {
	public FreeMarkerView index() throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		List<MyGroup> myGroup = MyGroup.findAll(MyGroup.class);
		view.setAttribute("myGroup", myGroup);
		return view;
	}
	
	public FreeMarkerView Create(){
		return new FreeMarkerView();
	}
	
	public JsonView SaveCreate(MyGroup myGroup) throws ActiveRecordException{
		if (myGroup.save())
			return null;
		return new JsonView();
	}
	
	public JsonView SaveEdit(int id) throws Exception{
		MyGroup myGroup = MyGroup.find(MyGroup.class, id);
		myGroup = MyGroup.updateModel(myGroup, request.getParameterMap());
		if (myGroup.save())
			return null;
		return new JsonView();
	}
	
	public JsonView Delete(int id) throws ActiveRecordException{
		MyGroup myGroup = MyGroup.find(MyGroup.class, id);
		myGroup.destroy();
		return new JsonView();
	}

}
