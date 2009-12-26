<#macro page title jspath="../../">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="utf-8">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" content="utf-8" />
<meta content="all" name="robots" />
<meta name="author" content="网站作者,可以添加网址或者邮箱" />
<meta name="Copyright" content="网站地址,版权说明" />
<meta name="descrīption" content="网站性质描述" />
<meta name="keywords"content="关键字列表,用逗号分割" />
<link rel="icon" href="${jspath?html}views/icon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="${jspath?html}views/icon.ico" type="image/x-icon" />

<script type="text/javascript" src="${jspath?html}views/js/jquery-1.3.2.js"></script>	
<script type="text/javascript" src="${jspath?html}views/js/jquery-ui-1.7.2.js"></script>
<script type="text/javascript" src="${jspath?html}views/js/jquery.bgiframe.js"></script>
<script type="text/javascript" src="${jspath?html}views/js/jquery.desktop.js"></script>
<script type="text/javascript" src="${jspath?html}views/js/ui.formValidator_min.js"></script>
<script type="text/javascript" src="${jspath?html}views/js/jquery.form.js"></script>
<script type="text/javascript" src="${jspath?html}views/js/jquery.linkbutton.js"></script>
<script type="text/javascript" src="${jspath?html}views/js/jquery.tree.js"></script>
<script type="text/javascript" src="${jspath?html}views/js/jquery.jgrowl.js"></script>
<script type="text/javascript" src="${jspath?html}views/js/ui.ariaSorTable.js"></script>


<link rel="stylesheet" type="text/css" href="${jspath?html}views/css/desktop.css">
<link rel="stylesheet" type="text/css" href="${jspath?html}views/css/html.css">
<link rel="stylesheet" type="text/css" href="${jspath?html}views/css/ui-start.css">
<link rel="stylesheet" type="text/css" href="${jspath?html}views/css/Formular.css">
<link rel="stylesheet" type="text/css" href="${jspath?html}views/css/linkbutton.css">
<link rel="stylesheet" type="text/css" href="${jspath?html}views/css/linkbuttonicon.css">
<link rel="stylesheet" type="text/css" href="${jspath?html}views/css/tree.css">
<link rel="stylesheet" type="text/css" href="${jspath?html}views/css/icon.css">
<link rel="stylesheet" type="text/css" href="${jspath?html}views/css/jquery.jgrowl.css">
<!--[if gte IE 7]>
<link rel="stylesheet" type="text/css" href="${jspath?html}views/css/ie.css">
<![endif]-->
<!--[if gte IE 6]>	
	<style type="text/css">@import url(c${jspath?html}views/css/Formular_ie.css);</style>
<![endif]-->
<title>AySuite---${title?html}</title>

</head>

<div class="abs" id="desktop">
<#if MyUserTicket.u_Type==0>
	<a class="abs icon" style="left:20px;top:20px;" href="#icon_dock_computer" title="MyComputer">
		<img src="views/images/icons/icon_32_computer.png" />
		Computer
	</a>	
	<a class="abs icon" style="left:20px;top:100px;" href="#icon_dock_drive" loadurl="Development" title="MyDrive">
		<img src="views/images/icons/icon_32_drive.png" />
		Development
	</a>	
</#if>	
	<div id="window_computer" class="abs window" style='position: absolute;'>	
		<div class="abs window_inner">
			<div class="window_top ui-widget-header">
				<span class="float_left">
					<img src="views/images/icons/icon_16_computer.png" />
					<div id="title">Computer</div>
				</span>
				<span class="float_right">
					<a href="#" class="window_min"></a>
					<a href="#" class="window_resize"></a>
					<a href="#icon_dock_computer" class="window_close"></a>
				</span>
			</div>
			<div class="abs window_content">
				<div class="window_aside">
					Hello. You look nice today!
				</div>
				<div class="window_main">
					<table class="data">
						<tr>
							<th class="shrink">
								&nbsp;
							</th>
							<th>
								Name
							</th>
							<th>
								Date Modified
							</th>
							<th>
								Date Created
							</th>
							<th>
								Size
							</th>
							<th>
								Kind
							</th>
						</tr>
						<tr>
							<td>
								<img src="views/images/icons/icon_16_trash.png" />
							</td>
							<td>
								Trash
							</td>
							<td>
								Today
							</td>
							<td>
								&mdash;
							</td>
							<td>
								&mdash;
							</td>
							<td>
								Bin
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="abs window_bottom ui-state-active">
				Build: AY2009-12-26
			</div>
		</div>
		<span class="abs ui-resizable-handle ui-resizable-se"></span>
	</div>

</div>


<div class="abs" id="bar_top">
	<span class="float_right" id="clock"></span>
	<ul>
		<li id="modulemenu">
			<li id="modulemenu2"><a class="menu_trigger" href="#">开始</a>
				<ul class="menu">
					<li><a href="Permission/UserLogout">注销</a></li>
					<li><a href="#">${MyUserTicket.u_CName}{${MyUserTicket.u_LoginName}}</a></li>					
				</ul>
			</li>
		</li>
		<#list myModule as item>
			<#if item.m_ParentID==0>
			<li id="modulemenu">				
				<a class="menu_trigger" href="#">${item.m_CName}</a>
				<ul class="menu">
				<#list myModule as subitem>
					<#if item.moduleID==subitem.m_ParentID>
						<li>
							<a class="submenu" href="${item.m_Directory}/${subitem.m_Directory}" PageCode="${subitem.m_PageCode}" id="${subitem.moduleID}" Icon="${subitem.m_Icon}" Directory="${subitem.m_Directory}" >${subitem.m_CName}</a>
						</li>				
					</#if>
				</#list>
				</ul>
			</li>
			</#if>		
		</#list>
		<li><div id="switcher"></div></li>
	</ul>
</div>
<div id="bar_bottom" class="abs ui-state-default ui-corner-all">
	<a class="float_left" href="#" id="show_desktop" title="Show Desktop">
		<img src="views/images/icons/icon_22_desktop.png" />
	</a>
	<ul id="dock">
		<li id="icon_dock_computer">
			<a href="#window_computer">
				<img src="views/images/icons/icon_22_computer.png" />
				<div id="title"></div>
			</a>
		</li>
	</ul>
	<a class="float_right" href="#" title="Secure Hosting">
		<img src="views/images/misc/firehost.png" />
	</a>
</div>
<div id="Deldialog" title="警告">
	<p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>此操作将不可恢复，你确定删除本条数据吗？</p>
</div>
<!----
<script type="text/javascript" src="http://jqueryui.com/themeroller/themeswitchertool/"></script>
--->	
<script>
JQD.init_desktop();
$(function() {		
	//$('#switcher').themeswitcher();
	$('ul>#modulemenu').each(function(){
		//alert($(this).children().find('a').html());
		if ($(this).children().find('a').html()==null)
			//alert($(this).html());
			$(this).empty();
	})
});		
</script>
	
<#nested>
</body>
</html>
</#macro>