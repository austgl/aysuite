/* ***********************************************
 * author :  Anyhome
 * email  :  ayhome@gmail.com 
 * function: 
 * @date 2009-12-27
 * history:  created by Anyhome
 * ***********************************************/
 
/**
 * 
 */
package org.anyhome.controllers.ProjectManager;

import java.util.List;

import org.anyhome.controllers.MemberController;
import org.anyhome.models.MyCustomers;

import com.et.ar.exception.ActiveRecordException;
import com.et.mvc.FreeMarkerView;

/**
 * @author anyhome
 *
 */
public class CustomersController extends MemberController {
	public FreeMarkerView index() throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();
		List<MyCustomers> myCustomers = MyCustomers.findAll(MyCustomers.class);
		view.setAttribute("myCustomers", myCustomers);
		return view;
	}
}
