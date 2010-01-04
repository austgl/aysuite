/* ***********************************************
 * author :  Anyhome
 * email  :  ayhome@gmail.com 
 * function: 
 * @date 2010-1-3
 * history:  created by Anyhome
 * ***********************************************/
 
/**
 * 
 */
package org.anyhome.controllers.AppManager;

import java.util.List;

import org.anyhome.controllers.AdminController;
import org.anyhome.models.MyField;

import com.et.ar.exception.ActiveRecordException;
import com.et.mvc.FreeMarkerView;
import com.et.mvc.JsonView;

/**
 * @author anyhome
 *
 */
public class FieldManagerController extends AdminController {
	
	public FreeMarkerView index() throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		List<MyField> myField =MyField.findAll(MyField.class);
		view.setAttribute("myField", myField);
		return view;
	}
	
	public FreeMarkerView Edit(){
		FreeMarkerView view = new FreeMarkerView();
		return view;
	}
	
	public JsonView SaveEdit(int id) throws Exception{
		MyField myField = MyField.findFirst(MyField.class,
				"FieldID=?",new Object[]{id});
		myField = MyField.updateModel(myField, request.getParameterMap());
		if (myField.save())
			return null;
		return new JsonView();
	}
	
	public FreeMarkerView Create(){
		return new FreeMarkerView();
	}
	
	public JsonView SaveCreate(MyField myField) throws ActiveRecordException{
		if(myField.save())
			return null;
		return new JsonView();
	}
	
	public JsonView Delete(int id) throws ActiveRecordException  {
		MyField myField = MyField.findFirst(MyField.class,
				"FieldID=?",new Object[]{id});
		myField.destroy();
		return new JsonView();
	}

}
