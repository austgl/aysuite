/* ***********************************************
 * author :  Anyhome
 * email  :  ayhome@gmail.com 
 * function: 
 * @date 2009-10-29
 * history:  created by Anyhome
 * ***********************************************/
 
package org.anyhome.models;

import com.et.ar.ActiveRecordBase;
import com.et.ar.annotations.Column;
import com.et.ar.annotations.Id;
import com.et.ar.annotations.Table;

@Table(name="Ay_User")
public class MyUser extends ActiveRecordBase {
	@Id private Integer UserID;
	@Column private String U_LoginName;
	@Column private String U_Password;
	@Column private String U_CName;
	@Column private String U_EName;
	@Column private Integer U_GroupID;
	@Column private String U_Email;
	@Column private Integer U_Type;
	@Column private String U_Status;
	@Column private String U_Licence;
	@Column private String U_Mac;
	@Column private String U_Remark;
	@Column private String U_IDCard;
	@Column private String U_Sex;
	@Column private String U_BirthDay;
	@Column private String U_MobileNo;
	@Column private String U_UserNO;
	@Column private String U_WorkStartDate;
	@Column private String U_WorkEndDate;
	@Column private String U_CompanyMail;
	@Column private Integer U_Title;
	@Column private String U_Extension;
	@Column private String U_HomeTel;
	@Column private String U_PhotoUrl;
	@Column private String U_DateTime;
	@Column private String U_LastIP;
	@Column private String U_LastDateTime;
	@Column private String U_ExtendField;
	@Column private String U_Education;
	@Column private String U_Wedding;
	@Column private String U_MailingAddress;
	@Column private String U_PativePlace;
	@Column private String U_PativePlaceAdd;
	/**
	 * @return the userID
	 */
	public Integer getUserID() {
		return UserID;
	}
	/**
	 * @param u_LoginName the u_LoginName to set
	 */
	public void setU_LoginName(String u_LoginName) {
		U_LoginName = u_LoginName;
	}
	/**
	 * @return the u_LoginName
	 */
	public String getU_LoginName() {
		return U_LoginName;
	}
	/**
	 * @param u_Password the u_Password to set
	 */
	public void setU_Password(String u_Password) {
		U_Password = u_Password;
	}
	/**
	 * @return the u_Password
	 */
	public String getU_Password() {
		return U_Password;
	}
	/**
	 * @param u_CName the u_CName to set
	 */
	public void setU_CName(String u_CName) {
		U_CName = u_CName;
	}
	/**
	 * @return the u_CName
	 */
	public String getU_CName() {
		return U_CName;
	}
	public void setU_EName(String u_EName) {
		U_EName = u_EName;
	}
	public String getU_EName() {
		return U_EName;
	}
	public void setU_GroupID(Integer u_GroupID) {
		U_GroupID = u_GroupID;
	}
	public Integer getU_GroupID() {
		return U_GroupID;
	}
	public void setU_Email(String u_Email) {
		U_Email = u_Email;
	}
	public String getU_Email() {
		return U_Email;
	}
	public void setU_Type(Integer u_Type) {
		U_Type = u_Type;
	}
	public Integer getU_Type() {
		return U_Type;
	}
	public void setU_Status(String u_Status) {
		U_Status = u_Status;
	}
	public String getU_Status() {
		return U_Status;
	}
	public void setU_Licence(String u_Licence) {
		U_Licence = u_Licence;
	}
	public String getU_Licence() {
		return U_Licence;
	}
	public void setU_Mac(String u_Mac) {
		U_Mac = u_Mac;
	}
	public String getU_Mac() {
		return U_Mac;
	}
	public void setU_Remark(String u_Remark) {
		U_Remark = u_Remark;
	}
	public String getU_Remark() {
		return U_Remark;
	}
	public void setU_IDCard(String u_IDCard) {
		U_IDCard = u_IDCard;
	}
	public String getU_IDCard() {
		return U_IDCard;
	}
	public void setU_Sex(String u_Sex) {
		U_Sex = u_Sex;
	}
	public String getU_Sex() {
		return U_Sex;
	}
	public void setU_BirthDay(String u_BirthDay) {
		U_BirthDay = u_BirthDay;
	}
	public String getU_BirthDay() {
		return U_BirthDay;
	}
	public void setU_MobileNo(String u_MobileNo) {
		U_MobileNo = u_MobileNo;
	}
	public String getU_MobileNo() {
		return U_MobileNo;
	}
	public void setU_UserNO(String u_UserNO) {
		U_UserNO = u_UserNO;
	}
	public String getU_UserNO() {
		return U_UserNO;
	}
	public void setU_WorkStartDate(String u_WorkStartDate) {
		U_WorkStartDate = u_WorkStartDate;
	}
	public String getU_WorkStartDate() {
		return U_WorkStartDate;
	}
	public void setU_WorkEndDate(String u_WorkEndDate) {
		U_WorkEndDate = u_WorkEndDate;
	}
	public String getU_WorkEndDate() {
		return U_WorkEndDate;
	}
	public void setU_CompanyMail(String u_CompanyMail) {
		U_CompanyMail = u_CompanyMail;
	}
	public String getU_CompanyMail() {
		return U_CompanyMail;
	}
	public void setU_Title(Integer u_Title) {
		U_Title = u_Title;
	}
	public Integer getU_Title() {
		return U_Title;
	}
	public void setU_Extension(String u_Extension) {
		U_Extension = u_Extension;
	}
	public String getU_Extension() {
		return U_Extension;
	}
	public void setU_HomeTel(String u_HomeTel) {
		U_HomeTel = u_HomeTel;
	}
	public String getU_HomeTel() {
		return U_HomeTel;
	}
	public void setU_PhotoUrl(String u_PhotoUrl) {
		U_PhotoUrl = u_PhotoUrl;
	}
	public String getU_PhotoUrl() {
		return U_PhotoUrl;
	}
	public void setU_DateTime(String u_DateTime) {
		U_DateTime = u_DateTime;
	}
	public String getU_DateTime() {
		return U_DateTime;
	}
	public void setU_LastIP(String u_LastIP) {
		U_LastIP = u_LastIP;
	}
	public String getU_LastIP() {
		return U_LastIP;
	}
	public void setU_LastDateTime(String u_LastDateTime) {
		U_LastDateTime = u_LastDateTime;
	}
	public String getU_LastDateTime() {
		return U_LastDateTime;
	}
	public void setU_ExtendField(String u_ExtendField) {
		U_ExtendField = u_ExtendField;
	}
	public String getU_ExtendField() {
		return U_ExtendField;
	}
	public void setU_Education(String u_Education) {
		U_Education = u_Education;
	}
	public String getU_Education() {
		return U_Education;
	}
	public void setU_Wedding(String u_Wedding) {
		U_Wedding = u_Wedding;
	}
	public String getU_Wedding() {
		return U_Wedding;
	}
	public void setU_MailingAddress(String u_MailingAddress) {
		U_MailingAddress = u_MailingAddress;
	}
	public String getU_MailingAddress() {
		return U_MailingAddress;
	}
	public void setU_PativePlace(String u_PativePlace) {
		U_PativePlace = u_PativePlace;
	}
	public String getU_PativePlace() {
		return U_PativePlace;
	}
	public void setU_PativePlaceAdd(String u_PativePlaceAdd) {
		U_PativePlaceAdd = u_PativePlaceAdd;
	}
	public String getU_PativePlaceAdd() {
		return U_PativePlaceAdd;
	}
}
