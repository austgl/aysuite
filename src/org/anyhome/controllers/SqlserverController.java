/* ***********************************************
 * author :  Anyhome
 * email  :  ayhome@gmail.com 
 * function: 
 * @date 2009-11-13
 * history:  created by Anyhome
 * ***********************************************/
 
/**
 * 
 */
package org.anyhome.controllers;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.anyhome.controllers.AppManager.ApplicationsController;
import org.anyhome.models.MyApplications;
import org.anyhome.models.MyUser;

import com.et.ar.ConnectionHolder;
import com.et.ar.exception.DataAccessException;
import com.et.mvc.JspView;

/**
 * @author Ayhome
 *
 */
public class SqlserverController extends AdminController {
	
	public JspView CreateAR() throws SQLException, DataAccessException{	
		String table = request.getParameter("tableName");
        String sql = "select * from "+ table;        
        ResultSetMetaData rsmd = null;       
		ConnectionHolder connectionHolder = new ConnectionHolder(MyApplications.class);
        try{
            Connection conn = connectionHolder.getConnection();
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);            
            rsmd = rs.getMetaData();               
        }
        finally{
            connectionHolder.close();            
        }	
        JspView view = new JspView();
        view.setAttribute("tables", table);
        view.setAttribute("tableinfo", rsmd);
        return view;
	}
	
	public JspView index() throws DataAccessException, SQLException{                
		JspView view = new JspView();
		ConnectionHolder connectionHolder = new ConnectionHolder(MyUser.class);
		Connection conn = connectionHolder.getConnection();
		DatabaseMetaData dbmd = conn.getMetaData();
		String[] types = { "TABLE" };
		ResultSet resultSet = dbmd.getTables(null, null, "%", types);
		view.setAttribute("tablelist", resultSet);
		return view;			
	}
}

