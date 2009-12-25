
<div class="window_aside">
	<div id="accordion">
		<h3><a href="#">功能</a></h3>
		<div>
		<#list tablelist as item>	
			<a href="${item.tablename}">${item.tablename}</a><br />
		</#list>
		</div>
		<h3><a href="#">说明</a></h3>
		<div>说明</div>
	</div>
</div>
<div class="window_main">
	<fieldset class="ui-widget-content ui-corner-all">
		<legend class="ui-widget-header ui-corner-all">Et-model</legend>
		<textarea id="model" name="model" rows="13" cols="" class="text ui-widget-content ui-corner-all"></textarea>
	</fieldset>	
	<fieldset class="ui-widget-content ui-corner-all">
		<legend class="ui-widget-header ui-corner-all">Et-Contrallor</legend>
		<textarea id="Contrallor" name="Contrallor" rows="13" cols="" class="text ui-widget-content ui-corner-all"></textarea>
	</fieldset>		
	<fieldset class="ui-widget-content ui-corner-all">
		<legend class="ui-widget-header ui-corner-all">Et-View</legend>
		<textarea id="View" name="View" rows="13" cols="" class="text ui-widget-content ui-corner-all"></textarea>
	</fieldset>
</div>
<script type="text/javascript">
	$(function() {
		//$(".window_aside").resizable({minHeight: 140});
		
		$("#accordion").accordion({
		    autoHeight: false,
		    fillSpace: true,
		    collapsible: true,
		    alwaysOpen: false		    
		});
		$('#accordion>div').find('A').click(function(){
			var tablename = $(this).html();
			$('.window_main').find('#model').load('Development/CreateModel?tableName='+tablename).text();
			$('.window_main').find('#View').load('Development/CreateViews?tableName='+tablename,{},function(){
				$(this).html($(this).html());
			});
			return false;
		})
		
	});
</script>	