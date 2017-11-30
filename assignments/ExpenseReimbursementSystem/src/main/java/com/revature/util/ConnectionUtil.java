package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

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

	public Connection getConnection() throws SQLException {

		Properties prop = new Properties();
		try {
			prop.load(new FileReader(
					"C:\\Users\\iaust\\eclipse-workspace\\ExpenseReimbursementSystem\\src\\main\\resources\\database.properties"));
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
