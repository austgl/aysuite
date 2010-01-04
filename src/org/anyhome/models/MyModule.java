/* ***********************************************
 * author :  Anyhome
 * email  :  ayhome@gmail.com 
 * function: 
 * @date 2009-11-13
 * history:  created by Anyhome
 * ***********************************************/
 
/**
 * 
 */
package org.anyhome.models;

import java.util.List;

import org.anyhome.OrmUtil;

import com.et.ar.ActiveRecordBase;
import com.et.ar.annotations.Column;
import com.et.ar.annotations.HasMany;
import com.et.ar.annotations.Id;
import com.et.ar.annotations.Table;
import com.et.ar.exception.ActiveRecordException;
/**
 * @author Ayhome
 *
 */
@Table(name="Ay_Module")
public class MyModule extends ActiveRecordBase {
	@Id private Integer ModuleID;
	@Column private Integer M_ApplicationID;
	@Column private Integer M_ParentID;
	@Column private String M_PageCode;
	@Column private String M_CName;
	@Column private String M_Directory;
	@Column private String M_OrderLevel;
	@Column private Integer M_IsSystem;
	@Column private Integer M_Close;
	@Column private String M_Icon;

	private List<MyModuleExtPermission> ModuleExtPermission;
	
	@Override
	public void beforeDestroy() throws ActiveRecordException{
		if (this.M_ParentID==0){
			MyModule.deleteAll(MyModule.class, "M_ParentID=?", 
					new Object[]{this.ModuleID});
		}
	}
	
	/**
	 * @return the moduleID
	 */
	public Integer getModuleID() {
		return ModuleID;
	}
	/**
	 * @param m_ApplicationID the m_ApplicationID to set
	 */
	public void setM_ApplicationID(Integer m_ApplicationID) {
		M_ApplicationID = m_ApplicationID;
	}
	/**
	 * @return the m_ApplicationID
	 */
	public Integer getM_ApplicationID() {
		return M_ApplicationID;
	}
	/**
	 * @param m_ParentID the m_ParentID to set
	 */
	public void setM_ParentID(Integer m_ParentID) {
		M_ParentID = m_ParentID;
	}
	/**
	 * @return the m_ParentID
	 */
	public Integer getM_ParentID() {
		return M_ParentID;
	}
	/**
	 * @param m_PageCode the m_PageCode to set
	 */
	public void setM_PageCode(String m_PageCode) {
		M_PageCode = m_PageCode;
	}
	/**
	 * @return the m_PageCode
	 */
	public String getM_PageCode() {
		return M_PageCode;
	}
	/**
	 * @param m_CName the m_CName to set
	 */
	public void setM_CName(String m_CName) {
		M_CName = m_CName;
	}
	/**
	 * @return the m_CName
	 */
	public String getM_CName() {
		return M_CName;
	}
	/**
	 * @param m_Directory the m_Directory to set
	 */
	public void setM_Directory(String m_Directory) {
		M_Directory = m_Directory;
	}
	/**
	 * @return the m_Directory
	 */
	public String getM_Directory() {
		return M_Directory;
	}
	/**
	 * @param m_OrderLevel the m_OrderLevel to set
	 */
	public void setM_OrderLevel(String m_OrderLevel) {
		M_OrderLevel = m_OrderLevel;
	}
	/**
	 * @return the m_OrderLevel
	 */
	public String getM_OrderLevel() {
		return M_OrderLevel;
	}
	/**
	 * @param m_IsSystem the m_IsSystem to set
	 */
	public void setM_IsSystem(Integer m_IsSystem) {
		M_IsSystem = m_IsSystem;
	}
	/**
	 * @return the m_IsSystem
	 */
	public Integer getM_IsSystem() {
		return M_IsSystem;
	}
	/**
	 * @param m_Close the m_Close to set
	 */
	public void setM_Close(Integer m_Close) {
		M_Close = m_Close;
	}
	/**
	 * @return the m_Close
	 */
	public Integer getM_Close() {
		return M_Close;
	}
	/**
	 * @param m_Icon the m_Icon to set
	 */
	public void setM_Icon(String m_Icon) {
		M_Icon = m_Icon;
	}
	/**
	 * @return the m_Icon
	 */
	public String getM_Icon() {
		return M_Icon;
	}
	public void setModuleExtPermission(List<MyModuleExtPermission> moduleExtPermission) {
		ModuleExtPermission = moduleExtPermission;
	}
	public List<MyModuleExtPermission> getModuleExtPermission() throws ActiveRecordException {
		return OrmUtil.getTheById(this.ModuleID);
	}
}
