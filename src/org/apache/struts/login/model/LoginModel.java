package org.apache.struts.login.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.db.DbManager.DbManager;

public class LoginModel {

	private String loginName;
	private String loginPw;
	private String pwhash;
	
	public LoginModel(){
		
		this.loginName="";
		this.loginPw="";
		
	}
	
	public void setLoginName(String loginName){
		
		this.loginName = loginName;
	}
	
	public String getLoginName(){
		
		return loginName;
	}

	public void setLoginPw(String pw){
		this.loginPw = pw;
	}
	
	public String getLoginPw(){
		
		return loginPw;
	}

	public boolean getPwHashFromDb(String username) {
		
		boolean status = false;
		
		try{
			
			DbManager dbman = new DbManager();
			Connection c = dbman.connect();
			PreparedStatement stmt;
			ResultSet rs;
			
			
			if ( c != null){
				
				stmt = c.prepareStatement("Select pwhash from users where user_name = ?");
				stmt.setString(1, getLoginName());
				rs = stmt.executeQuery();
				
				if ( rs.next() ){
					
					this.pwhash = rs.getString(1);
					status = true;
				}
			
				dbman.disconnect(c);
			
			}
			
			else
				status = false;
		}
		catch(Exception e){
			status =  false;
		}
		return status;
	}
	
	public String getPwHash(){
		
		return this.pwhash;
	}
	
}
