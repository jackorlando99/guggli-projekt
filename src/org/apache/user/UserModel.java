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
	private int userId;

	
	public UserModel(String username){
		

		userName = username;
		
		try{
			DbManager dbman = new DbManager();
			Connection c = dbman.connect();
			PreparedStatement stmt;
			ResultSet rs;
			
			if ( c != null){
				stmt = c.prepareStatement("Select last_name,first_name,email,user_id_auto from users where user_name = ?");
				stmt.setString(1, username);
				rs = stmt.executeQuery();
			
				if ( rs.next() ){
				
					fullName = rs.getString(1) + " " + rs.getString(2);
					email = rs.getString(3);
					userId = rs.getInt(4);
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
	
	public int getUserId(){
		return userId;
	}
	
	public void setErrorMessage(String msg){
		errorMessage = msg;
	}
	
	public String getErrorMessage(){
		return errorMessage;
	}
	
	
	
}
