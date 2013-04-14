package org.apache.struts.docs.action;

import org.apache.struts.docs.model.DocsModel;

import com.opensymphony.xwork2.ActionSupport;

public class DocsCreateAction extends ActionSupport{

	/**
	 * Dokok letrehozasa
	 */
	private DocsModel dok;
	private static final long serialVersionUID = 1L;
	private String docName;
	 
	public String getDocname() {
		return docName;
	}
 
	public void setDocname(String dname) {
		this.docName = dname;
	}
 
	@Override
	public String execute(){
		//vmi ide kell? meg nem ertem telejsen
		//feltoltes class??
		return SUCCESS;
	}
	
	public void setDok(DocsModel d){
		dok = d;
	}
	
	//bekeri a dok nevet egy formban
	/*if(dok.getNev().lenght()==0){
	 * addFieldError( "dok.getNev", "nev kell")
	 * akkor neveó kotelezo
	 * }
	 * 
	 * */
	 
	
}
