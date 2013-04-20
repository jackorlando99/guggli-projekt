package org.apache.struts.docs.action;

//import org.apache.struts.docs.model.DocsModel;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

public class DocsCreateAction extends ActionSupport{

	/**
	 * Dokok letrehozasa
	 */
	//private DocsModel dok;
	private static final long serialVersionUID = 1L;
	private String docName;
	private String text;
	 	
	
	
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
	        String filePath = "C:/projectSave";  //mondjuk erre kikene talani vmit
	        
			  File fileToCreate = new File(filePath, this.docName+".html");
			  FileUtils.writeStringToFile(fileToCreate, this.text);
			  
		}catch(Exception e){}
		return SUCCESS;
	}

	 
	
}
