package assignments.week01.project.bean.factory;

import java.util.Map;
import java.util.Set;

import assignments.week01.project.bean.Account;

/**
 * << singleton >> 
 * 
 * class that instantiates hydrated Account objects
 * with properties passed as Map<String, String>
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class AccountFactory implements FactoryInterface<Account>
{
	private static AccountFactory instance = new AccountFactory();
	
	/**
	 * return singleton instance
	 * 
	 * @return AccountFactory
	 */
	public static AccountFactory getInstance()
	{
		return instance;
	}
	
	private AccountFactory()
	{
		super();
	}
	
	/**
	 * create an instance of an Account
	 * hydrated with the properties identified
	 * in the Map<String, String>
	 * 
	 * @param Map<String, String> data
	 * 
	 * @return Account
	 */
	public Account create( Map<String, String> data )
	{
		Set<String> keys = data.keySet();
		Account account = new Account();
		
		for( String key: keys ) {
			switch( key.toLowerCase() ) {
				case "ssn" :
					account.ssn = data.get( key );
					break;
				case "name" :
					account.name = data.get(key);
					break;
				case "type" :
					account.type = Integer.parseInt( data.get(key) );
					break;
				case "status" :
					account.status = Integer.parseInt( data.get(key) );
					break;
				case "id" :
					account.id = Integer.parseInt( data.get(key) );
					break;
			}
		}
		
		return account;
	}
}
