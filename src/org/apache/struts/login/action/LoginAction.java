package org.apache.struts.login.action;

import org.apache.struts.login.model.LoginModel;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 123456789L;
	private LoginModel loginInfo;
	private Map<String, Object> session;
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String loginRegisteredUser(){
		
		if ( loginInfo.getLoginName().equals("robi") && loginInfo.getLoginPw().equals("titkos") ){
			session.put("loginId",loginInfo.getLoginName() );
			return SUCCESS;
		}
		else{
			addActionError("A felhasználónév vagy jelszó helytelen");
			return LOGIN;
		}
			
		
	}
	
	public String logOut(){
		
		session.remove("loginId");
		addActionMessage("Sikeresen kijelentkeztél");
		return LOGIN;
	}
	
	public Map<String,Object> getSession(){
		
		return session;
	}
	
	public void setSession( Map<String,Object> map ){
		
		session = map;
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
