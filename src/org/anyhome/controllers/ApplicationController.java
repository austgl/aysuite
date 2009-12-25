/* ***********************************************
 * author :  Anyhome
 * email  :  ayhome@gmail.com 
 * function: 
 * @date 2009-10-29
 * history:  created by Anyhome
 * ***********************************************/
 
package org.anyhome.controllers;

import java.util.HashMap;
import java.util.Map;

import org.anyhome.models.MyHelpers;

import com.et.mvc.Controller;
import com.et.mvc.filter.AroundFilter;
import com.et.mvc.filter.BeforeFilter;

@AroundFilter(execute=org.anyhome.AroundFilter.class)
public class ApplicationController extends BaseController {		

	protected static Map<String, Integer> PopedomType(){
		Map<String, Integer> popedomType = new HashMap<String, Integer>();
		popedomType.put("Details", 2);		
		popedomType.put("Create", 4);
		popedomType.put("Edit", 8);
		popedomType.put("Delete", 16);
		popedomType.put("Orderby", 32);
		popedomType.put("Print", 64);
		popedomType.put("List", 128);
		return popedomType;		
	}
	protected Map PojoToMap(Object obj) {
		  Map hashMap = new HashMap();
		  try {
		   Class c = obj.getClass();
		   java.lang.reflect.Method m[] = c.getDeclaredMethods();
		   for (int i = 0; i < m.length; i++) {
		    if (m[i].getName().indexOf("get")==0) {
		     hashMap.put(m[i].getName(), m[i].invoke(obj, new Object[0]));
		    }
		   }
		  } catch (Throwable e) {
		   System.err.println(e);
		  }
		  return hashMap;
		}
}
