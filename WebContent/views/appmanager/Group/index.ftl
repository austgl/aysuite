<#include "/common/control.ftl">
<div class="window_aside" id="${Helpers.controller}">
<@ImgQButton id="refresh" action="Add" title="新增" class="refresh"/><br />

<#macro GroupTree modeules>
	<#if catalogs?has_content>
		<#list modeules as item>
			<#if item.g_ParentID==0>
				<span id='${item.groupID}' ParentID='${item.g_ParentID}'>${item.g_CName}</span> 
			</#if>
		<@show modeules=item.child/>
		</#list>
	</#if>
</#macro>


	<ul class='tree' id="${Helpers.controller}"> 
		<li> 
			<#macro GroupTree myGroup>
		</li>  
	</ul> 
</div>
<div class="window_main">
</div>
<script>
$(function() {
	//createTree($('#group.tree').find("span[ParentID!=0]"));
	createTree("fdsf");
	//$('#${Helpers.controller}.tree').tree({animate:true});
	$('#refresh').click(function(){
		$('#${Helpers.controller}').parent().load('${Helpers.uri}');
		return false;
	});	
});		
</script>