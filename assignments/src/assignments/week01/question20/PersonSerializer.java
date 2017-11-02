package assignments.week01.question20;

import java.util.HashMap;
import java.util.Map;

/**
 * transforms a Person object in/out of a
 * delimited String hash and
 *  
 * @author john.w.brown.jr@gmail.com
 */
public class PersonSerializer 
{
	/**
	 * used to instantiate a hydrated Person object
	 */
	private PersonFactory factory;
	
	/**
	 * transforms a Person into a delimited
	 * String hash
	 * 
	 * @param Person person
	 * 
	 * @return String
	 */
	public String encode(Person person )
	{
		return String.format("%s:%s:%d:%s",
			person.firstName,
			person.lastName,
			person.age,
			person.state
		);
	}
	
	/**
	 * transform a delimted String hash into a 
	 * hydrated Person object
	 * 
	 * @param String data
	 * 
	 * @return Person
	 */
	public Person decode(String dataString )
	{
		String[] dataArray = dataString.split(":");
		Map<String, String> dataMap = new HashMap<>();
		
		dataMap.put("firstName", dataArray[0] );
		dataMap.put("lastName", dataArray[1] );
		dataMap.put("age", String.valueOf( dataArray[2] ) );
		dataMap.put("state", dataArray[3] );
		
		return this.getFactory().create( dataMap );
		
	}
	
	/**
	 * lazy-load a PersonFactory for creating
	 * hydrated Person objects 
	 * 
	 * @return PersonFactory
	 */
	private PersonFactory getFactory()
	{
		if ( this.factory == null ) {
			this.factory = new PersonFactory();
		}
		
		return this.factory;
	}
}
