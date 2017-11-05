package assignments.week01.project.db.adapter;

import java.sql.Connection;
import java.util.List;

import assignments.week01.project.db.PersistentConnection;
import assignments.week01.project.log.SysLog;

/**
 * template for table adapters
 * 
 * @author john.w.brown.jr@gmail.com
 *
 * @param <T>
 */
abstract public class AbstractTableAdapter<T> implements TableAdapterInterface<T>
{
	protected static SysLog log = SysLog.getInstance();
	
	protected Connection connection;
	
	public AbstractTableAdapter()
	{
		this.connection = PersistentConnection.getInstance().getConnection();
	}
	
	/**
	 * retrieve one entity from the database
	 * with key hashed as a single string
	 * 
	 * compound keys should have fields delimited
	 * by a ":"
	 * 
	 * @param String key
	 * 
	 * @return T
	 */
	abstract public T get(String key);
	
	/**
	 * retrieve all entities in the table
	 * 
	 * @return List<T>
	 */
	abstract public List<T> getAll();
	
	/**
	 * write an entity to the table
	 * return true if successful
	 * 
	 * @param T entity
	 * 
	 * @return boolean
	 */
	abstract public boolean put(T entity);
	
	/**
	 * remove an entity from the table
	 * return true if successful
	 * 
	 * @param T entity
	 * 
	 * @return boolean
	 */
	abstract public boolean delete(T entity);
	
	/**
	 * update and existing entity in the table
	 * return true if successful
	 * 
	 * @param T entity
	 * 
	 * @return boolean
	 */
	abstract public boolean update(T entity);
}
