package org.apache.struts.maps.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.dbconn.DBConn;
import org.apache.struts.docs.model.DocsModel;
import org.apache.struts.maps.model.CellsModel;

import com.opensymphony.xwork2.ActionSupport;

public class MapsAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2462304299725850213L;

	private int mapID;
	private int x;
	private int y;
	private CellsModel[] MapArr1;
/*		{ "maps/szeged/1_1.jpg", "maps/szeged/2_1.jpg",
			"maps/szeged/3_1.jpg", "maps/szeged/4_1.jpg" };*/
	private CellsModel[] MapArr2;
	private CellsModel[] MapArr3;
	private CellsModel[] MapArr4;
	private DBConn dbc;
	
	public String execute() {

		
		if(x<=0){
			setX(1);
		}else if(x>=9){
			setX(9);
		}
		
		if(y<=0){
			setY(1);
		}else if(y>=5){
			setY(5);
		}		
			MapArr1 = new CellsModel[4];
			MapArr2 = new CellsModel[4];
			MapArr3 = new CellsModel[4];
			MapArr4 = new CellsModel[4];
			
			dbc = new DBConn();
			dbc.connect(); 
			setMapArr1(dbc.getMapArr(1,getX(),getY()));
			setMapArr2(dbc.getMapArr(1,getX(),getY()+1));
 
			setMapArr3(dbc.getMapArr(1,getX(),getY()+2));

			setMapArr4(dbc.getMapArr(1,getX(),getY()+3));
			
			

		return SUCCESS;
	
	}
	
/*	public String getMapcel1_1() {
		return mapcel1_1;
	}
	public void setMapcel1_1(String mapcel1_1) {
		this.mapcel1_1 = mapcel1_1;
	}
	public String getMapcel2_1() {
		return mapcel2_1;
	}
	public void setMapcel2_1(String mapcel2_1) {
		this.mapcel2_1 = mapcel2_1;
	}
	public String getMapcel3_1() {
		return mapcel3_1;
	}
	public void setMapcel3_1(String mapcel3_1) {
		this.mapcel3_1 = mapcel3_1;
	}
	public String getMapcel4_1() {
		return mapcel4_1;
	}
	public void setMapcel4_1(String mapcel4_1) {
		this.mapcel4_1 = mapcel4_1;
	}
	public String getMapcel1_2() {
		return mapcel1_2;
	}
	public void setMapcel1_2(String mapcel1_2) {
		this.mapcel1_2 = mapcel1_2;
	}
	public String getMapcel2_2() {
		return mapcel2_2;
	}
	public void setMapcel2_2(String mapcel2_2) {
		this.mapcel2_2 = mapcel2_2;
	}
	public String getMapcel3_2() {
		return mapcel3_2;
	}
	public void setMapcel3_2(String mapcel3_2) {
		this.mapcel3_2 = mapcel3_2;
	}
	public String getMapcel4_2() {
		return mapcel4_2;
	}
	public void setMapcel4_2(String mapcel4_2) {
		this.mapcel4_2 = mapcel4_2;
	}
	public String getMapcel1_3() {
		return mapcel1_3;
	}
	public void setMapcel1_3(String mapcel1_3) {
		this.mapcel1_3 = mapcel1_3;
	}
	public String getMapcel2_3() {
		return mapcel2_3;
	}
	public void setMapcel2_3(String mapcel2_3) {
		this.mapcel2_3 = mapcel2_3;
	}
	public String getMapcel3_3() {
		return mapcel3_3;
	}
	public void setMapcel3_3(String mapcel3_3) {
		this.mapcel3_3 = mapcel3_3;
	}
	public String getMapcel4_3() {
		return mapcel4_3;
	}
	public void setMapcel4_3(String mapcel4_3) {
		this.mapcel4_3 = mapcel4_3;
	}
	public String getMapcel1_4() {
		return mapcel1_4;
	}
	public void setMapcel1_4(String mapcel1_4) {
		this.mapcel1_4 = mapcel1_4;
	}
	public String getMapcel2_4() {
		return mapcel2_4;
	}
	public void setMapcel2_4(String mapcel2_4) {
		this.mapcel2_4 = mapcel2_4;
	}
	public String getMapcel3_4() {
		return mapcel3_4;
	}
	public void setMapcel3_4(String mapcel3_4) {
		this.mapcel3_4 = mapcel3_4;
	}
	public String getMapcel4_4() {
		return mapcel4_4;
	}
	public void setMapcel4_4(String mapcel4_4) {
		this.mapcel4_4 = mapcel4_4;
	}
*/
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getMapID() {
		return mapID;
	}

	public void setMapID(int mapID) {
		this.mapID = mapID;
	}

	public CellsModel[] getMapArr1() {
		return MapArr1;
	}

	public void setMapArr1(CellsModel[] cellsModels) {
		MapArr1 = cellsModels;
	}

	public CellsModel[] getMapArr2() {
		return MapArr2;
	}

	public void setMapArr2(CellsModel[] cellsModels) {
		MapArr2 = cellsModels;
	}

	public CellsModel[] getMapArr4() {
		return MapArr4;
	}

	public void setMapArr4(CellsModel[] mapArr4) {
		MapArr4 = mapArr4;
	}

	public CellsModel[] getMapArr3() {
		return MapArr3;
	}

	public void setMapArr3(CellsModel[] cellsModels) {
		MapArr3 = cellsModels;
	}



	
	
	
}
