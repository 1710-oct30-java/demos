package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
		return DriverManager.getConnection("jdbc:oracle:thin:@orcl.czxgfqnyl4hq.us-east-2.rds.amazonaws.com:1521:ORCL", "expense", "p4ssw0rd");
	}
}
