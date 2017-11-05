package assignments.week01.project.db.adapter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import assignments.week01.project.bean.Account;
import assignments.week01.project.bean.Person;
import assignments.week01.project.bean.factory.AccountFactory;
import assignments.week01.project.bean.wrapper.AccountWrapper;
import assignments.week01.project.db.ResultSetWrapper;

/**
 * << singleton >>
 * 
 * performs database operations associated with
 * Account objects
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class AccountsTableAdapter extends AbstractTableAdapter<Account> 
{
	private static AccountFactory factory = AccountFactory.getInstance();
	private static AccountsTableAdapter instance = new AccountsTableAdapter();
	
	/**
	 * returns singleton instance
	 * 
	 * @return AccountsTableAdapter
	 */
	public static AccountsTableAdapter getInstance()
	{
		return instance;
	}
	
	private AccountsTableAdapter()
	{
		super();
	}
	
	/**
	 * retrieve one account from the database
	 * with key hashed as a single string
	 * 
	 * compound keys should have fields delimited
	 * by a ":"
	 * 
	 * @param String key
	 * 
	 * @return Account
	 */
	public Account get(String key)
	{
		String sql = "SELECT * FROM accounts WHERE id = ?";
		PreparedStatement stmt = null;
		ResultSet results = null;
		Map<String, String> data;
		Account Account = null;
		
		try {
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, key);
			results = stmt.executeQuery();
			
			/*
			 * if there are results then assign the account,
			 * otherwise there will be ResultSet closed ERROR messages
			 * thrown by the ResultSetWrapper
			 */
			if ( results.next() ) {
				data = ResultSetWrapper.toMap( results );
				Account = factory.create( data );
			}
			
			results.close();
			stmt.close();
			
		} catch(SQLException e) {
			log.error( e.getMessage() );
		}
		
		return Account;		
	}
	
	/**
	 * retrieve all accounts associated with the
	 * Person object passed
	 * 
	 * this could be a call to getAll() with a filter
	 * but this interface offers more efficiency for
	 * a frequently used use case
	 * 
	 * @param String key
	 * 
	 * @return Account
	 */
	public List<Account> getByOwner(Person person)
	{
		List<Account> accounts = new ArrayList<>();
		String sql = "SELECT * FROM accounts WHERE ssn = ? ORDER BY name";
		PreparedStatement stmt = null;
		ResultSet results = null;
		Map<String, String> data;
		Account account = null;
		
		try {
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, person.ssn );
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
	 * retrieve all Account objects in the table
	 * 
	 * @return List<Account>
	 */
	public List<Account> getAll()
	{
		List<Account> accounts = new ArrayList<>();		
		String sql = "SELECT * FROM accounts ORDER BY name";
		PreparedStatement stmt = null;
		ResultSet results = null;
		Map<String, String> data;
		Account account = null;
		
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
	 * write an account to the table
	 * return true if successful
	 * 
	 * @param Account account
	 * 
	 * @return boolean
	 */
	public boolean put(Account account)
	{
		String sql = "INSERT INTO accounts (name, type, ssn, status) VALUES (?, ?, ?, ?)";
		PreparedStatement stmt = null;
		boolean result = false;
		
		try {
			stmt = this.connection.prepareStatement( sql );
			
			stmt.setString(1, account.name);
			stmt.setString(2, String.valueOf( account.type) );
			stmt.setString(3, AccountWrapper.getOwner(account).ssn );
			stmt.setString(4, String.valueOf( account.status) );
			
			result = ( stmt.executeUpdate() > 0 ) ? true : false;
			
			stmt.close();
		} catch(SQLException e) {
			log.error( e.getMessage() );
		} 
		
		return result;
	}
	
	/**
	 * remove an account from the table
	 * return true if successful
	 * 
	 * @param Account account
	 * 
	 * @return boolean
	 */
	public boolean delete(Account account)
	{
		//TODO: delete method of PeopleTableAdapter
		return true;
	}
	
	/**
	 * update and existing account in the table
	 * return true if successful
	 * 
	 * @param Account account
	 * 
	 * @return boolean
	 */
	public boolean update(Account account)
	{
		String sql = "UPDATE accounts SET name=?, type=?, ssn=?, status=? WHERE id=?";
		PreparedStatement stmt = null;
		boolean result = false;
		
		try {
			stmt = this.connection.prepareStatement( sql );
			
			stmt.setString(1, account.name);
			stmt.setString(2, String.valueOf( account.type) );
			stmt.setString(3, AccountWrapper.getOwner(account).ssn );
			stmt.setString(4, String.valueOf( account.status) );
			stmt.setInt(5, account.id);
			
			result = ( stmt.executeUpdate() > 0 ) ? true : false;
			
			stmt.close();
		} catch(SQLException e) {
			log.error( e.getMessage() );
		} 
		
		return result;
	}
	
}
