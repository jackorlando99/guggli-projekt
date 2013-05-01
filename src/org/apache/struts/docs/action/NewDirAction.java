package org.apache.struts.docs.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts.dbconn.DBConn;

import com.opensymphony.xwork2.ActionSupport;

public class NewDirAction extends ActionSupport{
	 /**
	 * 
	 */
	private static final long serialVersionUID = -4321338384091681269L;
	private DBConn dbc;
	private String newDocName;
	private int dirParent;

	public String execute() {
   	  try{
   	      
   		  dbc = new DBConn();
   				dbc.connect(); 
   				dbc.newDir(2,getNewDocName(),aktDirID(),1);
   				//System.out.println(dbc.lekerdezUserName());
   	  }catch(Exception e)
   	        {
   	        	System.out.println("NEM: "+e.getMessage());
   	 
   	        }
       return SUCCESS;
    }

	private int aktDirID() {
		int dir = DocsListsAction.getPID();
		return dir;
	}

	public String getNewDocName() {
		return newDocName;
	}

	public void setNewDocName(String newDocName) {
		this.newDocName = newDocName;
	}

	public int getDirParent() {
		return dirParent;
	}

	public void setDirParent(int dirParent) {
		this.dirParent = dirParent;
	}
}
