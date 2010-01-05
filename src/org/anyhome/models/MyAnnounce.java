
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
@Table(name="ay_announce")
public class MyAnnounce extends ActiveRecordBase {
			
			@Id private String AnnounceID;
			
			@Column private Integer A_GroupID;
			
			@Column private Integer A_UserID;
			
			@Column private String A_Announce;
			
			@Column private String A_Title;
			
			@Column private String A_UpDtime;
			
			@Column private String A_A_ArchiverCode;
			
			@Column private Integer A_AdminID;
			
			@Column private String A_Type;
		
			
			public void setAnnounceID(String T_AnnounceID){
				AnnounceID=T_AnnounceID;
			}
			public String getAnnounceID() {
				return AnnounceID;
			} 
			
			public void setA_GroupID(Integer T_A_GroupID){
				A_GroupID=T_A_GroupID;
			}
			public Integer getA_GroupID() {
				return A_GroupID;
			} 
			
			public void setA_UserID(Integer T_A_UserID){
				A_UserID=T_A_UserID;
			}
			public Integer getA_UserID() {
				return A_UserID;
			} 
			
			public void setA_Announce(String T_A_Announce){
				A_Announce=T_A_Announce;
			}
			public String getA_Announce() {
				return A_Announce;
			} 
			
			public void setA_Title(String T_A_Title){
				A_Title=T_A_Title;
			}
			public String getA_Title() {
				return A_Title;
			} 
			
			public void setA_UpDtime(String T_A_UpDtime){
				A_UpDtime=T_A_UpDtime;
			}
			public String getA_UpDtime() {
				return A_UpDtime;
			} 
			
			public void setA_A_ArchiverCode(String T_A_A_ArchiverCode){
				A_A_ArchiverCode=T_A_A_ArchiverCode;
			}
			public String getA_A_ArchiverCode() {
				return A_A_ArchiverCode;
			} 
			
			public void setA_AdminID(Integer T_A_AdminID){
				A_AdminID=T_A_AdminID;
			}
			public Integer getA_AdminID() {
				return A_AdminID;
			} 
			
			public void setA_Type(String T_A_Type){
				A_Type=T_A_Type;
			}
			public String getA_Type() {
				return A_Type;
			} 
}
