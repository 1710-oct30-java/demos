package assignments.week01.project.db.adapter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import assignments.week01.project.bean.Person;
import assignments.week01.project.bean.User;
import assignments.week01.project.bean.factory.PersonFactory;
import assignments.week01.project.db.ResultSetWrapper;

/**
 * << singleton >>
 * 
 * performs database operations associated with
 * Person objects
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class PeopleTableAdapter extends AbstractTableAdapter<Person> 
{
	private static PersonFactory factory = PersonFactory.getInstance();
	private static PeopleTableAdapter instance = new PeopleTableAdapter();
	
	/**
	 * returns singleton instance
	 * 
	 * @return PeopleTableAdapter
	 */
	public static PeopleTableAdapter getInstance()
	{
		return instance;
	}
	
	private PeopleTableAdapter()
	{
		super();
	}
	
	/**
	 * retrieve one person from the database
	 * with key hashed as a single string
	 * 
	 * compound keys should have fields delimited
	 * by a ":"
	 * 
	 * @param String key
	 * 
	 * @return T
	 */
	public Person get(String key)
	{
		String sql = "SELECT * FROM people WHERE ssn = ?";
		PreparedStatement stmt = null;
		ResultSet results = null;
		Map<String, String> data;
		Person person = null;
		
		try {
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, key);
			results = stmt.executeQuery();
			
			/*
			 * if there are results then assign the person,
			 * otherwise there will be ResultSet closed ERROR messages
			 * thrown by the ResultSetWrapper
			 */
			if ( results.next() ) {
				data = ResultSetWrapper.toMap( results );
				person = factory.create( data );
			}
			
			results.close();
			stmt.close();
			
		} catch(SQLException e) {
			log.error( e.getMessage() );
		}
		
		return person;
		
	}
	
	/**
	 * return Person associated with user passed
	 * 
	 * @param User user
	 * 
	 * @return Person
	 */
	public Person getByUser(User user)
	{
		return this.get( user.ssn );
	}
	
	/**
	 * retrieve all Person objects in the table
	 * 
	 * @return List<Person>
	 */
	public List<Person> getAll()
	{
		List<Person> people = new ArrayList<>();		
		String sql = "SELECT * FROM people ORDER BY lastName, firstName, middleName";
		PreparedStatement stmt = null;
		ResultSet results = null;
		Map<String, String> data;
		Person person = null;
		
		try {
			stmt = this.connection.prepareStatement(sql);
			results = stmt.executeQuery();
			
			while ( results.next() ) {
				data = ResultSetWrapper.toMap( results );
				person = factory.create( data );
				people.add( person );
			}
			
			results.close();
			stmt.close();
			
		} catch(SQLException e) {
			log.error( e.getMessage() );
		}
		
		return people;
	}
	
	/**
	 * write an person to the table
	 * return true if successful
	 * 
	 * @param Person person
	 * 
	 * @return boolean
	 */
	public boolean put(Person person)
	{
		String sql = "INSERT INTO people (ssn, lastName, firstName, middleName, email) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement stmt = null;
		boolean result = false;
		
		try {
			stmt = this.connection.prepareStatement( sql );
			
			
			stmt.setString(1, person.ssn);
			stmt.setString(2, person.lastName);
			stmt.setString(3, person.firstName);
			stmt.setString(4, person.middleName);
			stmt.setString(5, person.email);
			
			result = ( stmt.executeUpdate() > 0 ) ? true : false;

			stmt.close();
		} catch(SQLException e) {
			log.error( e.getMessage() );
		} 
		
		return result;
	}
	
	/**
	 * remove an person from the table
	 * return true if successful
	 * 
	 * @param Person person
	 * 
	 * @return boolean
	 */
	public boolean delete(Person person)
	{
		//TODO: delete method of PeopleTableAdapter
		return true;
	}
	
	/**
	 * update and existing person in the table
	 * return true if successful
	 * 
	 * @param Person person
	 * 
	 * @return boolean
	 */
	public boolean update(Person person)
	{
		//TODO: update method of PeopleTableAdapter
		return true;
	}
}
