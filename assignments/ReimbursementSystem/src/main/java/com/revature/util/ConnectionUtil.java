package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	private static ConnectionUtil conUtil = new ConnectionUtil();
	
	static {
		try {
			System.out.println("done");
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
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
			//not dependant in computer now
			InputStream dbProps = ConnectionUtil.class.getClassLoader().getResourceAsStream("database.properties");
			prop.load(dbProps);
			
			System.out.println("loading db");
			//prop.load(new FileReader("src/main/resources/database.properties"));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
	}
}

