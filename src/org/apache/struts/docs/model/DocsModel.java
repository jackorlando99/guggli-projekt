package org.apache.struts.docs.model;

import java.sql.Date;

public class DocsModel {
	private int id;
	private String nev;
	private Date created;
	private Date update;
	private String path;
	private int userID;
	// private mappaja
	// tartalma
	// letrehozoja
	//
	//
	//bekeri a csop
	
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
	
	/*dok kivalaszt id alapjan??
	 * 
	 * 
	 */
}
