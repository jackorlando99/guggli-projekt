package org.apache.struts.docs.model;

import java.sql.Date;

public class DirsList {
	private int id;
	private String name;
	private int parentDirID;
	private String shared;
	//private int userID;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String nev) {
		this.name = nev;
	}
	public int getParentDirID() {
		return parentDirID;
	}
	public void setParentDirID(int parentDirID) {
		this.parentDirID = parentDirID;
	}
	public String getShared() {
		return shared;
	}
	public void setShared(String shared) {
		this.shared = shared;
	}


}
