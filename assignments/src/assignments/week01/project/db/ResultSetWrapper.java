package assignments.week01.project.db;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import assignments.week01.project.log.SysLog;

/**
 * a utility class that transforms ResutlSet
 * objects into other data structures
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class ResultSetWrapper 
{
	private static SysLog log = SysLog.getInstance();

	/**
	 * transform a result set to a Map<String, String>
	 * to be consumed by an entity factory
	 * 
	 * @param ResultSet data
	 * 
	 * @return Map<String, String>
	 */
	public static Map<String, String> toMap(ResultSet data)
	{
		Map<String, String> output = new HashMap<>();
		
		try {
			ResultSetMetaData md = data.getMetaData();
			int columnCount = md.getColumnCount();

			for( int i = 1; i <= columnCount; i++ ) {
				String columnName = md.getColumnLabel(i);
				String columnData = data.getString(columnName);
				
				output.put(columnName, columnData);
			}
			
		} catch (SQLException e) {
			log.error( e.getMessage() );
		}
		
		return output;
	}
}
