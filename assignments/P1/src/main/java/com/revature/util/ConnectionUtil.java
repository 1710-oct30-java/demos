package com.revature.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionUtil {
	private static Logger log = Logger.getRootLogger();
	private static ConnectionUtil connutil = new ConnectionUtil();
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private ConnectionUtil()
	{
		
		super();
	}
	public static ConnectionUtil getConnectionUtil()
	{
		return connutil;
	}
	
	public Connection getConnection() throws SQLException, IOException
	{
		log.info("Attempt");
		Properties prop = new Properties();
		InputStream dbProps = ConnectionUtil.class.getClassLoader().getResourceAsStream("DB.properties");
		prop.load(dbProps);
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
				prop.getProperty("password"));
		
	}
	
}
