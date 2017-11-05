package assignments.week01.project.bean.factory;

import java.util.Map;
import java.util.Set;

import assignments.week01.project.bean.Person;

/**
 * << singleton >> 
 * 
 * class that instantiates hydrated Person objects
 * with properties passed as Map<String, String>
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class PersonFactory implements FactoryInterface<Person>
{
	private static PersonFactory instance = new PersonFactory();
	
	/**
	 * returns singleton instance
	 * 
	 * @return PersonFactory
	 */
	public static PersonFactory getInstance()
	{
		return instance;
	}
	
	private PersonFactory()
	{
		super();
	}
	
	/**
	 * returns a hydrated instance of the
	 * Person class
	 * 
	 * @param Map<String, String> data
	 * 
	 * @return Person
	 */
	public Person create( Map<String, String> data )
	{
		Set<String> keys = data.keySet();
		Person person = new Person();
		
		for( String key: keys ) {
			switch( key.toLowerCase() ) {
				case "ssn" :
					person.ssn = data.get(key);
					break;
				case "lastname" :
					person.lastName = data.get(key);
					break;
				case "firstname" :
					person.firstName = data.get(key);
					break;
				case "middlename" :
					person.middleName = data.get(key);
					break;
				case "email" :
					person.email = data.get(key);
					break;
			}
		}
		
		return person;
	}
}
