package org.apache.struts.dbconn;
import java.sql.*;


public class DBConn {
	boolean isLive = false;
	private Connection con;
	Connection c;
	public DBConn()
	{

	}
	
	public boolean connect()
	{
		try
		{
			
			// Class.forName("oracle.jdbc.driver.OracleDriver");
		    // java.sql.Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hori","hori1294");
			
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			c = DriverManager.getConnection(url, "hori", "hori1294");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		isLive = true;
		return true;
	}
	
	public String lekerdezUserName() // TESZT
	{ 
		if(isLive)
		{
			try {
				Statement stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT USER_NAME FROM USERS WHERE USER_ID_AUTO = 1"); //primitiv pedla a kapcsoalt tesztelese maitt
				if (rs.next())
					return rs.getString(1);
				else
					return "";
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		return " ";
	}
	
	public boolean disconnect()
	{
		if (isLive=true)
		try 
		{
				c.close();
		} 
		catch (SQLException e) 
		{
				e.printStackTrace();
		}
		isLive = false;
		return true;
	}

	public void docUp(int i, String string, String string2) { // doc feltoltes DB
		try {
			
			// doc id auto csak proba: 
		    String s = "INSERT INTO DOCS (DOC_ID_AUTO, CREATED_AT, UPDATED_AT, DOC_NAME, CONTENT_PATH, USER_ID) VALUES ('6', TO_DATE(CURRENT_DATE, 'RR-MON-DD'), TO_DATE(CURRENT_DATE, 'RR-MON-DD'), ?, ?, ?)";
		    PreparedStatement ps=c.prepareStatement(s);
		    	ps.setString(1, string2);
		    
		    ps.setString(2, string);
		    ps.setInt(3, i);
		    
		//    ps.executeUpdate();
		    ps.executeQuery();
		    System.out.println(s);
		    c.commit();
		 
		        ps.close();
		    } catch (SQLException e) {
				e.printStackTrace();

			    System.out.println("gazvan"+e);
			}
	}
/*	public String docGetLoc() {
		return null; // doc hely lekeres DB

	}*/
}
