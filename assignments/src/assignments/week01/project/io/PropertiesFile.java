package assignments.week01.project.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import assignments.week01.project.log.SysLog;

/**
 * represents an abstraction of a properties file
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class PropertiesFile 
{
	private static SysLog log = SysLog.getInstance();
	
	/**
	 * read a .properties file into a Properties collection
	 * 
	 * @param String filePath
	 * 
	 * @return Properties
	 */
	public static Properties read(String filePath )
	{
		Properties config = new Properties();
		InputStream reader = null;

		try {
			reader = PropertiesFile.class.getResourceAsStream( String.format("/%s", filePath) );
			
//			reader = new FileInputStream( filePath );
			config.load(reader);
			
		} catch(IOException e) {
			log.error( e.getMessage() );
		}

		return config;
	}
}
