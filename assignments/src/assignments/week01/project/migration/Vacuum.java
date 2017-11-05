package assignments.week01.project.migration;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * command to defragment empy space in a SQLite DB file
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class Vacuum extends AbstractMigration
{
	/**
	 * @see AbstractMigration
	 */
	public void run()
	{
		String sql = "vacuum";
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
