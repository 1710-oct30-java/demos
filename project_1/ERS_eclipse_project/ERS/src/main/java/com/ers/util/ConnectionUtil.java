package com.ers.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	private static ConnectionUtil connUtil = new ConnectionUtil();

	private ConnectionUtil() {
		super();
	}

	public static ConnectionUtil getConnectionUtil() {
		return connUtil;
	}

	public static Connection getConnection() throws SQLException {
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader("src/main/resources/database.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
	}
}
