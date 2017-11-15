package com.revature.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	private static ConnectionUtil conUtil= new ConnectionUtil();
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private ConnectionUtil() {
		super();
	}
	
	public static ConnectionUtil getConnectionUtil() {
		return conUtil;
	}
	
	public Connection getConnection() throws SQLException{
		
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("src/main/resources/database.properties"));
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
	}
}
