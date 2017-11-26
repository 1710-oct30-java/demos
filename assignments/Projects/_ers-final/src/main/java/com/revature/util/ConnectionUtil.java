package com.revature.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	private static ConnectionUtil connUtil = new ConnectionUtil();
	
	private ConnectionUtil()
	{
		super();
		
		try
		{
			System.out.println("Hello World");
			DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException
	{
		Properties prop = new Properties();
		try
		{
			InputStream dbProps = ConnectionUtil.class.getClassLoader().getResourceAsStream("database.properties");
            prop.load(dbProps);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
	}
	
	public static ConnectionUtil getConnectionUtil()
	{
		return connUtil;
	}
}
