
/* ***********************************************
 * author :  Anyhome
 * email  :  ayhome@gmail.com 
 * function: 
 * @date 2009-10-30
 * history:  created by Anyhome
 * ***********************************************/
 
package org.anyhome.models;

import java.util.List;

import org.anyhome.OrmUtil;

import com.et.ar.ActiveRecordBase;
import com.et.ar.annotations.Column;
import com.et.ar.annotations.DependentType;
import com.et.ar.annotations.HasMany;
import com.et.ar.annotations.Id;
import com.et.ar.annotations.Table;
import com.et.ar.exception.ActiveRecordException;
@Table(name="Ay_Resources")
public class MyResources extends ActiveRecordBase {
			
			@Id private Integer ResID;
			
			@Column private String R_Name;
			
			@Column private Integer R_UserID;
			
			@Column private java.sql.Date R_Date;
			
			@Column private Integer R_ProductClassID;
			
			@Column private Integer R_GroupID;
			
			@Column private Integer R_JZ;
			
			@Column private String R_Remark;
			
			@HasMany(foreignKey="authorId", dependent=DependentType.DELETE)
			private List<MyResUsed> myResUseds;
			
			private MyUser User;
			
			private MyResUsed ResUsed;
							
			
			public void setResID(Integer T_ResID){
				ResID=T_ResID;
			}
			public Integer getResID() {
				return ResID;
			} 
			
			public void setR_Name(String T_R_Name){
				R_Name=T_R_Name;
			}
			public String getR_Name() {
				return R_Name;
			} 
			
			public void setR_UserID(Integer T_R_UserID){
				R_UserID=T_R_UserID;
			}
			public Integer getR_UserID() {
				return R_UserID;
			} 
			
			public void setR_Date(java.sql.Date T_R_Date){
				if (T_R_Date==null)
					T_R_Date = new java.sql.Date(new java.util.Date().getTime());
				R_Date=T_R_Date;
			}
			public java.sql.Date getR_Date() {
				return R_Date;
			} 
			
			public void setR_ProductClassID(Integer T_R_ProductClassID){
				R_ProductClassID=T_R_ProductClassID;
			}
			public Integer getR_ProductClassID() {
				return R_ProductClassID;
			} 
			
			public void setR_GroupID(Integer T_R_GroupID){
				R_GroupID=T_R_GroupID;
			}
			public Integer getR_GroupID() {
				return R_GroupID;
			} 
			
			public void setR_JZ(Integer T_R_JZ){
				R_JZ=T_R_JZ;
			}
			public Integer getR_JZ() {
				return R_JZ;
			} 
			
			public void setR_Remark(String T_R_Remark){
				R_Remark=T_R_Remark;
			}
			public String getR_Remark() {
				return R_Remark;
			}
			public void setUser(MyUser user) {
				User = user;
			}
			public MyUser getUser() throws ActiveRecordException {
				return OrmUtil.getUserById(this.R_UserID);
			}
			public void setResUsed(MyResUsed resUsed) {
				ResUsed = resUsed;
			}
			public MyResUsed getResUsed() throws ActiveRecordException {
				return OrmUtil.getResUsedById(this.ResID);
			}
			public void setMyResUseds(List<MyResUsed> myResUseds) {
				this.myResUseds = myResUseds;
			}
			public List<MyResUsed> getMyResUseds() {
				return myResUseds;
			} 
}
