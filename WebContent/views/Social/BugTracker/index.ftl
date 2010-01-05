<#include "/common/control.ftl">
<div class="window_aside" id="${Helpers.controller}">
<@ImgQButton id="refresh" action="refresh" title="刷新本页" auth=false icon="refresh"/>
</div>
<div class="window_main" id="${Helpers.controller}">
	<div id="${Helpers.controller}" >
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
	</table>
	<@ImgQButton />
	</div>
	<div id="${Helpers.controller}Details" class="ui-widget-content">
	</div>
	<div id="${Helpers.controller}Create" >
	<form action="${Helpers.uri}/SaveCreate" id="${Helpers.controller}Create" method="POST">
		<input type="hidden" id="B_Userid" name="B_Userid" value='${MyUserTicket.userID}' /> 				
		<input type="hidden" id="B_Url" name="B_Url" value='${Helpers.uri}' />
		<input type="hidden" id="B_IsUpdate" name="B_IsUpdate" value='0' />
		<input type="hidden" id="T_B_Dtime" name="T_B_Dtime" />
		<input type="hidden" id="T_B_Updata" name="T_B_Updata" />
		<input type="hidden" id="B_Module" name="B_Module" value='${Helpers.controller}' /> 	
		<textarea name="B_BugContent" id="B_BugContent" rows="10" class="text ui-widget-content ui-corner-all"></textarea> 
	<@ImgQButton id="SaveCreate" title="保存" auth=false icon="Create" />	
	<form>
	</div>	
</div>

<style type="text/css">
</style>
<@Script />
<script>
$(function() {	
	$Create=$('#${Helpers.controller}Create').hide();
	
	$Details = $("#${Helpers.controller}Details").hide();
	
	$('#refresh').click(function(){
		$('#${Helpers.controller}').parent().load('${Helpers.uri}');
		return false;
	});	
	$('a[action]').click(function(){
		var action = $(this).attr('action');
		var $s = $('table#${Helpers.controller}');		
		if (action=='${Helpers.controller}.refresh')
			return false;
			
		if(action=='${Helpers.controller}.Delete'){
			return false;
		}
		//
		if (action=='${Helpers.controller}.Create'){
			$s.parent().hide('clip',{},500,function(){	
				$("div#${Helpers.controller}Create").show('clip',{},500,function(){
					$("#B_BugContent").xheditor(true,{tools:'mini'}).css("width","100%");
					$(this).find('#SaveCreate').click(function(){
						$('form#${Helpers.controller}Create').ajaxSubmit(function(){
							$s.parent().show('clip',{},500,function(){});							
							$('#${Helpers.controller}').parent().load('${Helpers.uri}');
							return false;
						});						
					});
				});	
			});
			return false;			
		}
		
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