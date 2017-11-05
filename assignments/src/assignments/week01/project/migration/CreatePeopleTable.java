package assignments.week01.project.migration;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreatePeopleTable extends AbstractMigration
{
	/**
	 * @see AbstractMigration
	 */
	public void run()
	{
		String sql = "CREATE TABLE IF NOT EXISTS people ( ssn CHAR(9), lastName VARCHAR(50), firstName VARCHAR(50), middleName VARCHAR(50), email VARCHAR(100),  PRIMARY KEY(ssn ASC) )";
		PreparedStatement stmt = null;
		
		try {
			stmt = this.connection.prepareStatement( sql );			
			stmt.execute();			
			stmt.close();
		} catch(SQLException e) {
			log.error( e.getMessage() );
		} 
	}
}
