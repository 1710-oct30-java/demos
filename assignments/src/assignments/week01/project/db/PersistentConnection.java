package assignments.week01.project.db;

import java.sql.Connection;
import java.sql.SQLException;

import assignments.week01.project.log.SysLog;

/**
 * << singleton >>
 * 
 * represents a persistent database connection
 * per the settings in the applications default database
 * properties file
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class PersistentConnection 
{
	private static PersistentConnection instance = new PersistentConnection();
	private static SysLog log = SysLog.getInstance();
	
	private Connection connection;
	
	/**
	 * get singleton instance
	 * 
	 * @return PersistentConnection
	 */
	public static PersistentConnection getInstance()
	{
		return instance;
	}
	
	private PersistentConnection()
	{
		super();
		
		this.connection = DbConnection.connect("cb.db.properties");
	}
	
	/**
	 * return the connection instance in a thread safe manner
	 * 
	 * @return Connection
	 */
	public synchronized Connection getConnection()
	{
		return this.connection;
	}
	
	/**
	 * close the database connection on garbage collection
	 */
	public void finalize()
	{
		try {
			this.connection.close();
		} catch(SQLException e) {
			log.error( e.getMessage() );
		}
	}
	
}
