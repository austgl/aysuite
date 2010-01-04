<#include "/common/control.ftl">
<div class="window_aside" id="${Helpers.controller}">

<@ImgQButton id="refresh" action="refresh" title="刷新本页" auth=false icon="refresh"/>
<@ImgQButton action="OpenUser" title="打开职员框" auth=false icon="refresh"/>


<div id="CustomersList">
</div>
</div>
<div class="window_main" id="${Helpers.controller}">
	<div class="ResourcesList" id="${Helpers.controller}List" >

	</div>
<div id="${Helpers.controller}Box" class="ui-widget-content" style="float:left;width: 86px;text-align: center;">
	<h3 class="ui-widget-header">&nbsp;</h3>
	<ul>
		<li class="ui-widget-content ui-corner-tr" style="width: 80px;">
			<h5 class="ui-widget-header">电脑主机</h5>
			<img src="views/images/computer.png" alt="电脑主机" />
		</li>
		<li class="ui-widget-content ui-corner-tr" style="width: 80px;">
			<h5 class="ui-widget-header">电脑主机</h5>
			<img src="views/images/computer.png" alt="电脑主机" />
		</li>	
	</ul>	
</div>	
<div id="ResManagerUser" class="ResourcesList" style="width: 440px;">
	<h3 class="ui-widget-header">&nbsp;</h3>	
</div>
</div>
<input type="hidden" id="ResManagerloadUrl" value="${Helpers.uri}" >
<style type="text/css">
#${Helpers.controller}List { float: left; width: 78%; min-height: 12em; } * html 
#${Helpers.controller}List { height: 12em; } /* IE6 */
.ResourcesList li { float: left; width: 80px; padding: 0.4em; margin: 0 0.4em 0.4em 0; text-align: center; }
.ResourcesList li h5 { margin: 0 0 0.4em; cursor: move; }
</style>
<@Script />
<script>
$(function() {	
	JQD.window_resize($Twindos);
	//$('#${Helpers.controller}List').load('${Helpers.uri}/List');
	$('#CustomersList').load('ProjectManager/Customers',function(date){
		//$('.ResourcesList').load(url+'/List',{AdminId:id});
	});
	$("#${Helpers.controller}Box").draggable({handle:'h3'});	
	$('#ResManagerUser').hide();

	$("a[action='resManager.OpenUser']").click(function(){
		$('#ResManagerUser').load('Permission/FMGetAllUser',function(){
			//$("#ResManagerUser").draggable({handle:'h3'});
			//$("#ResManagerUser").resizable();	
		}).show();
		return false;
	});
	
});		
</script>