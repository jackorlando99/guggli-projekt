package org.apache.struts.login.action;

import org.apache.commons.codec.binary.Base64;
import org.apache.struts.login.model.LoginModel;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.security.MessageDigest;
import java.util.Map;



public class LoginAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 123456789L;
	private LoginModel loginInfo;
	private Map<String, Object> session;
	
	public  LoginAction(){
		
		//session = new HashMap<String, Object>();
	}
	
/*	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
*/	
	
	public String loginRegisteredUser(){
		try{
		
		if ( loginInfo.getPwHashFromDb( loginInfo.getLoginName() ) ){
			
			String pwhash = loginInfo.getPwHash();
			
			
			byte[] inputPwMd5 = this.md5Encode(loginInfo.getLoginPw());
			String inputPwHash = this.base64Encode(inputPwMd5);
			
			if ( inputPwHash.equals(pwhash) ){
				
				session.put("userName", loginInfo.getLoginName());
				session.put("logined","true");
				return "success";
			}	
			else {
				
				return "login";
				
			}	
			
			
		}
			
		
		
		else{
			addActionError("A felhasználónév vagy jelszó helytelen");
			return "login";
		}
			
		}
		catch(Exception e){
			
			return "login";
		}
	}
	
	public String base64Encode(byte[] pwmd5) {

		return Base64.encodeBase64String(pwmd5);
	}
	
	public byte[] md5Encode(String pw) {

		try {

			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] pwByte = pw.getBytes("UTF-8");
			byte[] md5_byte = md5.digest(pwByte);
			return md5_byte;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String logined(){
		
		return "success";
	}
	
	public String logOut(){
		
		session.remove("userName");
		session.remove("userId");
		session.remove("email");
		session.remove("logined");
		session.remove("fullName");
		addActionMessage("Sikeresen kijelentkeztél");
		return "login";
	}
	
	public Map<String,Object> getSession(){
		
		return session;
	}
	
	public void setSession( Map<String,Object> map ){
		
		this.session = map;
	}
	
	public LoginModel getLoginInfo(){
		
		return loginInfo;
	}
	
	public void setLoginInfo(LoginModel login){
		
		loginInfo = login;
	}
	
	
	
	
	
}
