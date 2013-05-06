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
	private int delID;
	private List<DocsList> userlistlist;
	private List<DirsList> sharedirslistlist;
	private List<DirsList> dirslistlist;
	private int parentID;
	public int DirIDNow;
	private String parentDirName;
	private int userID=1;
	private static int pID=1;
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
			setUserName(dbc.lekerdezUserName(1));
			//ez a root szal root mappa id-je kell
			if(pID==0){
			int rootDir=dbc.getRootDir(dbc.lekerdezUserName(userID));
			userlistlist=dbc.fetch(rootDir);
			dirslistlist=dbc.fetchDirs(rootDir);
			//a felhasznaloval megosztott dokumentumok listazasa
			setSharedirslistlist(dbc.fetchShareDirs(userID));
			pID=rootDir;
			}else{
				userlistlist=dbc.fetch(pID);
				dirslistlist=dbc.fetchDirs(pID);

			}

/*			if(parentID != userID){
			dirslistlist=dbc.fetchDirs(getpID());//egyenlore 1 mert tesztelema mukodest
			
			}else{
				dirslistlist=dbc.fetchDirs(1);//egyenlore 1 mert tesztelema mukodest
				
			}*/
		}catch(Exception e){

		}
		return SUCCESS;
	
	}
	private void getDirIDNow(int i) {
		DirIDNow = i;
		
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
			if(parentID != userID){
			    DirsLeker(parentID );	
			}else{
				DirsLeker(userID);
			}
		
			return aktDir;
		}


		//lekeri
		private void DirsLeker(int parentID) {
			
		  	dbc = new DBConn();
			dbc.connect(); 
			dbc.fetchDirs(parentID);
		
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

		static public int getPID() {
			return pID;
		}

		public void setPID(int pID) {
			this.pID = pID;
		}

		public String getParentDirName() {
			dbc = new DBConn();
			dbc.connect(); 
			parentDirName = dbc.getDirName(getPID());
			
			return parentDirName;
		}

		public void setParentDirName(String parentDirName) {
			this.parentDirName = parentDirName;
		}

		public int getDelID() {
			return delID;
		}

		public void setDelID(int delID) {
			this.delID = delID;
		}

		public List<DirsList> getSharedirslistlist() {
			return sharedirslistlist;
		}

		public void setSharedirslistlist(List<DirsList> sharedirslistlist) {
			this.sharedirslistlist = sharedirslistlist;
		}


		
		/*
 * listaza egy csoport id alapjan az oda tartozo dokokat
 * ha nicns dok akkor üzi h nicns dok
 * 
 * 
 */

}
