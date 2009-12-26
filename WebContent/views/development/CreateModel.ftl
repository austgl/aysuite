
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
@Table(name="${tables}")
public class ${tables} extends ActiveRecordBase {
		<#list myDevelopment as item>
			<#assign sid="Column" />
			<#assign t=item.columnType />
			<#assign s=item.columName />
			<#if t=="int">
				<#assign t="Integer" />
			<#elseif t=="int identity">
				<#assign t="Integer" />
				<#assign sid="Id" />
			<#else>
				<#assign t="String" />
			</#if>
			
			@${sid} private ${t} ${s};
		</#list>		
		
		<#list myDevelopment as item>
			<#assign sid="Column" />
			<#assign t=item.columnType />
			<#assign s=item.columName />
			<#if t=="int">
				<#assign t="Integer" />
			<#elseif t=="int identity">
				<#assign t="Integer" />
				<#assign sid="Id" />
			<#else>
				<#assign t="String" />
			</#if>
			
			public void set${s}(${t} T_${s}){
				${s}=T_${s};
			}
			public ${t} get${s}() {
				return ${s};
			} 
		</#list>					
}
