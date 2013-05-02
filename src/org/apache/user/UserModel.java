package org.apache.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;





import org.db.DbManager.DbManager;


public class UserModel{
	
	private String fullName;
	private String email;
	private String userName;
	private String errorMessage;

	
	public UserModel(String userId){
		

		userName = userId;
		
		try{
			DbManager dbman = new DbManager();
			Connection c = dbman.connect();
			PreparedStatement stmt;
			ResultSet rs;
			
			if ( c != null){
				stmt = c.prepareStatement("Select last_name,first_name,email from users where user_name = ?");
				stmt.setString(1, userName);
				rs = stmt.executeQuery();
			
				if ( rs.next() ){
				
					fullName = rs.getString(1) + " " + rs.getString(2);
					email = rs.getString(3);
				}
			
			dbman.disconnect(c);
			
			}
			
		}
		catch(Exception e){			
			setErrorMessage("Sikertelen lekérdezés");
		}
	}
	

	public String getFullName(){
		
		return fullName;
	}
	
	public String getEmail(){
		
		return email;
	}
	
	public String getUserName(){
	
		return userName;
	}
	
	public void setErrorMessage(String msg){
		errorMessage = msg;
	}
	
	public String getErrorMessage(){
		return errorMessage;
	}
	
	
	
}
