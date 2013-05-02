package org.apache.struts.docs.action;

import org.apache.struts.dbconn.DBConn;

import com.opensymphony.xwork2.ActionSupport;

public class DocsDeleteAction  extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2543217279310527579L;
	private DBConn dbc;
	private int delDirID = 0;
	private int delDocID = 0;
	private String docType;
	public String execute() {
		try{		
			dbc = new DBConn();
			dbc.connect(); 
	
			//ha a kapott id dir akkor mappat torol
			if(delDirID>0){
				dbc.delDir(getDelDirID());

				//egyebkent meg akkor docot kell torolnie
			}
			if(delDocID>0){
				
				dbc.delDoc(getDelDocID());


			}
			
			

		}catch(Exception e){

		}
		return SUCCESS;
	
	}
	public int getDelDirID() {
		return delDirID;
	}
	public void setDelDirID(int delDirID) {
		this.delDirID = delDirID;
	}
	public int getDelDocID() {
		return delDocID;
	}
	public void setDelDocID(int delDocID) {
		this.delDocID = delDocID;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
}
//dbc.delDir(delID);
