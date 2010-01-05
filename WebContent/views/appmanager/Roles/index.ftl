<#include "/common/control.ftl">
<div class="window_aside" id="${Helpers.controller}">
<@ImgQButton id="refresh" action="refresh" title="刷新本页" auth=false  class="refresh"/>
<@ImgQButton id="Create" action="Create" title="新增角色" />
<br />
<br />
	<ol id="selectable">
	<#list myRoles as subitem>
		<li id="${subitem.roleID}" UserID=${subitem.r_UserID} class="ui-widget-content">${subitem.r_RoleName}</li>	
	</#list>
	</ol>
</div>
<div class="window_main" id="${Helpers.controller}">

</div>

<div id="${Helpers.controller}CreateDiag">
<form action="${Helpers.uri}/SaveCreate" id="${Helpers.controller}-SaveCreate" method="post" >
<input type="hidden" id="R_UserID" name="R_UserID" value="1" />
角色名称
<input type="text" id="R_RoleName" name="R_RoleName" class="text ui-widget-content ui-corner-all" value="" /> 
角色描述
<input type="text" id="R_Description" name="R_Description" class="text ui-widget-content ui-corner-all" value="" /> 
</form>
</div>

<@Script />
<input type='hidden' id='${Helpers.controller}thisuri' value='${Helpers.uri}'>
<style type="text/css">
	#selectable .ui-selecting { background: #FECA40; }
	#selectable .ui-selected { background: #F39814; color: white; }
	#selectable { list-style-type: none; margin: 0; padding: 0;}
	#selectable li { margin: 3px; padding: 0.4em;  height: 14px; }
</style>

<script>
$(function() {
	$("#${Helpers.controller}CreateDiag").dialog({
		autoOpen: false,
		modal: true,
		buttons: {
			'确定':function(){
				$('#${Helpers.controller}-SaveCreate').ajaxSubmit();
				$(this).dialog('close');
			},
			'取消':function(){
				$(this).dialog('close');
			}
		}
	});
	$("a[action='roles.Create']").click(function(){
		$("#${Helpers.controller}CreateDiag").dialog('open');
		return false;
	});

	$('#${Helpers.controller}.edit').hide();
	$('#selectable').selectable({
		selected:function(event, ui){
			var id = $(this).find('li.ui-selected').attr('id');
			$('.window_main#${Helpers.controller}').load('${Helpers.uri}/Details/'+id);			
		}
	});

	$('#refresh').click(function(){
		$('#${Helpers.controller}').parent().load('${Helpers.uri}');
		return false;
	});	
});		
</script>