package com.internousdev.ecsite.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1/ecsite";

	private static String user = "root";
	private static String password = "";

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}


}