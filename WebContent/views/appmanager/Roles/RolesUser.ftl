<#include "/common/control.ftl">
<div class="ui-widget ui-helper-clearfix">
	<ul id="RolesUserBox" class="RolesUserBox ui-helper-reset ui-helper-clearfix">
	</ul>	
	<div id="UserBox" class="ui-widget-content ui-state-default">
		<h4 class="ui-widget-header"><span class="ui-icon ui-icon-UserBox">UserBox</span> UserBox</h4>
	<ul id="UserBoxlsit" class="RolesUserBox ui-helper-reset ui-helper-clearfix">
	<#list myUser as item>
		<li class="ui-widget-content ui-corner-tr" id='Userid${item.userID}' Userid='${item.userID}'>
			<h5 class="ui-widget-header">${item.u_CName}</h5>
			<img src="${item.u_PhotoUrl?default("")}" alt="${item.u_CName}" width="32" height="48" />
		</li>
	</#list>
	</ul>		
	</div>
</div>
<input type='hidden' id='RoleID' name='RoleID' value='${RoleID}' />
<#assign u="#00123">
<#list myUserRoles as item>
	<#assign u=u+",#Userid"+item.r_UserID>
</#list>
<script>	
$(function() {
	
	var url = $('#${Helpers.controller}thisuri').val();
	var id = $('input#RoleID').val();
	var $UserBox= $('#UserBox');
	var $RolesUserBox= $('#RolesUserBox');
	
	$('#UserBoxlsit>li${u}').find('img').end().appendTo($('#RolesUserBox')).fadeIn();
	
	$('li',$('#UserBoxlsit,#RolesUserBox')).draggable({
		cancel: 'a.ui-icon',
		revert: 'invalid',
		//containment: $('#demo-frame').length ? '#demo-frame' : 'document', // stick to demo-frame if present
		helper: 'clone',
		cursor: 'move'
	});	
	
	$('#UserBox').droppable({
		accept: '#RolesUserBox > li',
		activeClass: 'ui-state-highlight',
		drop: function(ev, ui) {
			deleteImage(ui.draggable);
		}
	});
	$RolesUserBox.droppable({
		accept: '#UserBox li',
		drop: function(ev, ui) {
			recycleImage(ui.draggable);
		}
	});		
	
	function deleteImage($item) {
		$item.fadeOut(function() {	
			var $list = $('ul',$UserBox).length ? $('ul',$UserBox) : $('<ul class="RolesUserBox ui-helper-reset"/>').appendTo($UserBox);
			
			var userid = $item.attr('Userid');
			$.post(url+'/DeleteRolesUser/'+id, 'userId='+userid);
			$item.appendTo($list).fadeIn();
		});
	}	
	
	function recycleImage($item) {
		$item.fadeOut(function() {
			var userid = $item.attr('Userid');
			$.post(url+'/CreateRolesUser/'+id, 'userId='+userid);
			$item.find('img').end().appendTo($RolesUserBox).fadeIn();
		});
	}	
	
});			
</script>
<style type="text/css">
#RolesUserBox { float: left; width: 60%; min-height: 12em; } * html #RolesUserBox { height: 12em; } /* IE6 */
.RolesUserBox.custom-state-active { background: #eee; }
.RolesUserBox li { float: left; width: 54px; padding: 0.4em; margin: 0 0.4em 0.4em 0; text-align: center; }
.RolesUserBox li h5 { margin: 0 0 0.4em; cursor: move; }
.RolesUserBox li img { width: 100%; cursor: move; }

#UserBox { float: right; width: 35%; min-height: 18em; padding: 1%;} * html #UserBox { height: 18em; } /* IE6 */
#UserBox h4 { line-height: 16px; margin: 0 0 0.4em; }
#UserBox h4 .ui-icon { float: left; }
</style>