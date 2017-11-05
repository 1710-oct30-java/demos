package assignments.week01.project.bean.factory;

import java.util.Map;
import java.util.Set;

import assignments.week01.project.bean.Transaction;

/**
 * << singleton >> 
 * 
 * class that instantiates hydrated Transaction objects
 * with properties passed as Map<String, String>
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class TransactionFactory implements FactoryInterface<Transaction>
{
	private static TransactionFactory instance = new TransactionFactory();
		
	/**
	 * return singleton instance
	 * 
	 * @return TransactionFactory
	 */
	public static TransactionFactory getInstance()
	{
		return instance;
	}
	
	private TransactionFactory()
	{
		super();
		
	}
	
	/**
	 * returns a hydrated instance of the Transaction
	 * class
	 * 
	 * @param Map<String, String> data
	 * 
	 * @return Transaction
	 */
	public Transaction create( Map<String, String> data )
	{
		Set<String> keys = data.keySet();
		Transaction transaction = new Transaction();
		
		for( String key: keys ) {
			switch( key.toLowerCase() ) {
				case "account_id" :
					transaction.accountId = Integer.valueOf( data.get(key) );
					break;
				case "description" :
					transaction.description = data.get(key);
					break;
				case "status" :
					transaction.status = Integer.parseInt( data.get(key) );
					break;
				case "amount" :
					transaction.amount = Double.parseDouble( data.get(key) );
					break;
				case "id" :
					transaction.id = Integer.parseInt( data.get(key) );
					break;
			}
		}
		
		return transaction;
	}
}
