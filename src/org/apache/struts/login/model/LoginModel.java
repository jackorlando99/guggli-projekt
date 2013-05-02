package org.apache.struts.login.model;

public class LoginModel {

	private String loginName;
	private String loginPw;
	private String errormessage;
	
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
	public String getErrormessage() {
        return errormessage;
    }
    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }
}
