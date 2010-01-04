
/* ***********************************************
 * author :  Anyhome
 * email  :  ayhome@gmail.com 
 * function: 
 * @date 2009-10-30
 * history:  created by Anyhome
 * ***********************************************/
 
package org.anyhome.models;

import java.util.List;

import com.et.ar.ActiveRecordBase;
import com.et.ar.annotations.Column;
import com.et.ar.annotations.DependentType;
import com.et.ar.annotations.HasMany;
import com.et.ar.annotations.Id;
import com.et.ar.annotations.Table;
@Table(name="ay_field")
public class MyField extends ActiveRecordBase {
			
			@Id private Integer FieldID;
			
			@Column private String F_Key;
			
			@Column private String F_CName;
			
			@Column private String F_Remark;
			
			@HasMany(foreignKey="V_FieldID",dependent=DependentType.DELETE)
			private List<MyFieldValue> myFieldValue;
			
			private List<MyFieldValue> FieldValue;
						
			public void setFieldID(Integer T_FieldID){
				FieldID=T_FieldID;
			}
			public Integer getFieldID() {
				return FieldID;
			} 
			
			public void setF_Key(String T_F_Key){
				F_Key=T_F_Key;
			}
			public String getF_Key() {
				return F_Key;
			} 
			
			public void setF_CName(String T_F_CName){
				F_CName=T_F_CName;
			}
			public String getF_CName() {
				return F_CName;
			} 
			
			public void setF_Remark(String T_F_Remark){
				F_Remark=T_F_Remark;
			}
			public String getF_Remark() {
				return F_Remark;
			}
			public void setMyFieldValue(List<MyFieldValue> myFieldValue) {
				this.myFieldValue = myFieldValue;
			}
			public List<MyFieldValue> getMyFieldValue() {
				return myFieldValue;
			}
			public void setFieldValue(List<MyFieldValue> fieldValue) {
				FieldValue = fieldValue;
			}
			public List<MyFieldValue> getFieldValue() {
				return FieldValue;
			} 
}
