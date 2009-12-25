<#include "/common/control.ftl">
<div class="window_aside" id="${Helpers.controller}">
${Helpers.uri}
<@ImgQButton id="refresh" action="Add" title="新增" class="refresh"/>
</div>
<div class="window_main">
	<table class="data list" id="Applications" >
		<tr>
			<th class="shrink" >
				&nbsp;
			</th>
			<th>
				应用ID
			</th>							
			<th>
				应用名称
			</th>
			<th>
				应用地址
			</th>
			<th>
				应用描述
			</th>
		</tr>
		<#list myApp as item>	
		<tr id="${item.applicationID}">
			<td>				
				<@ImgQButton id="${item.applicationID}" action="Delete" title="删除" class="close"/>
			</td>	
			<td id="applicationID">
				${item.applicationID}
			</td>			
			<td id="a_AppName">
				${item.a_AppName}
			</td>
			<td id="a_AppUrl">
				${item.a_AppUrl}
			</td>
			<td id="a_AppDescription">
				${item.a_AppDescription}
			</td>	
		</tr>		
		</#list>
		<tr>
			<td colspan="4"><@ImgQButton id="Add" action="Add" title="新增" class="plusthick"/></td>
		</tr>
	</table>
	<form action="" method="post" id="Applications">
		<fieldset class="ui-widget-content ui-corner-all edit" > 
			<legend class="ui-widget-header ui-corner-all">新增应用</legend> 
			<input type="hidden" id="applicationID" name="applicationID" /> 
			<label for="A_AppName">应用名称</label> 
			<input type="text" id="a_AppName" name="A_AppName" class="text ui-widget-content ui-corner-all" /> 
			
			<label for="A_AppUrl">应用地址</label> 
			<input type="text" id="a_AppUrl" name="A_AppUrl" class="text ui-widget-content ui-corner-all" /> 

			<label for="A_AppDescription">应用描述</label> 
			<input type="text" id="a_AppDescription" name="A_AppDescription" class="text ui-widget-content ui-corner-all" /> 	
			<@FormButton action="Update" title="提 交" />			
			<@FormButton action="Cancel" title="取 消" />
		</fieldset>	
	</form>
</div>
<script>
$(function() {
	
	$('div.window_main').find('A#Add').click(function(){
		$('#Applications.list').hide('clip',{},500,function(){		
			//$("form#Applications").show().fadeIn();
			$("form#Applications").show('clip',{},500,function(){});	
			$('form#Applications').attr('action','${Helpers.uri}/SaveCreate');			
		});
		return false;
	});	
	
	$("A[action='Cancel']").click(function(){
		$('form#Applications').hide('clip',{},500,function(){		
			$("#Applications.list").show('clip',{},500,function(){});		
		});
		return false;
	});		
	$("form#Applications").hide();
	
	$('#refresh').click(function(){
		$('#${Helpers.controller}').parent().load('${Helpers.uri}');
		return false;
	});
	
	$("A[action='Update']").click(function(){
		$('form#Applications').ajaxSubmit(function(){
			$("#Applications.list").show('clip',{},500,function(){});
			$('#${Helpers.controller}').parent().load('${Helpers.uri}');
		});
		return false;
	});
	
	$('tr').dblclick(function(){
		$(this).find("td[id!='']").each(function(){
			$('form#Applications').find('input#'+$(this).attr('id')).attr('value',$(this).html().trim());
		});
		var id = $('form#Applications').find('input#applicationID').val();
		$('form#Applications').attr('action','${Helpers.uri}/SaveEdit/'+id);
		$('form#Applications').find('input#applicationID').attr('name','ApplicationID');
		$('#Applications.list').hide('clip',{},500,function(){
			$("form#Applications").show('clip',{},500,function(){});	
		});
		return false;
	});
	
});		
</script>