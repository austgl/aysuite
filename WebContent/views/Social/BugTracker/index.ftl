<#include "/common/control.ftl">
<div class="window_aside" id="${Helpers.controller}">
<@ImgQButton id="refresh" action="refresh" title="刷新本页" auth=false class="refresh"/>
</div>
<div class="window_main" id="${Helpers.controller}">
	<table class="data list" id="${Helpers.controller}" >
		<tr>
			<th class="shrink" >
				&nbsp;
			</th>
			<th>
				提交人
			</th>							
			<th>
				提交地址
			</th>
			<th>
				提交模块
			</th>
			<th>
				提交时间
			</th>
		</tr>
	<#list myBugTracker as item>
		<tr id="${item.bugID}">
			<td>				
				<@ImgQButton id="${item.bugID}" action="Delete" class="close"/>
			</td>	
			<td id="B_Userid">
				${item.myUser.u_CName}
			</td>			
			<td id="B_Url">
				${item.b_Url}
			</td>
			<td id="B_Module">
				${item.b_Module}
			</td>
			<td id="B_Dtime">
				${item.b_Dtime?default("")}
			</td>	
		</tr>	
	</#list>
		<tr>
			<td colspan="5"><@ImgQButton /></td>
		</tr>
	</table>	
	</ul>
</div>
<div id="${Helpers.controller}Details" class="ui-widget-content">
</div>
<style type="text/css">
</style>
<script>
$(function() {	
	$Details = $("#${Helpers.controller}Details");
	$Details.hide();
	$('#refresh').click(function(){
		$('#${Helpers.controller}').parent().load('${Helpers.uri}');
		return false;
	});	
	$('a[action]').click(function(){
		if ($(this).attr('action')=='${Helpers.controller}.refresh')
			return false;
		var $s = $('table#${Helpers.controller}');		
		var id = $s.find('tr.active.ui-state-default.ui-corner-tr').attr('id');	
		if (id==null || id ==''){
			$s.effect('highlight',{},600,null);
			return false;
		}		
		if ($('.${Helpers.controller}_id_'+id).html()!=null){
			$('.${Helpers.controller}_id_'+id).effect('highlight',{},600,null);
			return false;
		}
		var loadurl = $(this).attr('href');
		var title = $s.find("td[id='B_Module']").html();
		var $h = $Details.clone().load(loadurl+id);
		$h.dialog({
			bgiframe: true,
			title:title,
			dialogClass:'${Helpers.controller}_id_'+id,
			open:function(event, ui){
				$(this).parent().show('drop',{},200,null);						
			},
			close: function() {
				$(this).parent().hide('scale',{percent: 0},500,function(){$(this).remove();});
			}
		});
		return false;
	})
});		
</script>