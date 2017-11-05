package assignments.week01.project.db.adapter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import assignments.week01.project.bean.Account;
import assignments.week01.project.bean.Transaction;
import assignments.week01.project.bean.factory.TransactionFactory;
import assignments.week01.project.db.ResultSetWrapper;

/**
 * << singleton >>
 * 
 * performs database operations associated with
 * Transaction objects
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class TransactionsTableAdapter extends AbstractTableAdapter<Transaction> 
{
	private static TransactionFactory factory = TransactionFactory.getInstance();
	private static TransactionsTableAdapter instance = new TransactionsTableAdapter();
	
	/**
	 * get singleton instance
	 * 
	 * @return TransactionsTableAdapter
	 */
	public static TransactionsTableAdapter getInstance()
	{
		return instance;
	}
	
	private TransactionsTableAdapter()
	{
		super();
	}
	
	/**
	 * retrieve one transaction from the database
	 * with key hashed as a single string
	 * 
	 * compound keys should have fields delimited
	 * by a ":"
	 * 
	 * @param String key
	 * 
	 * @return Transaction
	 */
	public Transaction get(String key)
	{
		String sql = "SELECT * FROM transactions WHERE id = ?";
		PreparedStatement stmt = null;
		ResultSet results = null;
		Map<String, String> data;
		Transaction Transaction = null;
		
		try {
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, key);
			results = stmt.executeQuery();
			
			/*
			 * if there are results then assign the transaction,
			 * otherwise there will be ResultSet closed ERROR messages
			 * thrown by the ResultSetWrapper
			 */
			if ( results.next() ) {
				data = ResultSetWrapper.toMap( results );
				Transaction = factory.create( data );
			}
			
			results.close();
			stmt.close();
			
		} catch(SQLException e) {
			log.error( e.getMessage() );
		}
		
		return Transaction;		
	}
	
	/**
	 * retrieve all transactions from the database
	 * associated with the account passed
	 * 
	 * compound keys should have fields delimited
	 * by a ":"
	 * 
	 * @param String key
	 * 
	 * @return T
	 */
	public List<Transaction> getByAccount(Account account)
	{
		List<Transaction> transactions = new ArrayList<>();
		String sql = "SELECT * FROM transactions WHERE account_id = ? ORDER BY created";
		PreparedStatement stmt = null;
		ResultSet results = null;
		Map<String, String> data;
		Transaction transaction = null;
		
		try {
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, String.valueOf( account.id));
			results = stmt.executeQuery();
			
			while ( results.next() ) {
				data = ResultSetWrapper.toMap( results );
				transaction = factory.create( data );
				transactions.add( transaction );
			}
			
			results.close();
			stmt.close();
			
		} catch(SQLException e) {
			log.error( e.getMessage() );
		}
		
		return transactions;		
	}
	
	/**
	 * retrieve all Transaction objects in the table
	 * 
	 * @return List<Transaction>
	 */
	public List<Transaction> getAll()
	{
		List<Transaction> accounts = new ArrayList<>();		
		String sql = "SELECT * FROM transactions ORDER BY created";
		PreparedStatement stmt = null;
		ResultSet results = null;
		Map<String, String> data;
		Transaction account = null;
		
		try {
			stmt = this.connection.prepareStatement(sql);
			results = stmt.executeQuery();
	
			while ( results.next() ) {
				data = ResultSetWrapper.toMap( results );
				account = factory.create( data );
				accounts.add( account );
			}
			
			results.close();
			stmt.close();
			
		} catch(SQLException e) {
			log.error( e.getMessage() );
		}
		
		return accounts;
	}
	
	/**
	 * write an transaction to the table
	 * return true if successful
	 * 
	 * @param Transaction transaction
	 * 
	 * @return boolean
	 */
	public boolean put(Transaction transaction)
	{
		String sql = "INSERT INTO transactions (account_id, description, amount, status, created) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement stmt = null;
		boolean result = false;
		
		try {
			stmt = this.connection.prepareStatement( sql );
			

			stmt.setInt(1, transaction.accountId);
			stmt.setString(2, transaction.description );
			stmt.setString(3, String.valueOf( transaction.amount) );
			stmt.setString(4, String.valueOf( transaction.status) );
			stmt.setString(5, String.valueOf( transaction.created) );
			
			result = ( stmt.executeUpdate() > 0 ) ? true : false;
			
			stmt.close();
		} catch(SQLException e) {
			log.error( e.getMessage() );
		} 
		
		return result;
	}
	
	/**
	 * remove an transaction from the table
	 * return true if successful
	 * 
	 * @param Transaction transaction
	 * 
	 * @return boolean
	 */
	public boolean delete(Transaction transaction)
	{
		//TODO: delete method of PeopleTableAdapter
		return true;
	}
	
	/**
	 * update and existing transaction in the table
	 * return true if successful
	 * 
	 * @param Transaction transaction
	 * 
	 * @return boolean
	 */
	public boolean update(Transaction transaction)
	{
		//TODO: update method of PeopleTableAdapter
		return true;
	}
}
