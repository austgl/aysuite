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
package org.anyhome;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.anyhome.models.MyModule;
import org.anyhome.models.MyRolePermission;
import org.anyhome.models.MyUserRoles;

import com.et.ar.exception.ActiveRecordException;

/**
 * @author anyhome
 *
 */
public class Permission {
	
	public static CacheManager cache = CacheManager.getInstance();
	@SuppressWarnings("unchecked")	
	public static Map<String, Integer> PopedomType(){		
		Map<String, Integer> popedomType = new HashMap<String, Integer>();
		if (cache.get("popedomType")==null){			
			popedomType.put("Details", 2);		
			popedomType.put("Create", 4);
			popedomType.put("Edit", 8);
			popedomType.put("Delete", 16);
			popedomType.put("Orderby", 32);
			popedomType.put("Print", 64);
			popedomType.put("List", 128);	
			cache.put(popedomType, "popedomType", new String[] {"groups"});
		}else{
			popedomType = (Map<String, Integer>)cache.get("popedomType");		
		}
		return popedomType;		
	}
	/**
	 * 
	 * @param UserID
	 * @param appId
	 * @param PageCode
	 * @param CheckValue
	 * @return
	 * @throws ActiveRecordException
	 */
	public static Boolean CheckPermission(int UserID, int appId, String PageCode, int CheckValue) throws ActiveRecordException{				
		MyRolePermission RolePermission = RolePermission(appId,PageCode);//先获取所属权限的角色
		if (RolePermission==null)
			return false;
		int roleId = RolePermission.getP_RoleID();
		String key = roleId + "-Roles";
		//根据用户用户得到对应角色MAP 再查找是否存在于其中
		if (UserInRoles(UserID).get(key)==null){
			return false;
		}else if( (RolePermission.getP_Value()&CheckValue)==CheckValue ){
			return true;
		}else{
			return false;
		}
	}	

	/**
	 * 根据用户ID获取所属角色MAP 可用于检查用户是否属于某个角色
	 * @param userId
	 * @return
	 * @throws ActiveRecordException
	 */
	@SuppressWarnings("unchecked")
	private static Map<String,List<MyUserRoles>> UserInRoles(int userId) throws ActiveRecordException{		
		String key = userId + "-Roles";
		Map<String,MyUserRoles> m = new HashMap<String, MyUserRoles>();
		if (cache.get(key)!=null){
			return (Map<String,List<MyUserRoles>>) cache.get(key);
		}else{
			List<MyUserRoles> UserRoles = MyUserRoles.findAll(MyUserRoles.class,
					"R_UserID=?",new Object[]{userId});
			for(MyUserRoles item:UserRoles){
				String k = item.getR_RoleID().toString() + "-Roles";
				m.put(k, item);				
			}
			cache.put(m, key, new String[]{"UserRoleskey"});
			return (Map<String,List<MyUserRoles>>) cache.get(key);
		}
	}
	
	/**
	 * 
	 * @param appId
	 * @param PageCode
	 * @returnMyRolePermission
	 * @throws ActiveRecordException
	 */
	private static MyRolePermission RolePermission(int appId, String PageCode) throws ActiveRecordException{		
		String key = appId+ "-"+PageCode;
		if (cache.get(key)!=null){
			return (MyRolePermission)cache.get(key);
		}else{
			MyRolePermission myRolePermission = MyRolePermission.findFirst(MyRolePermission.class,
					"P_ApplicationID=? and P_PageCode=?",new Object[]{appId,PageCode});
			if (myRolePermission!=null){
				cache.put(myRolePermission, key, new String[]{"Permissionkey"});
				myRolePermission = (MyRolePermission)cache.get(key);
			}else{
				myRolePermission = null;
			}
			
			return myRolePermission;
		}
	}
	
	public static Integer PermissionValue(String Directory) throws ActiveRecordException{		
		String key = Directory + "-Directory-Module";
		String PageCode = "";
		int appId = 0;
		if (cache.get(key)!=null){
			appId = ((MyModule)cache.get(key)).getM_ApplicationID();
			PageCode = ((MyModule)cache.get(key)).getM_PageCode();
			System.out.println("cache PermissionValue");
		}else{
			MyModule myModule = MyModule.findFirst(MyModule.class,
					"M_Directory=?",new Object[]{Directory});
			cache.put(myModule, key, new String[]{"Modulekey"});
			appId = ((MyModule)cache.get(key)).getM_ApplicationID();
			PageCode = ((MyModule)cache.get(key)).getM_PageCode();
		}
		MyRolePermission mm = RolePermission(appId,PageCode);
		if (mm==null)
			return 0;
		else
			return mm.getP_Value();
	}
	
}
