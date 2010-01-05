<#include "/common/control.ftl"> 
<form action="" id="SaveUser" method="POST">
<div id="wrapper">
	<fieldset class="ui-widget-content ui-corner-all edit" id="development" > 
	<legend class="ui-widget-header ui-corner-all">新增用户</legend> 				
		<label for="U_LoginName">名称</label> 
		<input type="text" id="U_LoginName" name="U_LoginName" class="text ui-widget-content ui-corner-all"  /> 		

		<label for="U_Password">密码</label> 
		<input type="Password" id="U_Password" name="U_Password" class="text ui-widget-content ui-corner-all" /> 		
		
		<label for="U_CName">姓名</label> 
		<input type="text" id="U_CName" name="U_CName" class="text ui-widget-content ui-corner-all" /> 		
		
		<label for="U_EName">英文名</label> 
		<input type="text" id="U_EName" name="U_EName" class="text ui-widget-content ui-corner-all" /> 	
	</fieldset>		
	</div>			
	<div id="wrapper">
	<fieldset class="ui-widget-content ui-corner-all edit" id="development" > 
		<legend class="ui-widget-header ui-corner-all">新增用户</legend> 
<label for="U_GroupID">用户组</label> 
		<input type="text" id="U_GroupID" name="U_GroupID" class="text ui-widget-content ui-corner-all"  />

		<label for="U_Type">用户类型</label> 
		<input type="text" id="U_Type" name="U_Type" class="text ui-widget-content ui-corner-all" /> 	

		<label for="U_Status">状态</label> 
		<input type="text" id="U_Status" name="U_Status" class="text ui-widget-content ui-corner-all" /> 
		
		<label for="U_Sex">性别</label> 
		<input type="text" id="U_Sex" name="U_Sex" class="text ui-widget-content ui-corner-all" />		
	</fieldset>		
	<@ImgQButton action="Create" title="保存" auth=false icon="Save" />
	</div>
</form>	


<style type="text/css">
#wrapper {
	float: left; 
	width: 160px;
}
</style>
<script>
$(function(){
	var url=$('#${Helpers.controller}thisuri').val();
	$("a[action='user.Create']").click(function(){
		$('#SaveUser').attr('action',url+'/SaveCreate');
		$('#SaveUser').ajaxSubmit(function(){
			$('#${Helpers.controller}').parent().load(url);
		})
		return false;
	})

})
</script>