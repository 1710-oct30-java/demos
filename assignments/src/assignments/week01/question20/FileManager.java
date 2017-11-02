package assignments.week01.question20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * represents a file resource within this package
 * used to open files for reading and writing strings
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class FileManager 
{
	/**
	 * absolute path to file
	 */
	private String path;
	
	public FileManager(String path)
	{
		this.path = path;
	}
	
	/**
	 * write the String to file
	 * return true upon success and false upon failure
	 * 
	 * @param String data
	 * 
	 * @return boolean
	 */
	public boolean write(String data)
	{
		try(
			Writer writer = this.getWriter();
		) {
			writer.write( data );
			writer.append('\n');
			writer.flush();
		} catch(IOException e) {
			handleError(e);
			return false;
		}
		
		return true;
	}
	
	/**
	 * read the contents of the file into a
	 * String list
	 * 
	 * @return List<String>
	 */
	public List<String> read()
	{
		try(
			Reader reader = this.getReader();
			BufferedReader br = new BufferedReader( reader );
		) {
			return br.lines().collect( Collectors.toList() );			
		} catch(IOException e) {
			handleError(e);
			return new ArrayList<String>();
		}
	}
	
	/**
	 * helper function to handle all thrown errors
	 * 
	 * @param Exception e
	 */
	private static void handleError(Exception e)
	{
		e.printStackTrace();
	}
	
	/**
	 * factory method for a Writer object
	 * 
	 * @return Writer
	 * 
	 * @throws IOException
	 */
	private Writer getWriter() throws IOException
	{
		return new FileWriter( this.getFile() );
	}
	
	/**
	 * factory method for a Reader object
	 * 
	 * @return Reader
	 * 
	 * @throws IOException
	 */
	private Reader getReader() throws IOException
	{
		return new FileReader( this.getFile() );
	}
	
	/**
	 * returns file resource for the file 
	 * at the path set
	 * 
	 * @param String path
	 * 
	 * @return File
	 */
	private File getFile() throws IOException
	{
		return new File( this.path );
	}
	

}
