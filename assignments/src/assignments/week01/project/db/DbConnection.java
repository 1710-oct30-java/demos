package assignments.week01.project.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import assignments.week01.project.io.PropertiesFile;
import assignments.week01.project.log.SysLog;

/**
 * a utility class for retrieving a JDBC database connection using the
 * JDBC properties in the properties file passed
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class DbConnection {
	private static SysLog log = SysLog.getInstance();

	/**
	 * create a Connection resource using the properties
	 * located in the file at the path passed
	 * 
	 * @param String dbPropertiesFilePath
	 * 
	 * @return Connection
	 */
	public static Connection connect(String dbPropertiesFilePath)
	{
		Properties properties = PropertiesFile.read( dbPropertiesFilePath);
		Connection conn = null;
		String url = "";
		
		try {
			switch( properties.getProperty("driver").toLowerCase() ) {
				case "sqlite" :
					Class.forName("org.sqlite.JDBC");
					String path = properties.getProperty("path", "app.db");					
					
					url = String.format("jdbc:sqlite:%s", path);
					break;
			}
			
			conn = DriverManager.getConnection(url, properties);			
		} catch(ClassNotFoundException e) {
			log.error( e.getMessage() );
		} catch(SQLException e) {
			log.error( e.getMessage() );
		}
		
		return conn;
	}
	
}
