package com.revature.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;


public class DAOUtilities {
	
//	private static String Username = "ers";
//	private static String Password = "pass";
//	private static String URL = "orcl.ccpzelfz4uew.us-east-2.rds.amazonaws.com:1521:ORCL";	
//	private static Connection conn;
//
//	public static Connection getConnection() throws SQLException {
//
//		if (conn == null) {
//			try {
//				Class.forName("oracle.jdbc.OracleDriver");
//			} catch (ClassNotFoundException e) {
//				System.out.println("Driver unable to register");
//				e.printStackTrace();
//			}
//			conn = DriverManager.getConnection(URL, Username, Password);
//		}
//		
//		if (conn.isClosed()) {
//			System.out.println("Connection closed. Opening a new one...");
//			conn = DriverManager.getConnection(URL, Username, Password);
//		}
//		return conn;
//	}
//	
	private static final String CONNECTION_USERNAME = "postgres";
	private static final String CONNECTION_PASSWORD = "password";
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static Connection connection;
	
	public static synchronized Connection getConnection() throws SQLException {
		if (connection == null) {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Could not register driver");
				e.printStackTrace();
			}
			connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		}
		
		//If connection was closed then retrieve a new connection
		if (connection.isClosed()){
			System.out.println("Opening new connection...");
			connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		}
		return connection;
	}
	public static UserDAO getUserDAO() {
		return new UserDAOImpl();
	}
}
