<#include "/common/control.ftl">
<div class="window_aside" id="${Helpers.controller}">
<@ImgQButton id="refresh" action="refresh" title="刷新本页" auth=false icon="refresh"/>
</div>
<div class="window_main" id="${Helpers.controller}">
	
</div>

<style type="text/css">
</style>
<@Script />
<script>
$(function() {	
	JQD.window_resize($Twindos);
});		
</script>