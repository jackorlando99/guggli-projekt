package org.apache.struts.docs.model;

import java.sql.Date;

public class DocsModel {
	private int id;
	private String nev;
	private Date created;
	private Date update;
	private String path;
	private int has_doc_id;
	private int userID;
	private String calendar;
	// private mappaja
	// tartalma
	// letrehozoja
	//
	//
	//bekeri a csop
	
	public DocsModel(DocsModel doc) {
		setId(doc.getId());
		setCreated(doc.getCreated());
		setUpdate(doc.getUpdate());
		setNev(doc.getNev());
		setPath(doc.getPath());
		setUserID(doc.userID);
		setHas_doc_id(doc.getHas_doc_id());
	}

	public DocsModel() {
		// TODO Auto-generated constructor stub
	}

	public int getId(){
		return id;
	}
	
	public void setId(int kapottid){
		this.id = kapottid;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Date getUpdate() {
		return update;
	}

	public void setUpdate(Date update) {
		this.update = update;
	}

	public int getHas_doc_id() {
		return has_doc_id;
	}

	public void setHas_doc_id(int has_doc_id) {
		this.has_doc_id = has_doc_id;
	}

	public String getCalendar() {
		return calendar;
	}

	public void setCalendar(String calendar) {
		this.calendar = calendar;
	}

	
	
	/*dok kivalaszt id alapjan??
	 * 
	 * 
	 */
}
