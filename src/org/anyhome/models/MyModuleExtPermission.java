
/* ***********************************************
 * author :  Anyhome
 * email  :  ayhome@gmail.com 
 * function: 
 * @date 2009-10-30
 * history:  created by Anyhome
 * ***********************************************/
 
package org.anyhome.models;

import com.et.ar.ActiveRecordBase;
import com.et.ar.annotations.Column;
import com.et.ar.annotations.Table;
@Table(name="ay_moduleextpermission")
public class MyModuleExtPermission extends ActiveRecordBase {
			
			@Column private Integer ExtPermissionID;
			
			@Column private Integer ModuleID;
			
			@Column private String PermissionName;
			
			@Column private Integer PermissionValue;
		
			
			public void setExtPermissionID(Integer T_ExtPermissionID){
				ExtPermissionID=T_ExtPermissionID;
			}
			public Integer getExtPermissionID() {
				return ExtPermissionID;
			} 
			
			public void setModuleID(Integer T_ModuleID){
				ModuleID=T_ModuleID;
			}
			public Integer getModuleID() {
				return ModuleID;
			} 
			
			public void setPermissionName(String T_PermissionName){
				PermissionName=T_PermissionName;
			}
			public String getPermissionName() {
				return PermissionName;
			} 
			
			public void setPermissionValue(Integer T_PermissionValue){
				PermissionValue=T_PermissionValue;
			}
			public Integer getPermissionValue() {
				return PermissionValue;
			} 
}
