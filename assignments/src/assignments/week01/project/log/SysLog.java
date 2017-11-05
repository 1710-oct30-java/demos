package assignments.week01.project.log;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * << singleton >>
 * 
 * abstraction of the system log
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class SysLog 
{
	/**
	 * singleton instantiation
	 */
	private static SysLog instance = new SysLog();
	
	/**
	 * provide singleton instance to clients
	 * 
	 * @return SysLog
	 */
	public static SysLog getInstance()
	{
		return instance;
	}
	
	private Logger logger;
	
	private SysLog()
	{
		super();
		
		this.logger = Logger.getRootLogger();
	}
	
	/**
	 * proxy method to pass messages to trace log
	 * 
	 * @param String message
	 */
	public synchronized void trace(String message)
	{
		this.logger.log(this.getClass().getCanonicalName(), Level.TRACE, message, null);
	}
	
	/**
	 * proxy method to pass messages to debug log
	 * 
	 * @param String message
	 */
	public synchronized void debug(String message)
	{
		this.logger.log(this.getClass().getCanonicalName(), Level.DEBUG, message, null);
	}
	
	/**
	 * proxy method to pass messages to info log
	 * 
	 * @param String message
	 */
	public synchronized void info(String message)
	{
		this.logger.log(this.getClass().getCanonicalName(), Level.INFO, message, null);
	}
	
	/**
	 * proxy method to pass messages to warn log
	 * 
	 * @param String message
	 */
	public synchronized void warn(String message)
	{
		this.logger.log(this.getClass().getCanonicalName(), Level.WARN, message, null);
	}
	
	/**
	 * proxy method to pass messages to error log
	 * 
	 * @param String message
	 */
	public synchronized void error(String message)
	{
		this.logger.log(this.getClass().getCanonicalName(), Level.ERROR, message, null);
	}
	
	/**
	 * proxy method to pass messages to fatal log
	 * 
	 * @param String message
	 */
	public synchronized void fatal(String message)
	{
		this.logger.log(this.getClass().getCanonicalName(), Level.FATAL, message, null);
	}
}
