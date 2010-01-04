<#include "/common/control.ftl">
	<table class="data list" id="${Helpers.controller}" >	
		<tr>
			<th class="shrink" >
				&nbsp;
			</th>
			<th>
				模块ID 
			</th>							
			<th>
				模块名称 
			</th>
			<th>
				模块代码 
			</th>
			<th>
				模块地址 
			</th>
			<th>
				系统
			</th>
			<th>
				活动
			</th>	
			<th>
				图标
			</th>			
		</tr>
		<tr id="${myModule.moduleID}">
			<td>				
				<@ImgQButton id="Delete" url="${Helpers.uri}/../../Delete/${myModule.moduleID}" action="Delete" />
			</td>	
			<td id="ModuleID">
				${myModule.moduleID}
			</td>			
			<td id="M_CName">
				${myModule.m_CName}
			</td>
			<td id="M_PageCode">
				${myModule.m_PageCode}
			</td>
			<td id="M_Directory">
				${myModule.m_Directory}
			</td>
			<td id="M_IsSystem">
				${myModule.m_IsSystem?default("0")}
			</td>
			<td id="M_Close">
				${myModule.m_Close}
			</td>	
			<td id="M_Icon">
				${myModule.m_Icon}
			</td>			
		</tr>	
		<tr>
			<td colspan="8">
				<@ImgQButton id="Add" action="Create" title="新增子模块"/>
				<@ImgQButton id="Add" action="Delete" title="删除父级模块" />
				<@ImgQButton id="Add" action="ModulePiss" auth=false title="模块权限" />
			</td>
		</tr>
	</table>
	
<!----------表单----------->
<form action="" method="post" id="${Helpers.action}">
	<fieldset class="ui-widget-content ui-corner-all edit" id="${Helpers.controller}" > 
	<legend class="ui-widget-header ui-corner-all">新增模块组</legend> 
		<input type='hidden' id='M_ParentID' name="M_ParentID" value='${myModule.m_ParentID}' />		
		<input type="hidden" id="M_ApplicationID" name="M_ApplicationID" value='${myModule.m_ApplicationID}' /> 		
		
		<label for="M_PageCode">模块组代码</label> 
		<input type="text" id="M_PageCode" name="M_PageCode" class="text ui-widget-content ui-corner-all" /> 		

		
		<label for="M_CName">模块组名称</label> 
		<input type="text" id="M_CName" name="M_CName" class="text ui-widget-content ui-corner-all" /> 		

		
		<label for="M_Directory">模块组地址</label> 
		<input type="text" id="M_Directory" name="M_Directory" class="text ui-widget-content ui-corner-all" /> 		

		
		<input type="hidden" id="M_Orderlevel" name="M_Orderlevel" /> 		

		
		<label for="M_Issystem">系统</label> 
		<select name="M_Issystem" id="M_Issystem" class="text ui-widget-content ui-corner-all"> 
			<option value=0>是</option> 
			<option value=1>否</option> 
		</select> 				

		
		<label for="M_Close">活动</label> 		
		<select name="M_Close" id="M_Close" class="text ui-widget-content ui-corner-all"> 
			<option value=0>是</option> 
			<option value=1>否</option> 
		</select> 	
		
		<label for="M_Icon">模块图标</label> 
		<input type="text" id="M_Icon" name="M_Icon" class="text ui-widget-content ui-corner-all" /> 		
			<@FormButton action="Update" title="提 交" />			
			<@FormButton action="Cancel" title="取 消" />
	</fieldset>	
	
</form>
<script>	
$(function() {	
	var url = $('#${Helpers.controller}thisuri').val();
	$('form#${Helpers.action}').hide();
	$('tr').dblclick(function(){
		$(this).find("td[id!='']").each(function(){
			$('form#${Helpers.action}').find('input#'+$(this).attr('id')).attr('value',$(this).html().trim());
		});//moduleid
		var id= $(this).attr('id');
		$('form#${Helpers.action}').attr('action',url+'/SaveEdit/'+id);
		$('#${Helpers.controller}.list').hide('clip',{},500,function(){
			$("form#${Helpers.action}").show('clip',{},500,function(){});	
		});
		return false;
	});

	$("A[action='Cancel']").click(function(){
		$('form#${Helpers.action}').hide('clip',{},500,function(){		
			$("#${Helpers.controller}.list").show('clip',{},500,function(){});		
		});
		return false;
	});	
	//新增
	$('div.window_main').find('A#Add').click(function(){
		$('input#ModuleID').val('');
		$('#${Helpers.controller}.list').hide('clip',{},500,function(){		
			//$("form#Applications").show().fadeIn();
			$("form#${Helpers.action}").show('clip',{},500,function(){});	
			$('form#${Helpers.action}').attr('action',url+'/SaveCreate');			
		});
		return false;
	});

	//更新
	$("A[action='Update']").click(function(){		
		$('form#${Helpers.action}').ajaxSubmit(function(){
			//$("#${Helpers.controller}.list").show('clip',{},500,function(){});
			$('#${Helpers.controller}.list').parent().load('${Helpers.uri}');
		});
		return false;
	});	
	InitPageParms($(this));
});			
</script>	