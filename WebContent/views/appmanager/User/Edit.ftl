<#include "/common/control.ftl"> 
<form action="" method="POST">
<div id="wrapper">
	<fieldset class="ui-widget-content ui-corner-all edit" id="development" > 
	<legend class="ui-widget-header ui-corner-all">新增用户</legend> 	
		<input type="hidden" id="UserID" name="UserID" value='${myUser.userID}' /> 				
		<label for="U_LoginName">名称</label> 
		<input type="text" id="U_LoginName" name="U_LoginName" class="text ui-widget-content ui-corner-all"  /> 		

		<label for="U_Password">密码</label> 
		<input type="Password" id="U_Password" name="U_Password" class="text ui-widget-content ui-corner-all" /> 		
		
		<label for="U_CName">姓名</label> 
		<input type="text" id="U_CName" name="U_CName" class="text ui-widget-content ui-corner-all" /> 		
		
		<label for="U_EName">英文名</label> 
		<input type="text" id="U_EName" name="U_EName" class="text ui-widget-content ui-corner-all" /> 	
	</fieldset>		
	</div>			
	<div id="wrapper">
	<fieldset class="ui-widget-content ui-corner-all edit" id="development" > 
		<legend class="ui-widget-header ui-corner-all">新增用户</legend> 
<label for="U_GroupID">用户组</label> 
		<input type="text" id="U_GroupID" name="U_GroupID" class="text ui-widget-content ui-corner-all"  />

		<label for="U_Type">用户类型</label> 
		<input type="text" id="U_Type" name="U_Type" class="text ui-widget-content ui-corner-all" /> 	

		<label for="U_Status">状态</label> 
		<input type="text" id="U_Status" name="U_Status" class="text ui-widget-content ui-corner-all" /> 
		
		<label for="U_Sex">性别</label> 
		<input type="text" id="U_Sex" name="U_Sex" class="text ui-widget-content ui-corner-all" />
		
	</fieldset>		
	</div>
<input type="hidden" id="U_Licence" name="U_Licence" /> 	
<input type="hidden" id="U_Mac" name="U_Mac" /> 		
<input type="hidden" id="U_Remark" name="U_Remark" /> 		 
<input type="hidden" id="U_IDCard" name="U_IDCard" /> 		
<input type="hidden" id="U_BirthDay" name="U_BirthDay" /> 		
<input type="hidden" id="U_MobileNo" name="U_MobileNo" /> 		
<input type="hidden" id="U_UserNO" name="U_UserNO" /> 		
<input type="hidden" id="U_WorkStartDate" name="U_WorkStartDate" /> 		
<input type="hidden" id="U_WorkEndDate" name="U_WorkEndDate" /> 		
<input type="hidden" id="U_CompanyMail" name="U_CompanyMail" /> 		
<input type="hidden" id="U_Title" name="U_Title" /> 		
<input type="hidden" id="U_Extension" name="U_Extension" /> 		
<input type="hidden" id="U_HomeTel" name="U_HomeTel" /> 		
<input type="hidden" id="U_PhotoUrl" name="U_PhotoUrl" /> 		
<input type="hidden" id="U_DateTime" name="U_DateTime" /> 		
<input type="hidden" id="U_LastIP" name="U_LastIP" /> 		
<input type="hidden" id="U_LastDateTime" name="U_LastDateTime" /> 		
<input type="hidden" id="U_ExtendField" name="U_ExtendField" /> 		
<input type="hidden" id="U_Education" name="U_Education"  />  		
<input type="hidden" id="U_Wedding" name="U_Wedding" />  		 
<input type="hidden" id="U_MailingAddress" name="U_MailingAddress" />  
<input type="hidden" id="U_PativePlace" name="U_PativePlace" />  		
<input type="hidden" id="U_PativePlaceAdd" name="U_PativePlaceAdd" />  
</form>	


<style type="text/css">
#wrapper {
	float: left; 
	width: 160px;
}
</style>