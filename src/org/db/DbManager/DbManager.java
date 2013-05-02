package org.db.DbManager;

import java.sql.*;

import javax.naming.*;
import javax.naming.Context;

import javax.sql.DataSource;

public class DbManager {

	public DbManager() {

	}

	private Connection c;

	public Connection connect() {
		try {

			// Class.forName("oracle.jdbc.OracleDriver").newInstance();
			// c =
			// DriverManager.getConnection("jdbc:oracle:thin:@partyponty.hu:23134:xe","guggli","guggliprojekttitkosjelszo");

			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/oracleDb");
			c = ds.getConnection();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return c;

	}

	public void disconnect(Connection c) {
		try {
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
