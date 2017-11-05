package assignments.week01.project.bean.factory;

import java.util.Map;
import java.util.Set;

import assignments.week01.project.bean.User;

/**
 * << singleton >> 
 * 
 * class that instantiates hydrated User objects
 * with properties passed as Map<String, String>
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class UserFactory implements FactoryInterface<User>
{
	private static UserFactory instance = new UserFactory();
	
	/**
	 * return singleton instance
	 * 
	 * @return PersonFactory
	 */
	public static UserFactory getInstance()
	{
		return instance;
	}
	
	private UserFactory()
	{
		super();

	}
	
	/**
	 * returns a hydrated instance of the User class
	 * 
	 * @param Map<String, String>
	 * 
	 * @return User
	 */
	public User create( Map<String, String> data )
	{
		Set<String> keys = data.keySet();
		User user = new User();
		
		
		for( String key: keys ) {
			switch( key.toLowerCase() ) {
				case "id" :
					user.id = Integer.parseInt( data.get(key) );
					break;
				case "ssn" :
					user.ssn = data.get(key);
					break;
				case "identity" :
					user.identity = data.get(key);
					break;
				case "password" :
					user.credential = data.get(key);
					break;
				case "type" :
					user.type = Integer.parseInt( data.get(key));
			}
		}
		
		return user;
	}
}
