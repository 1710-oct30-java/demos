package assignments.week01.project.db.adapter;

import java.util.List;

public interface TableAdapterInterface<T>
{
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
	public T get(String key);
	
	/**
	 * retrieve all entities in the table
	 * 
	 * @return List<T>
	 */
	public List<T> getAll();
	
	/**
	 * write an entity to the table
	 * return true if successful
	 * 
	 * @param T entity
	 * 
	 * @return boolean
	 */
	public boolean put(T entity);
	
	/**
	 * remove an entity from the table
	 * return true if successful
	 * 
	 * @param T entity
	 * 
	 * @return boolean
	 */
	public boolean delete(T entity);
	
	/**
	 * update and existing entity in the table
	 * return true if successful
	 * 
	 * @param T entity
	 * 
	 * @return boolean
	 */
	public boolean update(T entity);
}
