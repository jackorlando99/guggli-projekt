package org.apache.struts.register;

import com.opensymphony.xwork2.ActionSupport;


public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 123456789L;
	private RegisterModel userReg;
	
	@Override
	public String execute() throws Exception{
		if ( userReg.setToDb() )
			return SUCCESS;
		else
			return ERROR;
	}
	
	public void setUserReg(RegisterModel reg){
		userReg = reg;
	}
	
	public RegisterModel getUserReg(){
		return userReg;
	}
	
	
}

	