package org.apache.struts.docs.model;

import java.sql.Date;

public class DirsList {
	private int id;
	private String name;
	private int parentDirID;
	private boolean shared;
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
	public boolean isShared() {
		return shared;
	}
	public void setShared(boolean shared) {
		this.shared = shared;
	}

}
