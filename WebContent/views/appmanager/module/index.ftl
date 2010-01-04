<#include "/common/control.ftl">
<div class="window_aside" id="${Helpers.controller}">

<@ImgQButton id="refresh" action="refresh" title="刷新本页" auth=false  class="refresh"/>
<br />
<br />
<div id="${Helpers.controller}_accordion">
<#list myModule as item>
	<#if item.m_ParentID==0>
		<h3 ><a href="#" id="${item.m_PageCode}" moduleID=${item.moduleID}>${item.m_CName}{${item.m_PageCode}}</a></h3>	
	<ol id="selectable">
	<#list myModule as subitem>
		<#if subitem.m_ParentID==item.moduleID >
			<li id="${subitem.m_PageCode}" moduleID=${subitem.moduleID} class="ui-widget-content">${subitem.m_CName}{${subitem.m_PageCode}}</li>		
		</#if>
	</#list>
	</ol>
	</#if>
</#list>	
</div>
</div>
<div class="window_main" id="${Helpers.controller}">

</div>
<input type='hidden' id='${Helpers.controller}thisuri' value='${Helpers.uri}'>
<@Script />
<style type="text/css">
	#feedback { font-size: 1.4em; }
	#selectable .ui-selecting { background: #FECA40; }
	#selectable .ui-selected { background: #F39814; color: white; }
	#selectable { list-style-type: none; margin: 0; padding: 0;}
	#selectable li { margin: 3px; padding: 0.4em;  height: 14px; }
	</style>
<script>
$(function() {
	$('#${Helpers.controller}.edit').hide();
	$("#${Helpers.controller}_accordion").accordion({
		autoHeight: false,
		collapsible: true,
		alwaysOpen: false		    
	});	
	$('ol').each(function(){
		$(this).selectable({
			selected:function(event, ui){
				var id = $(this).find('li.ui-selected').attr('moduleID');
				$('.window_main#${Helpers.controller}').load('${Helpers.uri}/ModuleList/'+id);
			}
		});
	});

	$('#refresh').click(function(){
		$('#${Helpers.controller}').parent().load('${Helpers.uri}');
		return false;
	});	
});		
</script>