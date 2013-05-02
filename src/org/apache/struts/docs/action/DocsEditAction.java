package org.apache.struts.docs.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts.dbconn.DBConn;
import org.apache.struts.docs.model.DocsModel;

import com.opensymphony.xwork2.ActionSupport;

public class DocsEditAction extends ActionSupport{

	/**
	 * Dokok letrehozasa
	 */
	//private DocsModel dok;
	private static final long serialVersionUID = 1L;
	private String docName;
	private int docID;
	private String text;
	private String docLoc;
	private DBConn dbc; 
	private String content;
	private DocsModel doc;

	
	
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


		dbc = new DBConn();
		dbc.connect(); 
		doc=new DocsModel(dbc.getDoc(docID));
	    setDocName(doc.getNev());
		setText(getContent());
		try{
	        String filePath = new File("saves").getAbsolutePath(); //elvileg megkeresi az eclipse mappajat es oda menti a saves mappába
	        // csak kikene ra tallani vmi mast, mas gepen mashova menti... es mas OSen is...
	  
			  File fileToCreate = new File(filePath, this.docName+".html");
			  FileUtils.writeStringToFile(fileToCreate, this.text);
			  	dbc = new DBConn();
				dbc.connect(); 
			  dbc.docUpdate(docID,getDocName());
				  
		}catch(Exception e){}
		return SUCCESS;
	}

	public String getDocLoc() {
		
		return docLoc;
	}

	public void setDocLoc(String docLoc) {
		this.docLoc = docLoc;
	}

 	private int aktDirID() {
		int dir = DocsListsAction.getPID();
		return dir;
	}

	public String getContent() {
		StringBuilder contentBuilder = new StringBuilder();
		try {
		    BufferedReader in = new BufferedReader(new FileReader(doc.getPath()));
		    String str;
		    while ((str = in.readLine()) != null) {
		        contentBuilder.append(str);
		    }
		    in.close();
		} catch (IOException e) {
		}
		content = contentBuilder.toString();
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getDocID() {
		return docID;
	}

	public void setDocID(int docID) {
		this.docID = docID;
	}
	
}