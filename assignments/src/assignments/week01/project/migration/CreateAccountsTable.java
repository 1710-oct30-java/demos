package assignments.week01.project.migration;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateAccountsTable extends AbstractMigration
{
	/**
	 * @see AbstractMigration
	 */
	public void run()
	{
		String sql = "CREATE TABLE IF NOT EXISTS accounts ( id INTEGER, name VARCHAR(50), type CHAR(1), status CHAR(1), ssn CHAR(9),  PRIMARY KEY(id) )";
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
