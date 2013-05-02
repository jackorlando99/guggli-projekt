package org.apache.struts.register;

import java.sql.*;
import java.security.*;
import org.apache.commons.codec.binary.Base64;
import org.db.DbManager.DbManager;

import java.util.*;


public class RegisterModel {

	private String loginFname;
	private String loginLname;
	private String loginName;
	private String loginEmail;
	private String loginPw;
	private String loginPw2;

	public RegisterModel() {
		loginFname = "";
		loginLname = "";
		loginName = "";
		loginEmail = "";
		loginPw = "";
		loginPw2 = "";
	}

	public void setLoginFname(String fname) {
		loginFname = fname;
	}

	public String getLoginFname() {
		return loginFname;
	}

	public void setLoginLname(String lname) {
		loginLname = lname;
	}

	public String getLoginLname() {
		return loginLname;
	}

	public void setLoginName(String name) {
		loginName = name;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginEmail(String email) {
		loginEmail = email;
	}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginPw(String pw) {
		loginPw = pw;
	}

	public String getLoginPw() {
		return loginPw;
	}

	public void setLoginPw2(String pw) {
		loginPw2 = pw;
	}

	public String getLoginPw2() {
		return loginPw2;
	}

	public String getActivationCode() {

		try {
			Calendar cal = Calendar.getInstance();

			long time_now = cal.getTimeInMillis();

			Random rand = new Random(time_now);

			Long activationCode = time_now + rand.nextLong();

			return new String(Base64.encodeBase64URLSafeString(activationCode
					.toString().getBytes("UTF-8")));

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String toString() {
		return "Regisztrált adatok: " + getLoginLname() + " " + getLoginFname()
				+ " " + getLoginName() + " " + getLoginEmail() + " "
				+ getLoginPw() + " " + getLoginPw2();
	}

	public String base64(byte[] b) {

		return Base64.encodeBase64String(b);
	}

	public byte[] md5(String pw) {

		try {

			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] pwByte = pw.getBytes("UTF-8");
			byte[] md5_byte = md5.digest(pwByte);
			return md5_byte;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean setToDb() {
		if (getLoginPw().equals(getLoginPw2())) {

			boolean status = false;

			try {

				DbManager dbman = new DbManager();
				Connection c = dbman.connect();
				PreparedStatement stmt;

				if (c != null) {
					status = true;
					stmt = c.prepareStatement("Insert into users values(null,?,?,?,?,?,?,?)");
					stmt.setString(1, getLoginName());
					stmt.setString(2, getLoginFname());
					stmt.setString(3, getLoginLname());
					stmt.setString(4, getLoginEmail());
					stmt.setString(5, base64(md5(getLoginPw())));
					stmt.setString(6, "N");
					stmt.setString(7, getActivationCode());
					stmt.executeUpdate();
					dbman.disconnect(c);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return status;
		}

		else {

			return false;
		}
	}

}
