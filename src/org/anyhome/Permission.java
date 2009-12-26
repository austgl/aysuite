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

import org.anyhome.models.MyRolePermission;
import com.et.ar.exception.ActiveRecordException;

/**
 * @author anyhome
 *
 */
public class Permission {
	
	static CacheManager cache = CacheManager.getInstance();
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
	
	public static Boolean CheckPermission(int UserID, int appId, String PageCode, int CheckValue) throws ActiveRecordException{
		Map<String,MyRolePermission> UserPermission = GetUserPermission(UserID);
		Boolean b = false;
		if (UserPermission!=null){
			String key = appId+"-"+PageCode;
			if (UserPermission.containsKey(key)){
					if((((MyRolePermission)UserPermission.get(key)).getP_Value()&CheckValue)==CheckValue){
						b = true;
					}
			}
		}
		return b;
	}
	
	@SuppressWarnings("unchecked")
	private static Map<String,MyRolePermission> GetUserPermission(int userId) throws ActiveRecordException{		
		String key = userId + "-Permission-AySuite";
		if (cache.get(key)!=null){
			return (Map<String, MyRolePermission>) cache.get(key);
		}else{
			cache.put(UserPermission(userId), key, new String[]{"key"});
			return (Map<String, MyRolePermission>) cache.get(key);
		}
	}
	
	private static Map<String,MyRolePermission> UserPermission(int userId) throws ActiveRecordException{
		Map<String,MyRolePermission> PageCodeList = new HashMap<String,MyRolePermission>();
		List<MyRolePermission> myRolePermission = MyRolePermission.findAll(MyRolePermission.class,
				"P_RoleID in (select R_RoleID from Ay_UserRoles where R_UserID=?)",
				new Object[]{userId});
		for (MyRolePermission item : myRolePermission){
			String key = item.getP_ApplicationID()+ "-"+item.getP_PageCode();
			if (PageCodeList.containsKey(key))
				PageCodeList.remove(key);
			PageCodeList.put(key, item);
		}
		return PageCodeList;
	}
	
}
