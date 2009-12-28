<#macro AButton controller="" action="" id="" title="" auth=true disabled=true class="" xtype="" icon="" >
      <a id="${id}" href="${controller}/${action}" action="${action}" class="l-btn ${class}" icon="icon-${icon}" title="${title}">${title}</a> 
</#macro>

<#macro ImgButton controller="" action="" id="" title="" auth=true disabled=true xtype="" icon="" >
      <a id="${id}" action="${action}" href="${controller}/${action}" title="${title}"><img src="views/css/icons/${icon}.png"></a> 
</#macro>

<#macro ImgQButton controller="" action="" id="" title="" auth=true disabled=true xtype="" class="" >
<#if auth==true>
	<#if action!="">	
		<#list Helpers.permission as item>
			<#if action?upper_case==item?upper_case>
				<a id="${id}" action="${Helpers.controller}.${item}" href="${Helpers.uri}/${item}/" title="${item}" class="submit ui-state-default "><img src="views/css/icons/${item}.png">${title}</a>	
			</#if>
		</#list>
	<#else>
		<#list Helpers.permission as item>
		<a id="${id}" action="${Helpers.controller}.${item}" href="${Helpers.uri}/${item}/" title="${item}" class="submit ui-state-default ui-corner-all"><img src="views/css/icons/${item}.png">${title}</a>	
		</#list>	
	</#if>
<#else>
	<a id="${id}" action="${Helpers.controller}.${action}" href="${Helpers.uri}/${action}/${action}" title="${title}" class="submit ui-state-default ui-corner-all"><img src="views/css/icons/${action}.png">${title}</a>	
</#if>
</#macro>

<#macro FormButton controller="" action="" id="" title="" auth=true disabled=true xtype="" >
      <a id="${id}" action="${action}" class="submit ui-state-default ui-corner-all" href="${controller}/${action}/${id}" title="${title}">&nbsp;${title}&nbsp;</a>       
</#macro>


<#macro FormDropdownlist id="" title="" auth=true disabled=true xtype="" >
			<select name="selectset" id="selectset" multiple="multiple" size="5" class="text ui-widget-content ui-corner-all"> 
				<option>Option 1</option> 
				<option>Option 2</option> 
				<option>Option 3</option> 
				<option>Option 4</option> 
				<option>Option 5</option> 
			</select>     
</#macro>