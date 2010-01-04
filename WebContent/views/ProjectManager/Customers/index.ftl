<ol id="selectable">
<#list myCustomers as item>
	<li id="${item.customerID}" userid="${item.c_UserID}" class="ui-widget-content submit">${item.c_CustomerName}</li>
</#list>
</ol>

<script>
$(function() {	
	var url = $('#ResManagerloadUrl').val();	
	
	$('ol>li').click(function(){
		var id=$(this).attr('userid');
		$('.ResourcesList').load(url+'/List',{AdminId:id});
	});
});	
</script>

