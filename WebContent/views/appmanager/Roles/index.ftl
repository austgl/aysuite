<#include "/common/control.ftl">
<div class="window_aside" id="${Helpers.controller}">
<@ImgQButton id="refresh" action="Add" title="刷新本页" class="refresh"/>
<@ImgQButton id="Add" action="Add" title="新增" class="plusthick"/>
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
<input type='hidden' id='${Helpers.controller}thisuri' value='${Helpers.uri}'>
<style type="text/css">
	#selectable .ui-selecting { background: #FECA40; }
	#selectable .ui-selected { background: #F39814; color: white; }
	#selectable { list-style-type: none; margin: 0; padding: 0;}
	#selectable li { margin: 3px; padding: 0.4em;  height: 14px; }
</style>
<script>
$(function() {
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