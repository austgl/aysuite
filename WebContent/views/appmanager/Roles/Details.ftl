<#include "/common/control.ftl">
<form action="${Helpers.uri}" method="post" id="${Helpers.action}">
	<table class="data list" id="${Helpers.controller}" >	
		<tr>
			<th class="shrink" >
				&nbsp;
			</th>
			<th>
				角色ID 
			</th>	
			<th>
				角色名称 
			</th>
			<th>
				角色描述 
			</th>			
		</tr>
		<tr id="${myRoles.roleID}">
			<td>				
				<@ImgQButton id="${myRoles.roleID}" action="Delete" />				
			</td>	
			<td id="RoleID">
				<input type='hidden' id='RoleID' name='RoleID' value='${myRoles.roleID}' />
			</td>			
			<td id="R_RoleName">
			<input type="text" id="R_RoleName" name="R_RoleName" class="text ui-widget-content ui-corner-all" value='${myRoles.r_RoleName}' /> 
				
			</td>
			<td id="R_Description">
			<input type="text" id="R_Description" name="R_Description" class="text ui-widget-content ui-corner-all" value='${myRoles.r_Description}' /> 					
			</td>			
		</tr>	
		<tr>
			<td colspan="8">				
				<@ImgQButton id="SaveEdit" action="Save" auth=false title="保存" />
				<@ImgQButton id="RolesUser" action="RolesUser" auth=false title="所属用户" />
				<@ImgQButton id="RolePermisson" action="RolePermisson" auth=false title="权限设置" />
			</td>
		</tr>
	</table>
<fieldset class="ui-widget-content ui-corner-all edit" id="${Helpers.controller}" > 
	<legend class="ui-widget-header ui-corner-all">所属应用</legend> 
	<ol id="selectable">
	<#list myApp as item>
		<li id="${item.applicationID}" class="ui-widget-content">
			<#assign checked="">
			<#list myRoleApp as items>				
				<#if item.applicationID==items.a_ApplicationID>
					<#assign checked="checked">
				</#if>
			</#list>
		<input type="checkbox" id="ApplicationID${item.applicationID}" value="${item.applicationID}" name="ApplicationID"  class="radio checkboxset" ${checked} /> 							
					<label for="ApplicationID${item.applicationID}">${item.a_AppName}</label> 				
		</li>	
	</#list>
	</ol>
</fieldset>		
</form>
<script>	
$(function() {	
	var url = $('#${Helpers.controller}thisuri').val();
	var id = $('input#RoleID').val();
	$('form#${Helpers.action}').attr('action',url+'/SaveEdit/'+id);
	$('#SaveEdit').click(function(){
		$('form#${Helpers.action}').ajaxSubmit(function(){
			$.jGrowl('当前数据已保存');
		});
		return false;
	});
	$('#RolesUser').click(function(){
		$('form#Details').hide("blind",{},500,function(){
			$('form#Details').parent().load(url+'/RolesUser/'+id);
		});
		return false;
	});
	$('#RolePermisson').click(function(){
		$('form#Details').hide("blind",{},500,function(){
			$('form#Details').parent().load(url+'/RolePermisson/'+id);
		});
		return false;
	});	
		$("A[action*='Delete']").click(function(){
			var s = $(this);
			var getUrl = url+'/Delete/'+$(this).attr('id');
	      $("#Deldialog").clone().dialog({
	        bgiframe: true,
	        resizable: false,
	        height:140,
	        modal: true,
	        overlay: {
	          backgroundColor: '#000',
	          opacity: 0.5
	        },
	        buttons: {
	          '确定': function() {
	            //$(this).dialog('close');
	        	$.get(getUrl); 
	            $(this).remove();
				s.remove();
	          },
	          '取消': function() {
	            //$(this).dialog('close');
	            $(this).remove();
	          }
	        }
	      });	
	      return false;
		});		
	
});			
</script>	