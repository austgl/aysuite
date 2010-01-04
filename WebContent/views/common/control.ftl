<#macro AButton controller="" action="" id="" title="" auth=true disabled=true class="" xtype="" icon="" >
      <a id="${id}" href="${controller}/${action}" action="${action}" class="l-btn ${class}" icon="icon-${icon}" title="${title}">${title}</a> 
</#macro>

<#macro ImgButton controller="" action="" id="" title="" auth=true disabled=true xtype="" icon="" >
      <a id="${id}" action="${action}" href="${controller}/${action}" title="${title}"><img src="views/css/icons/${icon}.png"></a> 
</#macro>

<#macro ImgQButton controller="" url="" action="" id="" title="" auth=true icon="" xtype="" class="" >
<#assign href=Helpers.uri+"/"+action+"/"+id>
<#if url!="">
	<#assign href=url>
</#if>
<#if auth==true>
	<#if action!="">
		<#list Helpers.permission as item>
			<#if action?upper_case==item?upper_case>
				<a id="${id}" action="${Helpers.controller}.${item}" href="${href}" title="${item}" class="submit ui-state-default "><img src="views/css/icons/${item}.png">${title}</a>	
			</#if>
		</#list>
	<#else>
		<#list Helpers.permission as item>
		<a id="${id}" action="${Helpers.controller}.${item}" href="${Helpers.uri}/${item}/" title="${item}" class="submit ui-state-default ui-corner-all"><img src="views/css/icons/${item}.png">${title}</a>	
		</#list>	
	</#if>
<#else>
	<a id="${id}" action="${Helpers.controller}.${action}" href="${Helpers.uri}/${action}/${action}" title="${title}" class="submit ui-state-default ui-corner-all"><img src="views/css/icons/${icon}.png">${title}</a>	
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


<#macro Script >
<script>
var $Twindos=$('div#window_${Helpers.controller?cap_first}');
if ($Twindos.html()==null){
	$Twindos=$('div#window_Application');
}
$(function() {		
	$Twindos.find('a.window_min').click(function() {
		$(this).closest('div.window').hide();
		return false;
	});
	$Twindos.mousedown(function() {
		// Bring window to front.
		JQD.window_flat();
		$(this).addClass('window_stack');
	}).draggable({
		// Confine to desktop.
		// Movable via top bar only.
		containment: 'parent',
		handle: 'div.window_top'
	}).resizable({
		containment: 'parent',
		minWidth: 400,
		minHeight: 200
	// Double-click top bar to resize, ala Windows OS.
	}).find('div.window_top').dblclick(function() {
		JQD.window_resize(this);

	// Double click top bar icon to close, ala Windows OS.
	}).find('img').dblclick(function() {
		// Traverse to the close button, and hide its taskbar button.
		$($(this).closest('div.window_top').find('a.window_close').attr('href')).hide('fast');

		// Close the window itself.
		$(this).closest('div.window').hide();

		// Stop propagation to window's top bar.
		return false;
	});				

	// 关闭窗口
	$Twindos.find('a.window_close').click(function() {
		$(this).closest('div.window').hide();
		$($(this).attr('href')).hide('fast');
		if ($(this).closest('div.window').attr('id')!='window_computer')
			$(this).closest('div.window').remove();	
		return false;
	});	
	$("a[action='${Helpers.controller}.refresh']").click(function(){
		$('#${Helpers.controller}').parent().load('${Helpers.uri}');
		return false;
	});	
	
});	    
</script>
</#macro>