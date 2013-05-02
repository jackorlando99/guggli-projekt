package org.apache.struts.maps.action;

import org.apache.struts.dbconn.DBConn;
import org.apache.struts.docs.model.DocsModel;

import com.opensymphony.xwork2.ActionSupport;

public class MapsAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2462304299725850213L;

	private String mapcel1_1,mapcel2_1,mapcel3_1,mapcel4_1;
	private String mapcel1_2,mapcel2_2,mapcel3_2,mapcel4_2;
	private String mapcel1_3,mapcel2_3,mapcel3_3,mapcel4_3;
	private String mapcel1_4,mapcel2_4,mapcel3_4,mapcel4_4;
	
	public String execute() {
		try{		
		setMapcel1_1("maps/szeged/1_1.jpg");
		setMapcel2_1("maps/szeged/1_1.jpg");
		setMapcel3_1("maps/szeged/1_1.jpg");
		setMapcel4_1("maps/szeged/1_1.jpg");
		setMapcel1_2("maps/szeged/1_1.jpg");
		setMapcel2_2("maps/szeged/1_1.jpg");
		setMapcel3_2("maps/szeged/1_1.jpg");
		setMapcel4_2("maps/szeged/1_1.jpg");
		setMapcel1_3("maps/szeged/1_1.jpg");
		setMapcel2_3("maps/szeged/1_1.jpg");
		setMapcel3_3("maps/szeged/1_1.jpg");
		setMapcel4_3("maps/szeged/1_1.jpg");
		setMapcel1_4("maps/szeged/1_1.jpg");
		setMapcel2_4("maps/szeged/1_1.jpg");
		setMapcel3_4("maps/szeged/1_1.jpg");
		setMapcel4_4("maps/szeged/1_1.jpg");
		}catch(Exception e){

		}
		return SUCCESS;
	
	}
	
	public String getMapcel1_1() {
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
	
	
	
}
