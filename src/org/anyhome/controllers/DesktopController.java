/* ***********************************************
 * author :  Anyhome
 * email  :  ayhome@gmail.com 
 * function: 
 * @date 2009-12-8
 * history:  created by Anyhome
 * ***********************************************/
 
/**
 * 
 */
package org.anyhome.controllers;

import java.util.ArrayList;
import java.util.List;

import org.anyhome.models.MyModule;

import com.et.ar.exception.ActiveRecordException;
import com.et.mvc.FreeMarkerView;

/**
 * @author anyhome
 *
 */
public class DesktopController extends BaseController {
	public FreeMarkerView index() throws ActiveRecordException{
		FreeMarkerView view = new FreeMarkerView();		
		List<MyModule> myModule = new ArrayList<MyModule>();
		if (MyUserTicket.getU_Type()==0){
			myModule = MyModule.findAll(MyModule.class,"M_Close=0",
					new Object[]{});			
		}else{
			myModule = MyModule.findAll(MyModule.class,"(M_Close=0 and M_ParentID=0 and M_IsSystem=1) or M_PageCode in"+
					"(select p_pagecode from Ay_RolePermission A,Ay_UserRoles B where r_userid=? "+
					"and A.P_RoleID = B.R_RoleID)",
					new Object[]{MyUserTicket.getUserID()});
		}
		view.setAttribute("myModule", myModule);		
		return view;
	}
}
