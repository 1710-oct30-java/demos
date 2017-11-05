package assignments.week01.project.bean.wrapper;

import java.util.List;

import assignments.week01.project.bean.Account;
import assignments.week01.project.bean.Person;
import assignments.week01.project.bean.Transaction;
import assignments.week01.project.db.adapter.PeopleTableAdapter;
import assignments.week01.project.db.adapter.TransactionsTableAdapter;

/**
 * << decorator >>
 * 
 * a utility class for decorating the Account class
 * that adds database retrieval functionality
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class AccountWrapper 
{
	private static PeopleTableAdapter people = PeopleTableAdapter.getInstance();
	private static TransactionsTableAdapter transactions = TransactionsTableAdapter.getInstance();
	
	public static Person getOwner(Account account)
	{
		return people.get( account.ssn );
	}
	
	/**
	 * retrieve all transactions associated
	 * with the Account object passed
	 * 
	 * @return List<Transaction>
	 */
	public static List<Transaction> getTransactions(Account account)
	{	
		return transactions.getByAccount( account );
	}
	
	/**
	 * adds a new transaction to the Account
	 * passed
	 * 
	 * @param Transaction newTransaction
	 * 
	 * @return self
	 */
	public boolean addTransaction(Account account, Transaction newTransaction )
	{
		newTransaction.accountId = account.id;
		return transactions.put( newTransaction );
	}
	
	/**
	 * calculate and return the total balance of the
	 * Account passed
	 * 
	 * - total balance of all transactions
	 * 
	 * @return Double
	 */
	public static Double getTotalBalance(Account account)
	{
		return getTransactions( account ).stream()
			.mapToDouble( transaction -> transaction.amount )
			.sum();
	}
	
	/**
	 * calculate and return the total pending balance
	 * of the Account passed
	 * 
	 * - total balance less any NON-pending transactions
	 * 
	 * @return Double
	 */
	public static Double getPendingBalance(Account account)
	{
		return getTransactions( account ).stream()
			.filter( transaction -> transaction.status == Transaction.STATUS_PENDING )
			.mapToDouble( transaction -> transaction.amount )
			.sum();
	}
	
	/**
	 * calculate and return the total available balance
	 * of the Account passed
	 * 
	 * - total balance less any pending transactions
	 * 
	 * @return Double
	 */
	public static Double getAvailableBalance(Account account)
	{
		return getTransactions( account ).stream()
				.filter( transaction -> transaction.status == Transaction.STATUS_APPLIED )
				.mapToDouble( transaction -> transaction.amount )
				.sum();
	}
}
