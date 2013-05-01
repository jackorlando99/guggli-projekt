package org.apache.struts.docs.action;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.struts.dbconn.DBConn;
import org.apache.struts.docs.model.DocsModel;

import com.opensymphony.xwork2.ActionSupport;

public class DocsViewAction  extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2543217279310527579L;
	private DBConn dbc;
	private DocsModel doc;
	private String docName, created,updated,user, calendar;

	private String text;
	private int docID = 0;
	private String path;
	private String content;
	public String execute() {
		try{		
			dbc = new DBConn();
			dbc.connect(); 
			doc=new DocsModel(dbc.getDoc(docID));

			setText(getContent());
		
			setDocName(doc.getNev());
			setCreated(String.valueOf(doc.getCreated()));
			setUpdated(String.valueOf(doc.getUpdate()));
			setUser(dbc.lekerdezUserName(doc.getUserID()));
			setPath(doc.getPath());
		//	setCalendar(doc.getCalendar());
		}catch(Exception e){

		}
		return SUCCESS;
	
	}
	public int getDocID() {
		return docID;
	}
	public void setDocID(int docID) {
		this.docID = docID;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public DocsModel getDoc() {
		return doc;
	}
	public void setDoc(DocsModel doc) {
		this.doc = doc;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getCalendar() {
		String str = "s";		
		if(calendar==null){
			str = "NEM";
			}else{
				str= "igen"; // es lekezelni h melyik naphoz stb?
			}
		return str;
	}
	public void setCalendar(String calendar) {
		
		this.calendar = calendar;
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}
