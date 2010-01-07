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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.anyhome.models.MyModule;
import org.anyhome.models.MyPermissionValue;
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
	 * 根据用户ID和controller给出action
	 * @param UserID
	 * @param Directory
	 * @return
	 * @throws ActiveRecordException
	 */
	public static List<String> CheckAndPermiss(int UserID,String Directory) throws ActiveRecordException{
		List<String> lst = new ArrayList<String>();
		for (String s:PopedomType().keySet()){
			if (CheckPermission(UserID,Directory,PopedomType().get(s))){
				MyPermissionValue PermissionValue = new MyPermissionValue();
				PermissionValue.setPermissName(s);
				PermissionValue.setPermissValue(Permission.PopedomType().get(s));							
				lst.add(s);					
			}
		}
		return lst;
	}
	
	/**
	 * 根据用户ID controller 检查是否包含 权限值 CheckValue
	 * @param UserID
	 * @param appId
	 * @param Directory
	 * @param CheckValue
	 * @return
	 * @throws ActiveRecordException
	 */
	public static Boolean CheckPermission(int UserID,String Directory, int CheckValue) throws ActiveRecordException{				

		//int PermissValue = MaxPermissionValue(UserID,Directory);
		List<MyRolePermission> myRolePermission =PermissionValueList(UserID,Directory);
		if (myRolePermission==null)
			return false;
		for(MyRolePermission itme:myRolePermission){
			//System.out.println(Directory+"-"+CheckValue);
			if ((itme.getP_Value()&CheckValue)==CheckValue)
				return true;
		}
		return false;
	}	
	
	/**
	 * 根据用户获取所属角色
	 * @param userId
	 * @return
	 * @throws ActiveRecordException
	 */
	@SuppressWarnings({ "unchecked"})
	private static List<MyUserRoles> UserRoles(int userId) throws ActiveRecordException{
		String key = userId + "-Roles";
		if (cache.get(key)!=null){			
			return (List<MyUserRoles>)cache.get(key);
		}else{
			List<MyUserRoles> Roles = MyUserRoles.findAll(MyUserRoles.class,
					"R_UserID=?",new Object[]{userId});
			cache.put(Roles, key, new String[]{"UserRoleskey"});
			return (List<MyUserRoles>)cache.get(key);
		}
	}
	
	/**
	 * 根据角色和模块代码 获取 权限实体
	 * @param rolesId
	 * @param PageCode
	 * @return
	 * @throws ActiveRecordException
	 */
	private static MyRolePermission RolePermission(int rolesId,String PageCode) throws ActiveRecordException{
		String key = rolesId + "-Permission-"+PageCode;
		MyRolePermission e = new MyRolePermission();
		if (cache.get(key)!=null){
			return (MyRolePermission)cache.get(key);			
		}else{
			e = MyRolePermission.findFirst(MyRolePermission.class,
					"P_RoleID=? and P_PageCode=?",new Object[]{rolesId,PageCode});
			if (e!=null){
				cache.put(e, key, new String[]{"RolePermissionkey"});
				return (MyRolePermission)cache.get(key);
			}else{
				return null;
			}			
		}
	}
	
	/**
	 * 列出指定用户的所有 MyRolePermission
	 * @param userId
	 * @param Directory
	 * @return
	 * @throws ActiveRecordException
	 */
	public static List<MyRolePermission> PermissionValueList(int userId,String Directory) throws ActiveRecordException{
		List<MyUserRoles> userRoles = UserRoles(userId);
		if (UserRoles(userId)==null)
			return null;
		String key = Directory + "-Directory-Module";			
		String PageCode = "";
		if (cache.get(key)!=null){
			PageCode = ((MyModule)cache.get(key)).getM_PageCode();
		}else{
			MyModule myModule = MyModule.findFirst(MyModule.class,
					"M_Directory=?",new Object[]{Directory});
			cache.put(myModule, key, new String[]{"Modulekey"});
			PageCode = ((MyModule)cache.get(key)).getM_PageCode();
		}
		List<MyRolePermission> myRolePermission = new ArrayList<MyRolePermission>();
		for(MyUserRoles item:userRoles){
			MyRolePermission e = RolePermission(item.getR_RoleID(),PageCode);
			if (e!=null)
				myRolePermission.add(e);
		}		
		return myRolePermission;
	}
	
	/**
	 * 根据目录名称获和用户ID取最大权限值
	 * @param userId
	 * @param Directory
	 * @return
	 * @throws ActiveRecordException
	 */
	public static Integer MaxPermissionValue(int userId,String Directory) throws ActiveRecordException{				
		List<MyRolePermission> myRolePermission =PermissionValueList(userId,Directory);
		int maxValue =0;
		for(MyRolePermission item:myRolePermission){
			if (maxValue<item.getP_Value())
				maxValue=item.getP_Value();
		}
		return maxValue;
	}

	
}
