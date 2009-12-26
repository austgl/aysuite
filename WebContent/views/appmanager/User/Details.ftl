<#include "/common/control.ftl"> 
<form action="" method="POST">
<div id="wrapper">
	<fieldset class="ui-widget-content ui-corner-all edit" id="development" > 
	<legend class="ui-widget-header ui-corner-all">${myUser.u_CName}的资料</legend> 	
		<input type="hidden" id="UserID" name="UserID" value='${myUser.userID}' /> 				
		<label for="U_LoginName">名称</label> 
		<input type="text" id="U_LoginName" name="U_LoginName" class="text ui-widget-content ui-corner-all" value='${myUser.u_LoginName}' /> 		

		<label for="U_Password">密码</label> 
		<input type="Password" id="U_Password" name="U_Password" class="text ui-widget-content ui-corner-all" value='${myUser.u_Password}' /> 		
		
		<label for="U_CName">姓名</label> 
		<input type="text" id="U_CName" name="U_CName" class="text ui-widget-content ui-corner-all" value='${myUser.u_CName}' /> 		
		
		<label for="U_EName">英文名</label> 
		<input type="text" id="U_EName" name="U_EName" class="text ui-widget-content ui-corner-all" value='${myUser.u_EName?default("")}' /> 	
	</fieldset>		
	</div>			
	<div id="wrapper">
	<fieldset class="ui-widget-content ui-corner-all edit" id="development" > 
		<legend class="ui-widget-header ui-corner-all">${myUser.u_CName}的资料</legend> 
<label for="U_GroupID">用户组</label> 
		<input type="text" id="U_GroupID" name="U_GroupID" class="text ui-widget-content ui-corner-all" value='${myUser.u_GroupID}' />

		<label for="U_Type">用户类型</label> 
		<input type="text" id="U_Type" name="U_Type" class="text ui-widget-content ui-corner-all" value='${myUser.u_Type}' /> 	

		<label for="U_Status">状态</label> 
		<input type="text" id="U_Status" name="U_Status" class="text ui-widget-content ui-corner-all" value='${myUser.u_Status}' /> 
		
		<label for="U_Sex">性别</label> 
		<input type="text" id="U_Sex" name="U_Sex" class="text ui-widget-content ui-corner-all" value='${myUser.u_Sex?default("")}' />
		
	</fieldset>		
	</div>
<input type="hidden" id="U_Licence" name="U_Licence" value='${myUser.u_Licence?default("")}' /> 	
<input type="hidden" id="U_Mac" name="U_Mac" value='${myUser.u_Mac?default("")}' /> 		
<input type="hidden" id="U_Remark" name="U_Remark" value='${myUser.u_Remark?default("")}' /> 		 
<input type="hidden" id="U_IDCard" name="U_IDCard" value='${myUser.u_IDCard?default("")}' /> 		
<input type="hidden" id="U_BirthDay" name="U_BirthDay" value='${myUser.u_BirthDay?default("")}' /> 		
<input type="hidden" id="U_MobileNo" name="U_MobileNo" value='${myUser.u_MobileNo?default("")}' /> 		
<input type="hidden" id="U_UserNO" name="U_UserNO" value='${myUser.u_UserNO?default("")}' /> 		
<input type="hidden" id="U_WorkStartDate" name="U_WorkStartDate" value='${myUser.u_WorkStartDate?default("")}' /> 		
<input type="hidden" id="U_WorkEndDate" name="U_WorkEndDate" value='${myUser.u_WorkEndDate?default("")}' /> 		
<input type="hidden" id="U_CompanyMail" name="U_CompanyMail" value='${myUser.u_CompanyMail?default("")}' /> 		
<input type="hidden" id="U_Title" name="U_Title" value='${myUser.u_Title?default("")}' /> 		
<input type="hidden" id="U_Extension" name="U_Extension" value='${myUser.u_Extension?default("")}' /> 		
<input type="hidden" id="U_HomeTel" name="U_HomeTel" value='${myUser.u_HomeTel?default("")}' /> 		
<input type="hidden" id="U_PhotoUrl" name="U_PhotoUrl" value='${myUser.u_PhotoUrl?default("")}' /> 		
<input type="hidden" id="U_DateTime" name="U_DateTime" value='${myUser.u_DateTime?default("")}' /> 		
<input type="hidden" id="U_LastIP" name="U_LastIP" value='${myUser.u_LastIP?default("")}' /> 		
<input type="hidden" id="U_LastDateTime" name="U_LastDateTime" value='${myUser.u_LastDateTime?default("")}' /> 		
<input type="hidden" id="U_ExtendField" name="U_ExtendField" value='${myUser.u_ExtendField?default("")}' /> 		
<input type="hidden" id="U_Education" name="U_Education" value='${myUser.u_Education?default("")}' />  		
<input type="hidden" id="U_Wedding" name="U_Wedding" value='${myUser.u_Wedding?default("")}' />  		 
<input type="hidden" id="U_MailingAddress" name="U_MailingAddress" value='${myUser.u_MailingAddress?default("")}' />  
<input type="hidden" id="U_PativePlace" name="U_PativePlace" value='${myUser.u_PativePlace?default("")}' />  		
<input type="hidden" id="U_PativePlaceAdd" name="U_PativePlaceAdd" value='${myUser.u_PativePlaceAdd?default("")}' />  
</form>	


<style type="text/css">
#wrapper {
	float: left; 
	width: 160px;
}
</style>