package com.revature.util;

import java.io.FileNotFoundException;
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
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private ConnectionUtil() {
		super();
	}

	public static ConnectionUtil getConnectionUtil() {
		return conUtil;
	}

	public Connection getConnection() throws SQLException {
		Properties prop = new Properties();
		try {
			InputStream dbProps = ConnectionUtil.class.getClassLoader().getResourceAsStream("database.properties");
			prop.load(dbProps);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
				prop.getProperty("password"));
	}

}
