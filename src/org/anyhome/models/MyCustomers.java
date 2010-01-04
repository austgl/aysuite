
/* ***********************************************
 * author :  Anyhome
 * email  :  ayhome@gmail.com 
 * function: 
 * @date 2009-10-30
 * history:  created by Anyhome
 * ***********************************************/
 
package org.anyhome.models;

import org.anyhome.OrmUtil;

import com.et.ar.ActiveRecordBase;
import com.et.ar.annotations.Column;
import com.et.ar.annotations.Id;
import com.et.ar.annotations.Table;
import com.et.ar.exception.ActiveRecordException;
@Table(name="Ay_Customers")
public class MyCustomers extends ActiveRecordBase {
			
			@Id private Integer CustomerID;
			
			@Column private String C_CustomerName;
			
			@Column private String C_State;
			
			@Column private String C_City;
			
			@Column private String C_Address;
			
			@Column private String C_Zip_Code;
			
			@Column private String C_Tel;
			
			@Column private String C_Fax;
			
			@Column private String C_Email;
			
			@Column private Integer C_Trade;
			
			@Column private String C_Description;
			
			@Column private String C_Available;
			
			@Column private Integer C_UserID;
			
			@Column private java.sql.Date C_Update;
			
			private MyUser User;
		
			
			public void setCustomerID(Integer T_CustomerID){
				CustomerID=T_CustomerID;
			}
			public Integer getCustomerID() {
				return CustomerID;
			} 
			
			public void setC_CustomerName(String T_C_CustomerName){
				C_CustomerName=T_C_CustomerName;
			}
			public String getC_CustomerName() {
				return C_CustomerName;
			} 
			
			public void setC_State(String T_C_State){
				C_State=T_C_State;
			}
			public String getC_State() {
				return C_State;
			} 
			
			public void setC_City(String T_C_City){
				C_City=T_C_City;
			}
			public String getC_City() {
				return C_City;
			} 
			
			public void setC_Address(String T_C_Address){
				C_Address=T_C_Address;
			}
			public String getC_Address() {
				return C_Address;
			} 
			
			public void setC_Zip_Code(String T_C_Zip_Code){
				C_Zip_Code=T_C_Zip_Code;
			}
			public String getC_Zip_Code() {
				return C_Zip_Code;
			} 
			
			public void setC_Tel(String T_C_Tel){
				C_Tel=T_C_Tel;
			}
			public String getC_Tel() {
				return C_Tel;
			} 
			
			public void setC_Fax(String T_C_Fax){
				C_Fax=T_C_Fax;
			}
			public String getC_Fax() {
				return C_Fax;
			} 
			
			public void setC_Email(String T_C_Email){
				C_Email=T_C_Email;
			}
			public String getC_Email() {
				return C_Email;
			} 
			
			public void setC_Trade(Integer T_C_Trade){
				C_Trade=T_C_Trade;
			}
			public Integer getC_Trade() {
				return C_Trade;
			} 
			
			public void setC_Description(String T_C_Description){
				C_Description=T_C_Description;
			}
			public String getC_Description() {
				return C_Description;
			} 
			
			public void setC_Available(String T_C_Available){
				C_Available=T_C_Available;
			}
			public String getC_Available() {
				return C_Available;
			} 
			
			public void setC_UserID(Integer T_C_UserID){
				C_UserID=T_C_UserID;
			}
			public Integer getC_UserID() {
				return C_UserID;
			} 
			
			public void setC_Update(java.sql.Date T_C_Update){
				C_Update=T_C_Update;
			}
			public java.sql.Date getC_Update() {
				return C_Update;
			}
			public void setUser(MyUser user) {
				User = user;
			}
			public MyUser getUser() throws ActiveRecordException {
				return OrmUtil.getUserById(this.C_UserID);
			} 
			
}			