package util;

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
			e.printStackTrace();
		}
	}

	private ConnectionUtil() {
		super();
	}

	public static ConnectionUtil getconnectionUtil() {
		return conUtil;
	}

	public Connection getConnection() throws SQLException {
		Properties p = new Properties();
		try {
			InputStream dbProps = ConnectionUtil.class.getClassLoader().getResourceAsStream("database.properties");
			p.load(dbProps);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
	}

}
