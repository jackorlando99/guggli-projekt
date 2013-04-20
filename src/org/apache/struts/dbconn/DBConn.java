package org.apache.struts.dbconn;
import java.sql.*;

public class DBConn {
	Connection c;
	boolean isLive = false;
	
	public DBConn()
	{

	}
	
	public boolean connect()
	{
		try
		{
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
	
	public String lekerdezUserName()
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
}
