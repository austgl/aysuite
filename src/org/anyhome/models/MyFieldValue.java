
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
@Table(name="ay_fieldvalue")
public class MyFieldValue extends ActiveRecordBase {
			
			@Id private Integer ValueID;
			
			@Column private String V_F_Key;
			
			@Column private String V_Text;
			
			@Column private String V_Code;
			
			@Column private Integer V_ShowOrder;
			
			@Column private Integer V_FieldID;
		
			
			public void setValueID(Integer T_ValueID){
				ValueID=T_ValueID;
			}
			public Integer getValueID() {
				return ValueID;
			} 
			
			public void setV_F_Key(String T_V_F_Key){
				V_F_Key=T_V_F_Key;
			}
			public String getV_F_Key() {
				return V_F_Key;
			} 
			
			public void setV_Text(String T_V_Text){
				V_Text=T_V_Text;
			}
			public String getV_Text() {
				return V_Text;
			} 
			
			public void setV_Code(String T_V_Code){
				V_Code=T_V_Code;
			}
			public String getV_Code() {
				return V_Code;
			} 
			
			public void setV_ShowOrder(Integer T_V_ShowOrder){
				V_ShowOrder=T_V_ShowOrder;
			}
			public Integer getV_ShowOrder() {
				return V_ShowOrder;
			} 
			
			public void setV_FieldID(Integer T_V_FieldID){
				V_FieldID=T_V_FieldID;
			}
			public Integer getV_FieldID() {
				return V_FieldID;
			} 
}
