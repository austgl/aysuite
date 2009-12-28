<#include "/common/control.ftl">
	<input type="hidden" id="B_Userid" name="B_Userid" value='${MyUserTicket.userID}' /> 		

	<input type="hidden" id="B_Url" name="B_Url" value='${Helpers.uri}' /> 		

	<input type="hidden" id="B_Module" name="B_Module" value='${Helpers.controller}' /> 	
	<textarea name="B_BugContent" id="B_BugContent" rows="5" cols="47" class="text ui-widget-content ui-corner-all"></textarea> 	
<script>
$(function() {	
	
});		
</script>	