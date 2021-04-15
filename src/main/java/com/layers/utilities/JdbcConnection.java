package com.layers.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	String url = "jdbc:mysql://localhost:3306/VirtualClassRoom";
	String user = "root";
	String password = "sudhansu204me@";

	private static JdbcConnection con = null;

	private JdbcConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Class Not Found");
		}
	}

	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

	public static JdbcConnection getInstance() {
		if (con == null)
			con = new JdbcConnection();
		return con;
	}

}
