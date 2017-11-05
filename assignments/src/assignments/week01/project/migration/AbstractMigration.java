package assignments.week01.project.migration;

import java.sql.Connection;

import assignments.week01.project.db.PersistentConnection;
import assignments.week01.project.log.SysLog;

abstract public class AbstractMigration implements MigrationInterface 
{
	protected static SysLog log = SysLog.getInstance();
	protected Connection connection;

	public AbstractMigration()
	{
		this.connection = PersistentConnection.getInstance().getConnection();
	}
	
	/**
	 * @see MigrationInterface
	 * 
	 * @param Connection conn
	 */
	abstract public void run();

}
