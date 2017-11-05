package assignments.week01.project.migration;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateUsersTable extends AbstractMigration
{
	/**
	 * @see AbstractMigration
	 */
	public void run()
	{
		String sql = "CREATE TABLE IF NOT EXISTS users ( id INTEGER, identity VARCHAR(50), password TEXT, ssn CHAR(9),  type CHAR(1), PRIMARY KEY(id) )";
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
