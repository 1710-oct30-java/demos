package assignments.week01.project.db.adapter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import assignments.week01.project.bean.Person;
import assignments.week01.project.bean.User;
import assignments.week01.project.bean.factory.UserFactory;
import assignments.week01.project.db.ResultSetWrapper;

/**
 * << singleton >>
 * 
 * performs database operations associated with
 * User objects
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class UsersTableAdapter extends AbstractTableAdapter<User> 
{
	private static UserFactory factory = UserFactory.getInstance();
	private static UsersTableAdapter instance = new UsersTableAdapter();
	
	/**
	 * get singleton instance
	 * 
	 * @return UsersTableAdapter
	 */
	public static UsersTableAdapter getInstance()
	{
		return instance;
	}
	
	public UsersTableAdapter()
	{
		super();
	}
	
	/**
	 * retrieve one user from the database
	 * with key hashed as a single string
	 * 
	 * compound keys should have fields delimited
	 * by a ":"
	 * 
	 * @param String key
	 * 
	 * @return User
	 */
	public User get(String key)
	{
		String sql = "SELECT * FROM users WHERE ( identity = ? OR id = ? )";
		PreparedStatement stmt = null;
		ResultSet results = null;
		Map<String, String> data;
		User user = null;
		
		try {
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, key);
			stmt.setString(2, key);
			results = stmt.executeQuery();
			
			/*
			 * if there are results then assign the user,
			 * otherwise there will be ResultSet closed ERROR messages
			 * thrown by the ResultSetWrapper
			 */
			if ( results.next() ) {
				data = ResultSetWrapper.toMap( results );
				user = factory.create( data );
			}
			
			results.close();
			stmt.close();
			
		} catch(SQLException e) {
			log.error( e.getMessage() );
		}
		
		return user;
		
	}
	
	/**
	 * retrieve all User objects associated
	 * with the Person object passed
	 * 
	 * @param Person person
	 * 
	 * @return List<User>
	 */
	public List<User> getByPerson(Person person)
	{
		List<User> users = new ArrayList<>();		
		String sql = "SELECT * FROM users WHERE ssn = ? ORDER BY identity";
		PreparedStatement stmt = null;
		ResultSet results = null;
		Map<String, String> data;
		User user = null;
		
		try {
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, person.ssn);
			
			results = stmt.executeQuery();
	
			while ( results.next() ) {
				data = ResultSetWrapper.toMap( results );
				user = factory.create( data );
				users.add( user );
			}
			
			results.close();
			stmt.close();
			
		} catch(SQLException e) {
			log.error( e.getMessage() );
		}
		
		return users;
	}
	
	/**
	 * retrieve all User objects in the table
	 * 
	 * @return List<User>
	 */
	public List<User> getAll()
	{
		List<User> users = new ArrayList<>();		
		String sql = "SELECT * FROM users ORDER BY identity";
		PreparedStatement stmt = null;
		ResultSet results = null;
		Map<String, String> data;
		User user = null;
		
		try {
			stmt = this.connection.prepareStatement(sql);
			results = stmt.executeQuery();
	
			while ( results.next() ) {
				data = ResultSetWrapper.toMap( results );
				user = factory.create( data );
				users.add( user );
			}
			
			results.close();
			stmt.close();
			
		} catch(SQLException e) {
			log.error( e.getMessage() );
		}
		
		return users;
	}
	
	/**
	 * write an user to the table
	 * return true if successful
	 * 
	 * @param User user
	 * 
	 * @return boolean
	 */
	public boolean put(User user)
	{
		String sql = "INSERT INTO users (identity, password, ssn, type ) VALUES (?, ?, ?, ?)";
		PreparedStatement stmt = null;
		boolean result = false;
		
		try {
			stmt = this.connection.prepareStatement( sql );
			
			stmt.setString(1, user.identity);
			stmt.setString(2, user.credential);
			stmt.setString(3, user.ssn);
			stmt.setString(4, String.valueOf(user.type));
									
			result = ( stmt.executeUpdate() > 0 ) ? true : false;
			
			stmt.close();
		} catch(SQLException e) {
			log.error( e.getMessage() );
		} 
		
		return result;
	}
	
	/**
	 * remove an user from the table
	 * return true if successful
	 * 
	 * @param User user
	 * 
	 * @return boolean
	 */
	public boolean delete(User user)
	{
		//TODO: delete method of PeopleTableAdapter
		return true;
	}
	
	/**
	 * update and existing user in the table
	 * return true if successful
	 * 
	 * @param User user
	 * 
	 * @return boolean
	 */
	public boolean update(User user)
	{
		//TODO: update method of PeopleTableAdapter
		return true;
	}
}
