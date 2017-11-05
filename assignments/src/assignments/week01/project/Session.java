package assignments.week01.project;

import java.util.HashMap;
import java.util.Map;

import assignments.week01.project.log.SysLog;

/**
 * represents the current user session
 * in memory
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class Session 
{
	private static Session instance = new Session();

	private Map<String, Object> data;	// hashed data of the session
	private SysLog log;
	
	/**
	 * using a singleton pattern for the session
	 * 
	 * @return Session
	 */
	public static Session getInstance()
	{
		return instance;
	}
	

	
	private Session()
	{
		this.data = new HashMap<>();
		this.log = SysLog.getInstance();
	}
	
	/**
	 * stores an object in the session
	 * 
	 * @param String index
	 * @param Object object
	 * 
	 * @return self
	 */
	public Session store(String index, Object object)
	{
		String logMessage = String.format("storing object [%s] in session", index);
		log.trace(logMessage);
		
		this.data.put( index.toLowerCase(), object );
		
		return this;
	}
	
	/**
	 * retrieves an object stored in the session
	 * 
	 * @param String index
	 * 
	 * @return Object
	 */
	public Object retrieve(String index)
	{
		String logMessage = String.format("retrieving object [%s] from session", index);
		log.trace(logMessage);
		
		return this.data.get( index.toLowerCase() );
	}
	
	/**
	 * remove an item from the session by index
	 * 
	 * @param String index
	 */
	public void remove(String index)
	{
		String logMessage = String.format("removing object [%s] from session", index);
		log.trace(logMessage);
		
		this.data.remove( index );
	}
}
