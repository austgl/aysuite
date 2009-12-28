<#include "/common/control.ftl">
<div class="ui-widget ui-helper-clearfix">
	<div id="GetRolePermisson" class="GetRolePermisson ui-helper-reset ui-helper-clearfix">
		<fieldset class="ui-widget-content ui-corner-all"> 
			<legend class="ui-widget-header ui-corner-all">现有权限</legend> 	
				<ul id="PermissonList" class="RolePermissonList ui-helper-reset ui-helper-clearfix">
					<li class="ui-widget-content ui-corner-tr">
						<h5 class="ui-widget-header">初始权限</h5>
						<img src="views/css/images/dmenu_test_graphics.png" alt="初始权限" width="32" height="48" />
					</li>				
				</ul>
		</fieldset>			
<@ImgQButton id="UpdatePermisson" action="UpdatePermisson" auth=false title="保存" class="note"/>		
		<fieldset class="ui-widget-content ui-corner-all"> 
			<legend class="ui-widget-header ui-corner-all">权限列表</legend> 
				<ul id="RolePermissonList" class="RolePermissonList ui-helper-reset ui-helper-clearfix">
				<#list myPermission as item>
					<li class="ui-widget-content ui-corner-tr" id='permissValue' PermissValue='permissValue${item.permissValue}' pv='${item.permissValue}' >
						<h5 class="ui-widget-header">${item.permissName}</h5>
						<img src="views/css/images/dmenu_test_graphics.png" alt="${item.permissName}" width="32" height="48" />
					</li>
				</#list>
				</ul>
		</fieldset>			
	</div>
	<div id="ModuleBox" class="ui-widget-content ui-state-default">
		<div id="${Helpers.controller}_accordion">
		<#list myModule as item>
			<#if item.m_ParentID==0>
				<h3 ><a href="#" id="${item.m_PageCode}" moduleID='${item.moduleID}' >${item.m_CName}</a></h3>	
			<ol id="selectable">
			<#list myModule as subitem>
				<#if subitem.m_ParentID==item.moduleID >
					<li id="${subitem.m_PageCode}" appid='${item.m_ApplicationID}' moduleID=${subitem.moduleID} class="ui-widget-content">${subitem.m_CName}</li>		
				</#if>
			</#list>
			</ol>
			</#if>
		</#list>	
		</div>		
	</div>
</div>
<input type='hidden' id='RoleID' name='RoleID' value='${RoleID}' />
<script>	
$(function() {
	var $RolePermissonList= $('#RolePermissonList');
	var $PermissonList= $('#PermissonList');
	var url = $('#${Helpers.controller}thisuri').val();
	var id = $('input#RoleID').val();
	var pageCode,p_Value=0,appid;
	
	$('#UpdatePermisson').click(function(){	
		if (Number(p_Value)<0)
			p_Value=0;
		$.post(url+'/UpdateRolePermisson/'+id,{pageCode:pageCode,p_Value:p_Value,ApplicationID:appid});
		return false;
	});	
	
	$('li',$('#RolePermissonList,#PermissonList')).draggable({
		cancel: 'a.ui-icon',
		revert: 'invalid',
		//containment: $('#demo-frame').length ? '#demo-frame' : 'document', // stick to demo-frame if present
		helper: 'clone',
		cursor: 'move'
	});	
	$RolePermissonList.droppable({
		accept: '#PermissonList li',
		drop: function(ev, ui) {
			recycleImage(ui.draggable);
		}
	});		
	$PermissonList.droppable({
		accept: '#RolePermissonList > li',
		//activeClass: 'ui-state-highlight',
		drop: function(ev, ui) {
			deleteImage(ui.draggable);
		}
	});	
	function recycleImage($item) {
		$item.fadeOut(function() {
			//$.post(url+'/CreateRolesUser/'+id, 'userId='+userid);
			p_Value = Number(p_Value) - Number($item.attr('pv'));
			$item.find('img').end().appendTo($RolePermissonList).fadeIn();
		});
	}	
	function deleteImage($item) {		
		$item.fadeOut(function() {	
			var $list = $('ul',$PermissonList).length ? $('ul',$PermissonList) : $('<ul class="RolePermissonList ui-helper-reset"/>').appendTo($PermissonList);
			//$.post(url+'/DeleteRolesUser/'+id, 'userId='+userid);
			p_Value = Number(p_Value) + Number($item.attr('pv'));
			$item.appendTo($list).fadeIn();
		});
	}	
	$("#${Helpers.controller}_accordion").accordion({
		autoHeight: false,
		collapsible: true,
		alwaysOpen: false		    
	});	
	$('ol').each(function(){
		$(this).selectable({
			selected:function(event, ui){				
				pageCode = $(this).find('li.ui-selected').attr('id');
				appid = $(this).find('li.ui-selected').attr('appid'); 
				$("li[id='permissValue']").appendTo($('#RolePermissonList')).fadeIn();
				$.getJSON(url+'/GetRolePermisson/'+id, 'pageCode='+pageCode,function(json){					
					if(json.length>0){
						var v =0;
						p_Value = 0;
						for(v=0; v<json.length; v++){										

						p_Value = Number(p_Value) + Number(json[v].permissValue);
						
							$("li[PermissValue='permissValue"+json[v].permissValue+"']").appendTo($('#PermissonList')).fadeIn();	
							//alert("li[PermissValue='permissValue'"+json[v].permissValue+"]");
						}												
					}
				});
			}
		});
	});	
});			
</script>
<style type="text/css">
#GetRolePermisson { float: left; width: 76%; min-height: 12em; } * html 
#GetRolePermisson { height: 12em; } /* IE6 */
.RolePermissonList li { float: left; width: 54px; padding: 0.4em; margin: 0 0.4em 0.4em 0; text-align: center; }
.RolePermissonList li h5 { margin: 0 0 0.4em; cursor: move; }
.RolePermissonList li img { width: 100%; cursor: move; }

#ModuleBox { float: right; width: 18%; min-height: 18em; padding: 1%;} * html 
#ModuleBox { height: 18em; } /* IE6 */

#feedback { font-size: 1.4em; }
#selectable .ui-selecting { background: #FECA40; }
#selectable .ui-selected { background: #F39814; color: white; }
#selectable { list-style-type: none; margin: 0; padding: 0;}
#selectable li { margin: 3px; padding: 0.4em;  height: 14px; }
</style>