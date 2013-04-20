package org.apache.struts.docs.action;

//import org.apache.struts.docs.model.DocsModel;

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
		//vmi ide kell? meg nem ertem telejsen
		//feltoltes class??
		
		//
		return SUCCESS;
	}

	 
	
}
