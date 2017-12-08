package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil
{

	private static ConnectionUtil conUtil = new ConnectionUtil();
	static
	{
		try
		{
			System.out.println("done");
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e)
		{
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
		return conUtil;
	}

	public Connection getConnection() throws SQLException
	{
		Properties prop = new Properties();
		InputStream dbProps = ConnectionUtil.class.getClassLoader().getResourceAsStream("database.properties");
		try
		{
			prop.load(dbProps);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
				prop.getProperty("password"));
	}

}
