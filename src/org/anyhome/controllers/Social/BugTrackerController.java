/* ***********************************************
 * author :  Anyhome
 * email  :  ayhome@gmail.com 
 * function: 
 * @date 2009-12-26
 * history:  created by Anyhome
 * ***********************************************/
 
/**
 * 
 */
package org.anyhome.controllers.Social;


import java.util.List;

import org.anyhome.controllers.MemberController;
import org.anyhome.models.MyBugTracker;

import com.et.ar.exception.ActiveRecordException;
import com.et.mvc.FreeMarkerView;
import com.et.mvc.JsonView;

/**
 * @author anyhome
 *
 */
public class BugTrackerController extends MemberController {

	public FreeMarkerView index() throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		List<MyBugTracker> myBugTracker = MyBugTracker.findAll(MyBugTracker.class);
		view.setAttribute("myBugTracker", myBugTracker);		
		return view;
	}
	
	public FreeMarkerView Details(int id) throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		MyBugTracker myBugTracker = MyBugTracker.find(MyBugTracker.class, id);
		view.setAttribute("myBugTracker", myBugTracker);
		return view;
	}
	
	public FreeMarkerView Edit(int id) throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		MyBugTracker myBugTracker = MyBugTracker.find(MyBugTracker.class, id);
		view.setAttribute("myBugTracker", myBugTracker);
		return view;		
	}
	
	public JsonView SaveEdit(int id) throws Exception{
		MyBugTracker myBugTracker = MyBugTracker.find(MyBugTracker.class, id);
		myBugTracker = MyBugTracker.updateModel(myBugTracker, request.getParameterMap());
		if (myBugTracker.save())
			return null;
		return new JsonView();
	}
	
	public FreeMarkerView Create(){
		return new FreeMarkerView();
	}
	
	public JsonView SaveCreate(MyBugTracker myBugTracker) throws ActiveRecordException{
		if(myBugTracker.save())
			return null;
		return new JsonView();
	}
	
	public JsonView Delete(int id) throws ActiveRecordException{
		MyBugTracker myBugTracker = MyBugTracker.find(MyBugTracker.class, id);
		myBugTracker.destroy();
		return new JsonView();
	}
}