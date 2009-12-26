
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
@Table(name="Ay_UserRoles")
public class MyUserRoles extends ActiveRecordBase {
			
			@Column private Integer R_UserID;
			
			@Column private Integer R_RoleID;
					
			public void setR_UserID(Integer T_R_UserID){
				R_UserID=T_R_UserID;
			}
			public Integer getR_UserID() {
				return R_UserID;
			} 
			
			public void setR_RoleID(Integer T_R_RoleID){
				R_RoleID=T_R_RoleID;
			}
			public Integer getR_RoleID() {
				return R_RoleID;
			} 
}
