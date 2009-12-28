
/* ***********************************************
 * author :  Anyhome
 * email  :  ayhome@gmail.com 
 * function: 
 * @date 2009-10-30
 * history:  created by Anyhome
 * ***********************************************/
 
package org.anyhome.models;

import java.util.Date;

import org.anyhome.DateConverter;

import com.et.ar.ActiveRecordBase;
import com.et.ar.ConvertUtil;
import com.et.ar.annotations.Column;
import com.et.ar.annotations.HasOne;
import com.et.ar.annotations.Id;
import com.et.ar.annotations.Table;
@Table(name="Ay_BugTracker")
public class MyBugTracker extends ActiveRecordBase {
	static{
		ConvertUtil.register(new DateConverter(), java.sql.Date.class);
	}
			
			@Id private Integer BugID;
			
			@Column private Integer B_Userid;
			
			@Column private String B_Url;
			
			@Column private String B_Module;
			
			@Column private String B_BugContent;
			
			@Column private Date B_Dtime;
			
			@Column private Date B_IsUpdate;
			
			@Column private Date B_Updata;
			
			@HasOne(foreignKey="UserID")
			private MyUser myUser;
			
			public void setBugID(Integer T_BugID){
				BugID=T_BugID;
			}
			public Integer getBugID() {
				return BugID;
			} 
			
			public void setB_Userid(Integer T_B_Userid){
				B_Userid=T_B_Userid;
			}
			public Integer getB_Userid() {
				return B_Userid;
			} 
			
			public void setB_Url(String T_B_Url){
				B_Url=T_B_Url;
			}
			public String getB_Url() {
				return B_Url;
			} 
			
			public void setB_Module(String T_B_Module){
				B_Module=T_B_Module;
			}
			public String getB_Module() {
				return B_Module;
			} 
			
			public void setB_BugContent(String T_B_BugContent){
				B_BugContent=T_B_BugContent;
			}
			public String getB_BugContent() {
				return B_BugContent;
			} 
			
			public void setB_Dtime(Date T_B_Dtime){
				B_Dtime=T_B_Dtime;
			}
			public Date getB_Dtime() {
				return B_Dtime;
			} 
			
			public void setB_IsUpdate(Date T_B_IsUpdate){
				B_IsUpdate=T_B_IsUpdate;
			}
			public Date getB_IsUpdate() {
				return B_IsUpdate;
			} 
			public void setB_Updata(Date T_B_Updata){
				B_Updata=T_B_Updata;
			}
			public Date getB_Updata() {
				return B_Updata;
			}
			public void setMyUser(MyUser myUser) {
				this.myUser = myUser;
			}
			public MyUser getMyUser() {
				return myUser;
			} 
}
