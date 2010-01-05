<#include "/common/control.ftl">
<form action="" method="post" id="${Helpers.action}">
	<fieldset class="ui-widget-content ui-corner-all edit" id="${Helpers.controller}" > 
	<legend class="ui-widget-header ui-corner-all">新增模块组</legend> 
		<input type='hidden' id='M_ParentID' name="M_ParentID" value='0' />
<input type="hidden" id="M_ApplicationID" name="M_ApplicationID" value='1' />		
		
		<label for="M_PageCode">模块组代码</label> 
		<input type="text" id="M_PageCode" name="M_PageCode" class="text ui-widget-content ui-corner-all" /> 		

		
		<label for="M_CName">模块组名称</label> 
		<input type="text" id="M_CName" name="M_CName" class="text ui-widget-content ui-corner-all" /> 		

		
		<label for="M_Directory">模块组地址</label> 
		<input type="text" id="M_Directory" name="M_Directory" class="text ui-widget-content ui-corner-all" /> 		

		
		<input type="hidden" id="M_Orderlevel" name="M_Orderlevel" /> 		
		
		<input type="hidden" id="M_Issystem" name="M_Issystem" value="1" />
		
		<label for="M_Close">活动</label> 		
		<select name="M_Close" id="M_Close" class="text ui-widget-content ui-corner-all"> 
			<option value=0>是</option> 
			<option value=1>否</option> 
		</select> 	
		
		<label for="M_Icon">模块图标</label> 
		<input type="text" id="M_Icon" name="M_Icon" class="text ui-widget-content ui-corner-all" /> 		
			<@FormButton action="Update" title="提 交" />	
	</fieldset>	
</form>
<script>
$(function(){
	var url = $('#${Helpers.controller}thisuri').val();
	$("A[action='Update']").click(function(){
		$('form#${Helpers.action}').attr('action',url+'/SaveCreate');
		$('form#${Helpers.action}').ajaxSubmit(function(){
			$('#${Helpers.controller}').parent().load(url);
		});
		return false;
	});		
})
</script>


