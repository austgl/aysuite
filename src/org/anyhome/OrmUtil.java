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
package org.anyhome;

import java.util.List;

import org.anyhome.models.MyModuleExtPermission;
import org.anyhome.models.MyResUsed;
import org.anyhome.models.MyUser;

import com.et.ar.exception.ActiveRecordException;

/**
 * @author anyhome
 *
 */
public class OrmUtil {

	public static MyUser getUserById(int id) throws ActiveRecordException{
		if (id<1)
			return null;
		return MyUser.find(MyUser.class,id);
	}
	
	public static MyResUsed getResUsedById(int id) throws ActiveRecordException{
		if (id<1)
			return null;
		return MyResUsed.findFirst(MyResUsed.class, "R_R_ResID=? order by ResUseID desc",
				new Object[]{id});
	}
	
	public static List<MyModuleExtPermission> getTheById(int id) throws ActiveRecordException{
		if (id<1)
			return null;
		return MyModuleExtPermission.findAll(MyModuleExtPermission.class, "ModuleID=? ",
				new Object[]{id});		
	}
}
