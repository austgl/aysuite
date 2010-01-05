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
import org.anyhome.models.MyAnnounce;

import com.et.ar.exception.ActiveRecordException;
import com.et.mvc.FreeMarkerView;
import com.et.mvc.JsonView;

/**
 * @author anyhome
 *
 */
public class AnnounceController extends MemberController {
	
	public FreeMarkerView index() throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		List<MyAnnounce> myAnnounce = MyAnnounce.findAll(MyAnnounce.class);
		view.setAttribute("myAnnounce", myAnnounce);
		return view;
	}
	
	public FreeMarkerView Create (){
		return new FreeMarkerView();
	}
	
	public JsonView SaveCreate(MyAnnounce myAnnounce) throws ActiveRecordException{
		if(myAnnounce.save())
			return null;
		return new JsonView();		
	}
	
	public FreeMarkerView Edit(int id) throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		MyAnnounce myAnnounce=MyAnnounce.find(MyAnnounce.class, id);
		view.setAttribute("myAnnounce", myAnnounce);
		return view;
	}
	
	public JsonView SaveEdit(int id) throws Exception  {
		MyAnnounce myAnnounce=MyAnnounce.find(MyAnnounce.class, id);
		myAnnounce = MyAnnounce.updateModel(myAnnounce, request.getParameterMap());
		if(myAnnounce.save())
			return null;
		return new JsonView(); 
	}
	
	public JsonView Delete(int id) throws ActiveRecordException{
		MyAnnounce myAnnounce=MyAnnounce.find(MyAnnounce.class, id);
		myAnnounce.destroy();
		return new JsonView();
	}

}
