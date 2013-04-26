package org.apache.struts.dbconn;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.docs.model.DirsList;
import org.apache.struts.docs.model.DocsList;


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

	public void docUp(int i, String string, String string2,int dirID) { // doc feltoltes DB
		try {
			
			// doc id auto csak proba: 
		    String s = "INSERT INTO DOCS (DOC_ID_AUTO, CREATED_AT, UPDATED_AT, DOC_NAME, CONTENT_PATH, USER_ID) VALUES ('7', TO_DATE(CURRENT_DATE, 'RR-MON-DD'), TO_DATE(CURRENT_DATE, 'RR-MON-DD'), ?, ?, ?)";
		    PreparedStatement ps=c.prepareStatement(s);
		    	ps.setString(1, string);
		    
		    ps.setString(2, string2);
		    ps.setInt(3, i);
		    
		//    ps.executeUpdate();
		    ps.executeQuery();
		    System.out.println(s);
		    c.commit();
			
		  //  docID=
		 
		    String s2 = "INSERT INTO doc_has_dir VALUES('1', '1', '7');";
		    PreparedStatement ps2=c.prepareStatement(s2);
		 
		    
		//    ps.executeUpdate();
		    ps2.executeQuery();
			   
		    System.out.println(s2);
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
	public List<DocsList> fetch(int dirID){
		try{
		//Connection con=ConnectionProvider.getConnection();
		PreparedStatement stmt=c.prepareStatement
		("select doc_id_auto, doc_name, content_path, user_id  from docs INNER JOIN doc_has_dir ON docs.doc_id_auto=doc_has_dir.doc_id WHERE doc_has_dir.dir_id = 1");
		
		ResultSet rset=stmt.executeQuery();
		DocsList docslist;
		List<DocsList> list=new ArrayList<DocsList>();
		while(rset.next()){
			docslist=new DocsList();
			docslist.setId(rset.getInt(1));
			docslist.setName(rset.getString(2));
			docslist.setPath(rset.getString(3));
			docslist.setUser_id(rset.getInt(4));
		list.add(docslist);
		}
		System.out.println("ok" + list);

		return list; 
		
		}catch(Exception e){
		System.out.println("gaz van "+e);
		}
		return null;
		}

	public void dirsLeker(int parentID) {
		// TODO Auto-generated method stub
		
	}

	public List<DirsList> fetchDirs(int userID) {
		try{
			//Connection con=ConnectionProvider.getConnection();
			PreparedStatement stmt=c.prepareStatement
			("select dir_id_auto,dir_name, parent_dir from directories WHERE parent_dir=1 AND dir_name!='root' ");
			
			ResultSet rset=stmt.executeQuery();
			DirsList dirslist;
			List<DirsList> list=new ArrayList<DirsList>();
			while(rset.next()){
				dirslist=new DirsList();
				dirslist.setId(rset.getInt(1));
				dirslist.setName(rset.getString(2));
				dirslist.setParentDirID(rset.getInt(3));
			list.add(dirslist);
			}
			System.out.println("ok" + list);

			return list; 
			
			}catch(Exception e){
			System.out.println("gaz van "+e);
			}
			return null;
			}

	public void newDir(int i, String dirName, int dirParent, int j) {
		try {
		// doc id auto csak proba: 
	    String s = "insert into directories values ('4',?,?,'')";
	    PreparedStatement ps=c.prepareStatement(s);
	    	ps.setString(1, dirName);
	    
	    ps.setInt(2, dirParent);
	    

	    System.out.println(s);
	    c.commit();

	    ps.executeQuery();
		   
	   
	    c.commit();
	    
	        ps.close();
		
		  } catch (SQLException e) {
				e.printStackTrace();

			    System.out.println("gazvan"+e);
			}
	}
	

}
