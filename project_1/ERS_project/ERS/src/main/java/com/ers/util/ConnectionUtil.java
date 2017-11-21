package com.ers.util;

import java.io.FileReader;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	private static ConnectionUtil connUtil = new ConnectionUtil();
	//private static String url = "jdbc:oracle:thin:@orcl.cimtllmilk96.us-east-2.rds.amazonaws.com:1521:ORCL";
	//private static String username = "ers";
	//private static String password = "password";

	private ConnectionUtil() {
		super();
	}

	public static ConnectionUtil getConnectionUtil() {
		return connUtil;
	}

	public static Connection getConnection() throws SQLException {
		
		Properties prop = new Properties();
		
		try {
			//prop.load(new FileReader("src/main/resources/database.properties"));
			InputStream dbProps = ConnectionUtil.class.getClassLoader().getResourceAsStream("database.properties");
            prop.load(dbProps);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//return DriverManager.getConnection(url, username, password);
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
	}
}
