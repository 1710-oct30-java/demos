package assignments.week01.question20;

import java.util.ArrayList;
import java.util.List;

/**
 * represents the storage of Person objects
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class PersonStore 
{
	private FileManager fileManager;		// handles file operations
	private PersonSerializer serializer;	// encodes/decodes String hashes of Person objects
	private String filePath;				// path to data file
	
	public PersonStore(String filePath)
	{
		this.filePath = filePath;
	}
	
	/**
	 * save a Person object to storage
	 * return true if successful, false if not
	 * 
	 * @param Person person
	 * 
	 * @return boolean
	 */
	public boolean save(Person person)
	{
		String serlizedPerson = this.getSerializer().encode(person);
		return this.getFileManager().write(serlizedPerson);
	}
	
	/**
	 * retrieve all Person objects in storage
	 * 
	 * @return List<Person>
	 */
	public List<Person> retrieve()
	{
		List<String> serializedData = this.getFileManager().read();
		List<Person> output = new ArrayList<>();
		
		for(String data : serializedData ) {
			output.add( this.getSerializer().decode(data) );
		}
		
		return output;		
	}
	
	/**
	 * lazy-load a FileManager object
	 * 
	 * @return FileManager
	 */
	private FileManager getFileManager()
	{
		if ( this.fileManager == null ) {
			this.fileManager = new FileManager( this.filePath );
		}
		
		return this.fileManager;
	}
	
	/**
	 * lazy-load a PersonSerializer object
	 * 
	 * @return PersonSerializer
	 */
	private PersonSerializer getSerializer()
	{
		if ( this.serializer == null ) {
			this.serializer = new PersonSerializer();
		}
		
		return this.serializer;
	}

}
