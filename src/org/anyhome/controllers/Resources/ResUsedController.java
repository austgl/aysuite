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

import java.util.List;

import org.anyhome.controllers.MemberController;
import org.anyhome.models.MyResUsed;

import com.et.ar.exception.ActiveRecordException;
import com.et.mvc.FreeMarkerView;
import com.et.mvc.JsonView;

/**
 * @author anyhome
 *
 */
public class ResUsedController extends MemberController {
	
	public FreeMarkerView index() throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		List<MyResUsed> myResUsed = MyResUsed.findAll(MyResUsed.class);
		view.setAttribute("myResUsed", myResUsed);
		return view;		
	}
	
	public FreeMarkerView Edit(int id) throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		MyResUsed myResUsed = MyResUsed.find(MyResUsed.class, id);
		view.setAttribute("myResUsed", myResUsed);
		return view;
	}
	
	public JsonView SaveEdit(int id) throws Exception{
		MyResUsed myResUsed = MyResUsed.find(MyResUsed.class, id);
		myResUsed = MyResUsed.updateModel(myResUsed, request.getParameterMap());
		if (myResUsed.save())
			return null;
		return new JsonView();
	}
	
	public FreeMarkerView Create(){
		return new FreeMarkerView();
	}
	
	public JsonView SaveCreate(MyResUsed myResUsed) throws ActiveRecordException{
		if (myResUsed.save()){
			return null;
		}
		return new JsonView();
	}
	
	public JsonView Delete(int id) throws ActiveRecordException{
		MyResUsed myResUsed = MyResUsed.find(MyResUsed.class, id);
		myResUsed.destroy();
		return new JsonView();
	}

}
