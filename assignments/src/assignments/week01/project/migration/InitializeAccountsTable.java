package assignments.week01.project.migration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import assignments.week01.project.bean.Account;
import assignments.week01.project.bean.factory.AccountFactory;
import assignments.week01.project.db.adapter.AccountsTableAdapter;
import assignments.week01.project.db.adapter.TableAdapterInterface;

public class InitializeAccountsTable extends AbstractMigration
{
	/**
	 * @see AbstractMigration
	 */
	public void run()
	{
		TableAdapterInterface<Account> accounts = AccountsTableAdapter.getInstance();
		
		/**
		 * insert each Account object directly into the database
		 */
		this.getAccounts()
			.stream()
			.forEach( account -> accounts.put( account ));
	}
	
	/**
	 * generate a List of Account objects to
	 * insert into the database
	 * 
	 * @return List<Account>
	 */
	private List<Account> getAccounts()
	{
		List<Account> accounts = new ArrayList<>();
		AccountFactory factory = AccountFactory.getInstance();
		Map<String, String> data = new HashMap<>();
		String[][] rawData = {
			{ "Free Checking", String.valueOf(Account.TYPE_CHECKING), "123456781", "1" },
			{ "Free Savings", String.valueOf(Account.TYPE_SAVINGS), "123456781", "1" },
			{ "Draft Checking", String.valueOf(Account.TYPE_CHECKING), "123456782", "1" },
			{ "Draft Savings", String.valueOf(Account.TYPE_SAVINGS), "123456783", "1" },
//			{ "123456784", "Fay", "David", "", "dfay@gmail.com" },
//			{ "123456785", "Jones", "Brian", "", "bjones@gmail.com" },
//			{ "123456786", "Hatcher", "Wanda", "", "whatcher@gmail.com" },
		};
		
		for(String[] raw: rawData ) {
			data.clear();
			data.put("name", raw[0]);
			data.put("type", raw[1]);
			data.put("ssn", raw[2]);
			data.put("status", raw[3]);
			
			accounts.add( factory.create(data) );
		}
		
		
		return accounts;
	}
}
