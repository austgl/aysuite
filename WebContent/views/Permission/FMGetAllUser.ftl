<#list myUser as item>
<ul>
	<li class="ui-widget-content ui-corner-tr" id="${item.userID}" style="width: 80px;">
		<h5 class="ui-widget-header">${item.u_CName}</h5>
		<img src="${item.u_PhotoUrl?default("views/images/disc.png")}" alt="${item.u_CName}" />
	</li>
</ul>
</#list>