package assignments.week01.project.migration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import assignments.week01.project.bean.Transaction;
import assignments.week01.project.bean.factory.TransactionFactory;
import assignments.week01.project.db.adapter.TableAdapterInterface;
import assignments.week01.project.db.adapter.TransactionsTableAdapter;

public class InitializeTransactionsTable extends AbstractMigration
{
	/**
	 * @see AbstractMigration
	 */
	public void run()
	{
		TableAdapterInterface<Transaction> transactions = TransactionsTableAdapter.getInstance();
		
		/**
		 * insert each Transaction object directly into the database
		 */
		this.getTransactions()
			.stream()
			.forEach( transaction -> transactions.put( transaction ) );
	}
	
	/**
	 * generate a List of Transaction objects to
	 * insert into the database
	 * 
	 * @return List<Transaction>
	 */
	private List<Transaction> getTransactions()
	{
		List<Transaction> transactions = new ArrayList<>();
		TransactionFactory factory = TransactionFactory.getInstance();
		Map<String, String> data = new HashMap<>();
		String[][] rawData = {
			{ "1", "Revature Weekly Rental", "-110.00", "1" },
			{ "1", "Revature Weekly Rental", "-110.00", "0" },
			{ "1", "Revature Payroll", "440.00", "1" },
			{ "1", "Revature Payroll", "440.00", "0" },
		};
		
		for(String[] raw: rawData ) {
			data.clear();
			data.put("account_id", raw[0]);
			data.put("description", raw[1]);
			data.put("amount", raw[2]);
			data.put("status", raw[3]);
			
			transactions.add( factory.create(data) );
		}
		
		
		return transactions;
	}
}
