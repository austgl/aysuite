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


import com.et.ar.ActiveRecordBase;
import com.et.ar.annotations.Column;
import com.et.ar.annotations.Id;
import com.et.ar.annotations.Table;
/**
 * @author Ayhome
 *
 */
@Table(name="Ay_Group")
public class MyGroup extends ActiveRecordBase {
	@Id private Integer GroupID;
	@Column private String G_CName;
	@Column private Integer G_ParentID;
	@Column private Integer G_ShowOrder;
	@Column private Integer G_Level;
	@Column private Integer G_ChildCount;
	@Column private Integer G_Delete;
	public Integer getGroupID() {
		return GroupID;
	}
	public void setG_CName(String g_CName) {
		G_CName = g_CName;
	}
	public String getG_CName() {
		return G_CName;
	}
	public void setG_ParentID(Integer g_ParentID) {
		G_ParentID = g_ParentID;
	}
	public Integer getG_ParentID() {
		return G_ParentID;
	}
	public void setG_ShowOrder(Integer g_ShowOrder) {
		G_ShowOrder = g_ShowOrder;
	}
	public Integer getG_ShowOrder() {
		return G_ShowOrder;
	}
	public void setG_Level(Integer g_Level) {
		G_Level = g_Level;
	}
	public Integer getG_Level() {
		return G_Level;
	}
	public void setG_ChildCount(Integer g_ChildCount) {
		G_ChildCount = g_ChildCount;
	}
	public Integer getG_ChildCount() {
		return G_ChildCount;
	}
	public void setG_Delete(Integer g_Delete) {
		G_Delete = g_Delete;
	}
	public Integer getG_Delete() {
		return G_Delete;
	}
}
