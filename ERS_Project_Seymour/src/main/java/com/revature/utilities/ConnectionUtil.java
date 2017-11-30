package com.revature.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;

public class ConnectionUtil {
	
//	private static final String username = "postgres";
//	private static final String password = "password";
//	private static final String url = "jdbc:postgresql://localhost:5432/postgres";
	
	public static String url="jdbc:oracle:thin:@orcl.ccpzelfz4uew.us-east-2.rds.amazonaws.com:1521:ORCL";
	public static String username="ers";
	public static String password="pass";

	private static ConnectionUtil conUtil = new ConnectionUtil();
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Class for name worked");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class for name failed");
			e.printStackTrace();
		}
	}
	private ConnectionUtil() {
		super();
	}
	
	public static ConnectionUtil getConnectionUtil() {
		return conUtil;
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	public static UserDAO getUserDAO() {
		return new UserDAOImpl();
	}

}

//Properties prop = new Properties();
//try {
//	prop.load(new FileReader("src/main/resources/database.properties"));
//} catch (FileNotFoundException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//} catch (IOException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}