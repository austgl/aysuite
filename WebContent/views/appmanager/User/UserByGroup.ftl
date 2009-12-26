	<ul id="UserBoxlsit" class="RolesUserBox ui-helper-reset ui-helper-clearfix">
	<#list myUser as item>
		<li class="ui-widget-content ui-corner-tr" id='Userid${item.userID}'  Userid='${item.userID}'>
			<h5 class="ui-widget-header">${item.u_CName}</h5>
			<img src='${item.u_PhotoUrl?default("views/css/images/dmenu_test_home.png")}' alt="${item.u_CName}" width="32" height="48" />
		</li>
	</#list>
	</ul>

<script>
$(function() {	
	var $UserEditD = $('#${Helpers.controller}edit');
	var url = $('#${Helpers.controller}thisuri').val();
	$('li[Userid]').click(function(){
		var userid= $(this).attr('Userid');
		var userName = $(this).find('h5').html();
		$UserEditD.attr('title',userName);
		if ($('.ui-dialog.user'+userid).html()!=null){
			$('.ui-dialog.user'+userid).effect('highlight',{},500,null);
			return false;
		}
		$(this).effect('highlight',{},300,function(){
			var $s=$UserEditD.clone().load(url+'/Details/'+userid);
			
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
						$(this).find('form').attr('action',url+'/SaveEdit/'+userid);
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