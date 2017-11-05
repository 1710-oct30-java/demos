package assignments.week01.project.migration;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTransactionsTable extends AbstractMigration
{
	/**
	 * @see AbstractMigration
	 */
	public void run()
	{
		String sql = "CREATE TABLE IF NOT EXISTS transactions ( id INTEGER, account_id INTEGER, description VARCHAR(50), amount VARCHAR(50), status CHAR(1), created  DATETIME,  PRIMARY KEY(id) )";
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
