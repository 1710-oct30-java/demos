package assignments.week01.question20;

import java.util.Map;
import java.util.Set;

/**
 * instantiates a hydrated Person object using a Map of
 * properties 
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class PersonFactory 
{
	/**
	 * create new hydrated Person object
	 * 
	 * @param Map<String, String> data
	 * 
	 * @return Person
	 */
	public Person create( Map<String, String> data )
	{
		Person person = new Person();
		
		Set<String> keys = data.keySet();
		
		for(String key : keys ) {
			switch( key.toLowerCase() ) {
				case "lastname" : 
					person.lastName = data.get(key);
					break;
				case "firstname" :
					person.firstName = data.get(key);
					break;
				case "age" :
					person.age = Integer.parseInt( data.get(key));
					break;
				case "state" :
					person.state = data.get(key);
					break;
			}
		}
		
		return person;
	}
}
