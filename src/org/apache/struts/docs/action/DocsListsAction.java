package org.apache.struts.docs.action;

import java.util.List;

import org.apache.struts.dbconn.DBConn;
import org.apache.struts.docs.model.DirsList;
import org.apache.struts.docs.model.DocsList;

import com.opensymphony.xwork2.ActionSupport;

public class DocsListsAction extends ActionSupport{
	private DBConn dbc; 
	private String userName;
	private DocsList userlist;
	private String aktDir;
	
	private List<DocsList> userlistlist;
	private List<DirsList> dirslistlist;
	private int parentID = 1;
	private int DirMelyseg = 0;
	private int userID=1;

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

			userlistlist=dbc.fetch(userID);//egyenlore 1 mert tesztelema mukodest
			dirslistlist=dbc.fetchDirs(userID);//egyenlore 1 mert tesztelema mukodest
			
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

		public String getAktDir() {
			if(DirMelyseg  == 0){
				DirsLeker(userID);
			}else{
			    DirsLeker(parentID );	
			}
			
			return aktDir;
		}


		//lekeri
		private void DirsLeker(int parentID) {
			
		  	dbc = new DBConn();
			dbc.connect(); 
		  dbc.dirsLeker(parentID);//userID proba
		
		}

		public void setAktDir(String aktDir) {
			this.aktDir = aktDir;
		}

		public List<DirsList> getDirslistlist() {
			return dirslistlist;
		}

		public void setDirslistlist(List<DirsList> dirslistlist) {
			this.dirslistlist = dirslistlist;
		}

		
		/*
 * listaza egy csoport id alapjan az oda tartozo dokokat
 * ha nicns dok akkor üzi h nicns dok
 * 
 * 
 */

}
