<ul>
<#list myResources as item>
	<li class="ui-widget-content ui-corner-tr" id="${item.resID}" >
		<h5 class="ui-widget-header">${item.r_Name} </h5>
		<img src="views/images/computer.png" alt="${item.r_Name}" />
	</li>
</#list>
</ul>

<script>
$(function() {	
	var usrid = ${MyUserTicket.userID};
	var url = $('#ResManagerloadUrl').val();
	var $box = $('#${Helpers.controller}Box');  
	var $list = $('#${Helpers.controller}List');
	$('li',$('#${Helpers.controller}Box,#${Helpers.controller}List')).draggable({
		cancel: 'a.ui-icon',
		revert: 'invalid',
		helper: 'clone',
		cursor: 'move'
	});	
	$box.droppable({
		accept: '#${Helpers.controller}List li',
		activeClass: 'ui-state-highlight',
		drop: function(ev, ui) {
			recycleImage(ui.draggable);			
		}
	});
	function recycleImage($item) {		
		$item.fadeOut(function() {
		    var id = $item.attr('id');			
			$item.remove().fadeIn();
			$.post(url+'/Delete/',{id:id});
		});
	};
	$list.droppable({
		accept: '#${Helpers.controller}Box li',
		activeClass: 'ui-state-highlight',
		drop: function(ev, ui) {
			deleteImage(ui.draggable);
		}
	});	
	function deleteImage($item) {
		var r_Name =$item.find('h5').html();
		var r_UserID = ${R_UserID};
		$item.clone().appendTo($list).fadeIn(function(){
			$('li',$('#${Helpers.controller}List')).draggable({
				cancel: 'a.ui-icon',
				revert: 'invalid',				
				helper: 'clone',
				cursor: 'move'
			});	
		$.post(url+'/SaveCreate/',{R_Name:r_Name,R_UserID:r_UserID});			
		});	
	};	
	
});		
</script>