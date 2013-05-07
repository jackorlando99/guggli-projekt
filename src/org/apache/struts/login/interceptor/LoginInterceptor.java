package org.apache.struts.login.interceptor;

import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.ActionInvocation;

import java.util.Map;

public class LoginInterceptor implements Interceptor {

	private static final long serialVersionUID = 789644568978979L;
	
	@Override
	public void init(){
		
	}
	
	@Override
	public void destroy(){
		
	}
	
	@Override
	public String intercept (ActionInvocation invocation) throws Exception{
		Map<String,Object> sessionAttributes = invocation.getInvocationContext().getSession();
		
		if ( sessionAttributes == null || sessionAttributes.get("userName") == null ){
			
			return "login";
		}
		else {
			if ( ! ((String) sessionAttributes.get("userName")).equals(null) ){
				return invocation.invoke();
			}
			else
				return "login";
		}
		
	}
	
}
