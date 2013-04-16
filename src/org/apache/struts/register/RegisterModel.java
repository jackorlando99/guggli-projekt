package org.apache.struts.register;

public class RegisterModel{
	
	private String loginFname;
	private String loginLname;
	private String loginName;
	private String loginEmail;
	private String loginPw;
	private String loginPw2;
	
	public RegisterModel(){
		loginFname="";
		loginLname="";
		loginName="";
		loginEmail="";
		loginPw="";
		loginPw2="";
	}
	
	public void setLoginFname(String fname){
		loginFname = fname;
	}
	public String getLoginFname(){
		return loginFname;
	}
	public void setLoginLname(String lname){
		loginLname = lname;
	}
	public String getLoginLname(){
		return loginLname;
	}
	public void setLoginName(String name){
		loginName = name;
	}
	public String getLoginName(){
		return loginName;
	}
	public void setLoginEmail(String email){
		loginEmail = email;
	}
	public String getLoginEmail(){
		return loginEmail;
	}
	public void setLoginPw(String pw){
		loginPw = pw;
	}
	public String getLoginPw(){
		return loginPw;
	}
	public void setLoginPw2(String pw){
		loginPw2 = pw;
	}
	public String getLoginPw2(){
		return loginPw2;
	}
	
	public String toString(){
		return "Regisztrált adatok: " + getLoginLname() + " " + getLoginFname() + " " + getLoginName() + " " + getLoginEmail() + " " + getLoginPw() + " " + getLoginPw2();
	}

	public boolean setToDb(){
		if ( getLoginPw().equals(getLoginPw2())  )
			return true;
		else
			return false;
	}
	
}
