<#include "/common/control.ftl">
<div class="window_aside" id="${Helpers.controller}">
<@ImgQButton id="refresh" action="refresh" title="刷新本页" auth=false />
<@ImgQButton action="Create" title="新增用户" />
<br />
<br />
	<ol id="selectable">
		<li id="0" class="ui-widget-content">所有用户</li>	
	<#list myGroup as item>
		<li id="${item.groupID}" class="ui-widget-content">${item.g_CName}</li>	
	</#list>
	</ol>
</div>
<div class="window_main" id="${Helpers.controller}">
	<ul id="UserBoxlsit" class="RolesUserBox ui-helper-reset ui-helper-clearfix">
	<#list myUser as item>
		<li class="ui-widget-content ui-corner-tr" id='Userid${item.userID}'  Userid='${item.userID}'>
			<h5 class="ui-widget-header">${item.u_CName}</h5>
			<img src='${item.u_PhotoUrl?default("views/css/images/dmenu_test_home.png")}' alt="${item.u_CName}" width="32" height="48" />
		</li>
	</#list>
	</ul>
</div>
<input type='hidden' id='${Helpers.controller}thisuri' value='${Helpers.uri}'>
<div id="${Helpers.controller}edit" title="">

</div>
<@Script />
<input type='hidden' id='${Helpers.controller}thisuri' value='${Helpers.uri}'>
<style type="text/css">
#RolesUserBox { float: left; width: 60%; min-height: 12em; } * html #RolesUserBox { height: 12em; } /* IE6 */
.RolesUserBox.custom-state-active { background: #eee; }
.RolesUserBox li { float: left; width: 54px; padding: 0.4em; margin: 0 0.4em 0.4em 0; text-align: center; }
.RolesUserBox li h5 { margin: 0 0 0.4em; cursor: pointer; }
.RolesUserBox li img { width: 100%; cursor: pointer; }
.ui-dialog-titlebar-close{
		display: none;
	}
#selectable .ui-selecting { background: #FECA40; }
#selectable .ui-selected { background: #F39814; color: white; }
#selectable { list-style-type: none; margin: 0; padding: 0;}
#selectable li { margin: 3px; padding: 0.4em;  height: 14px; }	
</style>
<script>
$(function() {	
	var $UserEditD = $('#${Helpers.controller}edit');
	$('#refresh').click(function(){
		$('#${Helpers.controller}').parent().load('${Helpers.uri}');
		return false;
	});	
	$('#selectable').selectable({
		selected:function(event, ui){
			var id = $(this).find('li.ui-selected').attr('id');
			var url="${Helpers.uri}/UserByGroup/"+id;
			$('.window_main#${Helpers.controller}').load(url);
		}
	});
	$("a[action='${Helpers.controller}.Create']").click(function(){
		var posturl = $(this).attr('href');		
		if (posturl!=""){
			$('div#${Helpers.controller}.window_main').load(posturl);
			return false;
			//posturl='${Helpers.uri}/Details/'+userid;		
		}		
	});
	$("li[Userid]").click(function(){
		var userid= $(this).attr('Userid');
		var userName = $(this).find('h5').html();
		$UserEditD.attr('title',userName);
		if ($('.ui-dialog.user'+userid).html()!=null){
			$('.ui-dialog.user'+userid).effect('highlight',{},500,null);
			return false;
		}
		$(this).effect('highlight',{},300,function(){
			var $s=$UserEditD.clone().load('${Helpers.uri}/Details/'+userid);
			
			$s.dialog({
				bgiframe: true,
				title:userName,
				width:360,
				dialogClass:'user'+userid,
				buttons: {
					'取消': function() {
						$(this).dialog('close');
						$(this).remove();
					},
					'保存':function(){
						$(this).find('form').attr('action','${Helpers.uri}/SaveEdit/'+userid);
						$(this).find('form').ajaxSubmit();
						$(this).parent().hide('scale',{percent: 0},500,function(){$(this).remove();});
						$.jGrowl("成功用户资料修改");
					}
				},
				open:function(event, ui){
					$(this).parent().show('drop',{},200,null);				
				}
			});	
		});		
	});

	
});		
</script>