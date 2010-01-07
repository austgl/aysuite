<#include "/common/control.ftl">
<div class="window_aside" id="${Helpers.controller}">
<@ImgQButton id="refresh" action="refresh" title="刷新本页" auth=false icon="refresh"/>
<@ImgQButton action="Create" title="新增组" />

	<ul class='tree' id="${Helpers.controller}"> 
		<li> 
		<#list myGroup as item>
			<span id='${item.groupID}' ParentID='${item.g_ParentID}'>${item.g_CName}</span> 
		</#list>
		</li>  
	</ul> 
</div>
<div class="window_main">

		

</div>

<div id="${Helpers.controller}CreateDiag">
<form action="${Helpers.uri}/SaveCreate" id="${Helpers.controller}-SaveCreate" method="post" >
<label for="G_CName">组名称</label> 
		<input type="text" id="G_CName" name="G_CName" class="text ui-widget-content ui-corner-all" /> 
		<input type="hidden" id="G_ParentID" name="G_ParentID" value="0" /> 
</form>
</div>

<@Script />
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
	$("a[action='${Helpers.controller}.Create']").click(function(){
		$("#${Helpers.controller}CreateDiag").dialog('open');
		return false;
	});	
});		
</script>