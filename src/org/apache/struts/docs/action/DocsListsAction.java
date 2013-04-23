package org.apache.struts.docs.action;

import java.util.List;

import org.apache.struts.dbconn.DBConn;
import org.apache.struts.docs.model.DocsList;

import com.opensymphony.xwork2.ActionSupport;

public class DocsListsAction extends ActionSupport{
	private DBConn dbc; 
	private String userName;
	private DocsList userlist;
	private List<DocsList> userlistlist;

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
			dbc = new DBConn();
			dbc.connect(); 
			setUserName(dbc.lekerdezUserName());

			userlistlist=dbc.fetch();
		}catch(Exception e){

		}
		return SUCCESS;
	
	}
	public DocsList getUserlist() {
		return userlist;
		}
		public void setUserlist(DocsList userlist) {
		this.userlist = userlist;
		}
		public List<DocsList> getUserlistlist() {
		return userlistlist;
		}
		public void setUserlistlist(List<DocsList> userlistlist) {
		this.userlistlist = userlistlist;
		}
/*
 * listaza egy csoport id alapjan az oda tartozo dokokat
 * ha nicns dok akkor üzi h nicns dok
 * 
 * 
 */

}
