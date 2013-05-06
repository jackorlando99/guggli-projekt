package org.apache.struts.dbconn;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.docs.model.DirsList;
import org.apache.struts.docs.model.DocsList;
import org.apache.struts.docs.model.DocsModel;
import org.apache.struts.maps.action.PlacesModel;
import org.apache.struts.maps.model.CellsModel;


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
			String url = "jdbc:oracle:thin:@95.140.34.246:23134:xe";
			c = DriverManager.getConnection(url, "guggli", "guggliprojekttitkosjelszo");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		isLive = true;
		return true;
	}
	
	public String lekerdezUserName(int userID) // TESZT
	{ 
		if(isLive)
		{
			try {
				Statement stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT USER_NAME FROM USERS WHERE USER_ID_AUTO ="+userID); //primitiv pedla a kapcsoalt tesztelese maitt
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
		    String s = "INSERT INTO DOCS (DOC_ID_AUTO, CREATED_AT, UPDATED_AT, DOC_NAME, CONTENT_PATH, USER_ID, HAS_DIR_ID) VALUES ('', TO_DATE(CURRENT_DATE, 'RR-MON-DD'), TO_DATE(CURRENT_DATE, 'RR-MON-DD'), ?, ?, ?, ?)";
		    PreparedStatement ps=c.prepareStatement(s);
		    	ps.setString(1, string);
		    
		    ps.setString(2, string2);
		    ps.setInt(3, i);
		    ps.setInt(4, dirID);
		    
		//    ps.executeUpdate();
		    ps.executeQuery();
		    System.out.println(s);
		    c.commit();
			
		 // Es a trigger doc_Has_dir tablaba letrehoz egy bejegyzest amiben eleri a csoport/felhasználü a dokjat
		
		   
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
	public List<DocsList> fetch(int userID){
		try{
		//	int rootDir=getRootDir(lekerdezUserName(userID));
		//Connection con=ConnectionProvider.getConnection();
		PreparedStatement stmt=c.prepareStatement
		("select doc_id_auto, doc_name, content_path, user_id  from docs INNER JOIN doc_has_dir ON docs.doc_id_auto=doc_has_dir.doc_id WHERE doc_has_dir.dir_id ="+userID);
		
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
		
		return list; 
		
		}catch(Exception e){
		System.out.println("gaz van "+e);
		}
		return null;
		}



	

		public int getRootDir(String string) {
			PreparedStatement stmt;
			int id = 0;
			try {
				stmt = c.prepareStatement
						("select dir_id_auto from directories WHERE parent_dir='"+string+"'");
		
					
					ResultSet rset=stmt.executeQuery();
					if (rset.next())
						id = rset.getInt(1);
					else
						id = 0;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return id;
		}
	public void dirsLeker(int parentID) {
		// TODO Auto-generated method stub
		
	}

	public List<DirsList> fetchDirs(int userID) {
		try{	
			//int rootDir=getRootDir(lekerdezUserName(userID));
		
			//Connection con=ConnectionProvider.getConnection();
			PreparedStatement stmt=c.prepareStatement
			("select dir_id_auto,dir_name, parent_dir from directories WHERE parent_dir='"+userID+"'");
			
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
			
			return list;
			
			}catch(Exception e){
			System.out.println("gaz van "+e);
			}
			return null;
			}
	
	public List<PlacesModel> fetchPlaces(int id) {
		
		try {
			String selectSQL = "SELECT * FROM places WHERE map_cell_id=?";
			PreparedStatement preparedStatement = c.prepareStatement(selectSQL);
			
			preparedStatement.setInt(1,id);
			
			ResultSet rset = preparedStatement.executeQuery();
			
			PlacesModel placeslist;
			List<PlacesModel> list=new ArrayList<PlacesModel>();
			while(rset.next()){
				placeslist=new PlacesModel();
				placeslist.setId(rset.getInt(1));
				placeslist.setName(rset.getString(2));
				placeslist.setAddress(rset.getString(3));
				placeslist.setPhone(rset.getString(4));
				placeslist.setPlaceType(rset.getString(5));
				placeslist.setComment(rset.getString(6));
				placeslist.setCoordX(rset.getInt(7));
				placeslist.setCoordY(rset.getInt(8));
				placeslist.setMapCellID(rset.getInt(9));

			list.add(placeslist);
			
			}
			
			
			return list;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public void newDir(int i, String dirName, int dirParent, int j) {
		try {
		// doc id auto csak proba: 
	    String s = "insert into directories values ('',?,?,'')";
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

	public String getDirName(int pid) {
		try {
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT dir_name FROM directories WHERE dir_id_auto='"+pid+"'"); //primitiv pedla a kapcsoalt tesztelese maitt
			if (rs.next())
				return rs.getString(1);
			else
				return "";
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return " ";
		
	}

	// Dir illetve Dok torlese
	public void delDir(int delID) {
		try {
			Statement stmt = c.createStatement();
		
			ResultSet rs = stmt.executeQuery("DELETE FROM directories WHERE dir_id_auto='"+delID+"'"); //primitiv pedla a kapcsoalt tesztelese maitt
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void delDoc(int delID) {
		try {
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("DELETE FROM doc_has_dir  WHERE doc_id ="+delID); //primitiv pedla a kapcsoalt tesztelese maitt

			ResultSet rs2 = stmt.executeQuery("DELETE FROM docs WHERE doc_id_auto="+delID);
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public DocsModel getDoc(int docID) {
		try{	

			Statement stmt = c.createStatement();
			
			ResultSet rset=stmt.executeQuery("select DOC_ID_AUTO, CREATED_AT, UPDATED_AT, DOC_NAME, CONTENT_PATH, USER_ID, DISPLAY_IN_CALENDAR, HAS_DIR_ID from docs WHERE doc_id_auto="+docID);
			DocsModel doc = null;
			if (rset.next()){
				doc=new DocsModel();
				doc.setId(rset.getInt(1));
				doc.setCreated(rset.getDate(2));
				doc.setUpdate(rset.getDate(3));
				doc.setNev(rset.getString(4));
				doc.setPath(rset.getString(5));
				doc.setUserID(rset.getInt(6));
				doc.setCalendar(rset.getString(7));
				doc.setHas_doc_id(rset.getInt(8));
			}
			
			return doc;
			
			}catch(Exception e){
			System.out.println("gaz van "+e);
			}
			return null;
			}

	public List<DirsList> fetchShareDirs(int userID) {
		try{
		//int rootDir=getRootDir(lekerdezUserName(userID));
		
		//Connection con=ConnectionProvider.getConnection();
		PreparedStatement stmt=c.prepareStatement
		("select dir_id_auto,dir_name, shared_ from directories WHERE shared_= 'Y'");
		
		ResultSet rset=stmt.executeQuery();
		DirsList dirslist;
		List<DirsList> list=new ArrayList<DirsList>();
		while(rset.next()){
			dirslist=new DirsList();
			dirslist.setId(rset.getInt(1));
			dirslist.setName(rset.getString(2));
			dirslist.setShared(rset.getString(3));
		list.add(dirslist);
		}
		
		return list;
		
		}catch(Exception e){
		System.out.println("gaz van "+e);
		}
		return null;
		}

	//docot updateli szerkeszteskor, update ido valtozik es igeny szerint a doc neve
	public void docUpdate(int docID, String docName) {
	try {
			
			// doc id auto csak proba: 
		    String s = "UPDATE DOCS SET UPDATED_AT=SYSDATE, DOC_NAME=? WHERE=?)";
		    PreparedStatement ps=c.prepareStatement(s);

		    ps.setString(1, docName);
	    	ps.setInt(2, docID);
		    		    
		//    ps.executeUpdate();
		    ps.executeQuery();
		    
		    c.commit();
		
		   
		    c.commit();
		    
		        ps.close();
		    } catch (SQLException e) {
				e.printStackTrace();

			    System.out.println("gazvan"+e);
			}
	}

	public String getMapCell(int map, int x, int y) {

		try {
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT cell_img_path FROM map_has_cells INNER JOIN cells ON cells.cell_id_auto=map_has_cells.cell_id WHERE cells.code='"+x+"_"+y+"'"+" AND map_has_cells.map_id="+map);

			if (rs.next()){
				String asd =  rs.getString(1);
				stmt.close();
				return asd;
			}
			else
				return "";
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return " ";
	}

	public CellsModel[] getMapArr(int map, int x, int y) {
		
		CellsModel[] array = new CellsModel[4];
		int t = 0;
		int n = 0;
		try {
			String selectSQL = "SELECT cell_id, cell_img_path FROM map_has_cells INNER JOIN cells ON cells.cell_id_auto=map_has_cells.cell_id WHERE cells.code=? OR cells.code=? OR cells.code=? OR cells.code=? AND map_has_cells.map_id=1";
			PreparedStatement preparedStatement = c.prepareStatement(selectSQL);
			System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS: "+ n);
			for(int i=1; i<=4; i++){
			preparedStatement.setString(i,String.valueOf(x+n)+"_"+String.valueOf(y));
			n++;

			System.out.println("SSSSSSSSSSSS: "+ n);
			}
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()){
				array[t]= new CellsModel(rs.getInt("cell_id"),rs.getString("cell_img_path"));
				System.out.println("asdddddddddd "+ array[t].getPath());
				t++;
			}
		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return array;
	}

	public CellsModel getCella(int id) {

		CellsModel cella = null;
		try {
			String selectSQL = "SELECT cell_img_path FROM map_has_cells WHERE cell_id=?";
			PreparedStatement preparedStatement = c.prepareStatement(selectSQL);
			preparedStatement.setInt(1,id);

			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()){
				cella = new CellsModel(id,rs.getString("cell_img_path"));
			}
		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return cella;
	}

	public void newPlace(String newName, String newAddress, String newPhone,
			String newPlaceType, String newComment, int newCoordX,
			int newCoordY, int mapCellID) {
		try {
			// doc id auto csak proba: 
			String s = "INSERT INTO PLACES (NAME_, ADDRESS, PHONE, PLACE_TYPE, COMMENT_, COORD_X, COORD_Y, MAP_CELL_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = c.prepareStatement(s);
		
			ps.setString(1, newName);
			ps.setString(2, newAddress);
			ps.setString(3, newPhone);
			ps.setString(4, newPlaceType);
			ps.setString(5, newComment);
			ps.setInt(6, newCoordX);
			ps.setInt(7, newCoordY);
			ps.setInt(8, mapCellID);
		    
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
