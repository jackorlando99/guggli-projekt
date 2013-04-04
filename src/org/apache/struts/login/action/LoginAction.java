package org.apache.struts.login.action;

import org.apache.struts.login.model.LoginModel;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 123456789L;
	private LoginModel loginInfo;
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public LoginModel getLoginInfo(){
		
		return loginInfo;
	}
	
	public void setLoginInfo(LoginModel login){
		
		loginInfo = login;
	}
	
	public String getAuthInfo(){
		
		if ( loginInfo.getLoginName().equals("robi") && loginInfo.getLoginPw().equals("titkos") )
			return "Sikeres bejelentkezés";
		else
			return "Rossz felhasználónév vagy jelszó"; 
					
	}
	
	
	
}
