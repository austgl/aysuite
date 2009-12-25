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
import com.et.ar.annotations.NotEmpty;
import com.et.ar.annotations.Table;

@Table(name="Ay_Applications")
public class MyApplications extends ActiveRecordBase {
	@Id private Integer ApplicationID;
	@NotEmpty(message="应用名称必须填写")
	@Column private String A_AppName;	
	@Column private String A_AppDescription;
	@Column private String A_AppUrl;
	/**
	 * @param applicationID the applicationID to set
	 */
	public void setApplicationID(Integer applicationID) {
		ApplicationID = applicationID;
	}
	/**
	 * @return the applicationID
	 */
	public Integer getApplicationID() {
		return ApplicationID;
	}
	/**
	 * @param a_AppName the a_AppName to set
	 */
	public void setA_AppName(String a_AppName) {
		A_AppName = a_AppName;
	}
	/**
	 * @return the a_AppName
	 */
	public String getA_AppName() {
		return A_AppName;
	}
	/**
	 * @param a_AppDescription the a_AppDescription to set
	 */
	public void setA_AppDescription(String a_AppDescription) {
		A_AppDescription = a_AppDescription;
	}
	/**
	 * @return the a_AppDescription
	 */
	public String getA_AppDescription() {
		return A_AppDescription;
	}
	/**
	 * @param a_AppUrl the a_AppUrl to set
	 */
	public void setA_AppUrl(String a_AppUrl) {
		A_AppUrl = a_AppUrl;
	}
	/**
	 * @return the a_AppUrl
	 */
	public String getA_AppUrl() {
		return A_AppUrl;
	}
}
