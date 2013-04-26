package org.apache.struts.docs.action;

//import org.apache.struts.docs.model.DocsModel;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts.dbconn.DBConn;

import com.opensymphony.xwork2.ActionSupport;

public class DocsCreateAction extends ActionSupport{

	/**
	 * Dokok letrehozasa
	 */
	//private DocsModel dok;
	private static final long serialVersionUID = 1L;
	private String docName;
	private String text;
	private String docLoc;
	private DBConn dbc; 

	
	
	public String getDocName() {
		return docName;
	}
 
	public void setDocName(String dname) {
		this.docName = dname;
	}
 

	public String getText() {
		return text;
	}
 
	public void setText(String t) {
		this.text = t;
	}
 
	
	@Override
	public String execute(){
		try{
	        String filePath = "C:/projectSave/";  //mondjuk erre kikene talani vmit
	  
			  File fileToCreate = new File(filePath, this.docName+".html");
			  FileUtils.writeStringToFile(fileToCreate, this.text);
			  	dbc = new DBConn();
				dbc.connect(); 
			  dbc.docUp(1,getDocName(),filePath+getDocName()+".html", 1);//userID proba
				  
		}catch(Exception e){}
		return SUCCESS;
	}

	public String getDocLoc() {
		
		return docLoc;
	}

	public void setDocLoc(String docLoc) {
		this.docLoc = docLoc;
	}

	 
	
}
