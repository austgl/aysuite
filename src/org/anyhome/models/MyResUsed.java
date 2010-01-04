
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
import com.et.ar.annotations.Id;
import com.et.ar.annotations.Table;
@Table(name="Ay_ResUsed")
public class MyResUsed extends ActiveRecordBase {
			
			@Id private Integer ResUseID;
			
			@Column private String R_Remark;
			
			@Column private Integer R_UserID;
			
			@Column private Integer R_UseGuestID;
			
			@Column private String R_ResName;
			
			@Column private String R_State;
			
			@Column private String R_Useway;
			
			@Column private java.sql.Date R_Dtime;
			
			@Column private java.sql.Date R_UpDtime;
			
			@Column private java.sql.Date R_LastDtime;
			
			@Column private String R_Code;
			
			@Column private Integer R_R_ResID;		
			
			public void setResUseID(Integer T_ResUseID){
				ResUseID=T_ResUseID;
			}
			public Integer getResUseID() {
				return ResUseID;
			} 
			
			public void setR_Remark(String T_R_Remark){
				R_Remark=T_R_Remark;
			}
			public String getR_Remark() {
				return R_Remark;
			} 
			
			public void setR_UserID(Integer T_R_UserID){
				R_UserID=T_R_UserID;
			}
			public Integer getR_UserID() {
				return R_UserID;
			} 
			
			public void setR_UseGuestID(Integer T_R_UseGuestID){
				R_UseGuestID=T_R_UseGuestID;
			}
			public Integer getR_UseGuestID() {
				return R_UseGuestID;
			} 
			
			public void setR_ResName(String T_R_ResName){
				R_ResName=T_R_ResName;
			}
			public String getR_ResName() {
				return R_ResName;
			} 
			
			public void setR_State(String T_R_State){
				R_State=T_R_State;
			}
			public String getR_State() {
				return R_State;
			} 
			
			public void setR_Useway(String T_R_Useway){
				R_Useway=T_R_Useway;
			}
			public String getR_Useway() {
				return R_Useway;
			} 
			
			public void setR_Dtime(java.sql.Date T_R_Dtime){
				if (T_R_Dtime==null)
					T_R_Dtime = new java.sql.Date(new java.util.Date().getTime());				
				R_Dtime=T_R_Dtime;
			}
			public java.sql.Date getR_Dtime() {
				return R_Dtime;
			} 
			
			public void setR_UpDtime(java.sql.Date T_R_UpDtime){
				R_UpDtime=T_R_UpDtime;
			}
			public java.sql.Date getR_UpDtime() {
				return R_UpDtime;
			} 
			
			public void setR_LastDtime(java.sql.Date T_R_LastDtime){
				R_LastDtime=T_R_LastDtime;
			}
			public java.sql.Date getR_LastDtime() {
				return R_LastDtime;
			} 
			
			public void setR_Code(String T_R_Code){
				R_Code=T_R_Code;
			}
			public String getR_Code() {
				return R_Code;
			}
			public void setR_R_ResID(Integer r_R_ResID) {
				R_R_ResID = r_R_ResID;
			}
			public Integer getR_R_ResID() {
				return R_R_ResID;
			} 
}
