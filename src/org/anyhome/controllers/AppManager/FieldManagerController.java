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
import org.anyhome.models.MyFieldValue;

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
	
	public  FreeMarkerView Details(int id) throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		List<MyFieldValue> myFieldValue = MyFieldValue.findAll(MyFieldValue.class,
				"V_FieldID=?",new Object[]{id});
		view.setAttribute("myFieldValue", myFieldValue);
		return view;
	}
	
	public JsonView Delete(int id) throws ActiveRecordException  {
		MyField myField = MyField.findFirst(MyField.class,
				"FieldID=?",new Object[]{id});
		myField.destroy();
		return new JsonView();
	}
	
	public JsonView SaveCreateFieldValue(MyFieldValue myFieldValue) throws ActiveRecordException{
		if(myFieldValue.save())
			return null;
		return new JsonView();
	}
	
	public JsonView SaveEditFieldValue(int id) throws Exception{
		MyFieldValue myFieldValue = MyFieldValue.findFirst(MyFieldValue.class,
				"ValueID=?",new Object[]{id});
		myFieldValue = MyField.updateModel(myFieldValue, request.getParameterMap());
		if (myFieldValue.save())
			return null;
		return new JsonView();
	}	
	public JsonView DeleteFieldValue(int id) throws ActiveRecordException  {
		MyFieldValue myFieldValue = MyFieldValue.findFirst(MyFieldValue.class,
				"ValueID=?",new Object[]{id});
		myFieldValue.destroy();
		return new JsonView();
	}
	

}
