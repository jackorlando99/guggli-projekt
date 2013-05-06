package org.apache.user;


import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;


public class UserAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 89432748932L;
	
	private UserModel userModel ;
	private Map<String,Object> session;


	
	@Override
	public String execute(){
		
		if ( userModel == null ){
			userModel = new UserModel( (String) session.get("userName") );
			session.put("fullName",getFullName());
			session.put("userId",getUserId());
			session.put("email",getEmail());
		}	
		return SUCCESS;
	}
	
	public int getUserId(){
		
		return userModel.getUserId();
	}
	public String getUserName(){
		return userModel.getUserName();
	}
	
	public String getFullName(){
		return userModel.getFullName();
	}
	
	public String getEmail(){
		return userModel.getEmail();
	}
	
	
	public Map<String,Object> getSession(){
		return session;
	}
	

	public void setSession(Map<String,Object> map){
		
		this.session = map;
	}

	
	
}
