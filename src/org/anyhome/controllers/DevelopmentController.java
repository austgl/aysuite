/* ***********************************************
 * author :  Anyhome
 * email  :  ayhome@gmail.com 
 * function: 
 * @date 2009-12-12
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
import java.util.ArrayList;
import java.util.List;

import org.anyhome.models.MyDevelopment;

import com.et.ar.ConnectionHolder;
import com.et.ar.exception.DataAccessException;
import com.et.mvc.FreeMarkerView;

/**
 * @author Ayhome
 *
 */
public class DevelopmentController extends AdminController {

	public FreeMarkerView index() throws DataAccessException, SQLException{
		FreeMarkerView view = new FreeMarkerView();
		
		ConnectionHolder connectionHolder = new ConnectionHolder(MyDevelopment.class);
		Connection conn = connectionHolder.getConnection();
		DatabaseMetaData dbmd = conn.getMetaData();
		String[] types = { "TABLE" };
		ResultSet resultSet = dbmd.getTables(null, null, "%", types);
		List<MyDevelopment> myDevelopment  = new ArrayList<MyDevelopment>();;
		while (resultSet.next()) {
		      MyDevelopment myd = new MyDevelopment();
		      myd.setDatabaseType("sql server");
		      myd.setTablename(resultSet.getString(3));
		      myDevelopment.add(myd);
		}
		view.setAttribute("tablelist", myDevelopment);		
		
		return view;
	}
	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws DataAccessException
	 */
	public FreeMarkerView CreateModel()throws SQLException, DataAccessException{
		FreeMarkerView view = new FreeMarkerView();
		String table = request.getParameter("tableName");
		String sql = "select * from "+ table;
		ResultSetMetaData rsmd = null;
		ConnectionHolder connectionHolder = new ConnectionHolder(MyDevelopment.class);
	    try{
	        Connection conn = connectionHolder.getConnection();
	        Statement stmt=conn.createStatement();
	        ResultSet rs=stmt.executeQuery(sql);            
	        rsmd = rs.getMetaData();               
	    }
	    finally{
	        connectionHolder.close();            
	    }
	    List<MyDevelopment> myDevelopment  = new ArrayList<MyDevelopment>();;
	    for(int i=1;i<=rsmd.getColumnCount();i++){
	    	MyDevelopment myd = new MyDevelopment();
		    myd.setDatabaseType("sql server");
		    myd.setTablename(table);
		    myd.setColumnType(rsmd.getColumnTypeName(i).trim().toLowerCase());
		    myd.setColumName(rsmd.getColumnName(i).trim());
		    myDevelopment.add(myd);        	
	    }
	            
	    view.setAttribute("tables", table);
	    view.setAttribute("myDevelopment", myDevelopment);        
		return view;
	}
	public FreeMarkerView CreateViews() throws SQLException, DataAccessException{
		FreeMarkerView view = new FreeMarkerView();
		String table = request.getParameter("tableName");
		String sql = "select * from "+ table;
		ResultSetMetaData rsmd = null;
		ConnectionHolder connectionHolder = new ConnectionHolder(MyDevelopment.class);
	    try{
	        Connection conn = connectionHolder.getConnection();
	        Statement stmt=conn.createStatement();
	        ResultSet rs=stmt.executeQuery(sql);            
	        rsmd = rs.getMetaData();               
	    }
	    finally{
	        connectionHolder.close();            
	    }
	    List<MyDevelopment> myDevelopment  = new ArrayList<MyDevelopment>();;
	    for(int i=1;i<=rsmd.getColumnCount();i++){
	    	MyDevelopment myd = new MyDevelopment();
		    myd.setDatabaseType("sql server");
		    myd.setTablename(table);
		    myd.setColumnType(rsmd.getColumnTypeName(i).trim());
		    myd.setColumName(rsmd.getColumnName(i).trim());
		    myDevelopment.add(myd);        	
	    }
	            
	    view.setAttribute("tables", table);
	    view.setAttribute("myDevelopment", myDevelopment);        
		return view;
	}
	public FreeMarkerView CreateController(){
		FreeMarkerView view = new FreeMarkerView();
		String table = request.getParameter("tableName");
		view.setAttribute("tables", table);
		return view;		
	}
	
}
