package org.apache.struts.docs.action;

import org.apache.struts.dbconn.DBConn;

import com.opensymphony.xwork2.ActionSupport;

public class DocsListsAction extends ActionSupport{
	private DBConn dbc; 
	private String userName;
	/**
	 * 
	 */
	private static final long serialVersionUID = -7605616524970998589L;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String execute() {
		try{		
		//	dbc = new DBConn();
		//	dbc.connect(); 
			//setUserName(dbc.lekerdezUserName());
			return NONE;
		}catch(Exception e){

			return SUCCESS;
		}
	}
/*
 * listaza egy csoport id alapjan az oda tartozo dokokat
 * ha nicns dok akkor üzi h nicns dok
 * 
 * 
 */

}
