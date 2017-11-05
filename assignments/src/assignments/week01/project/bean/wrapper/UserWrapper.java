package assignments.week01.project.bean.wrapper;


import assignments.week01.project.bean.Person;
import assignments.week01.project.bean.User;
import assignments.week01.project.db.adapter.PeopleTableAdapter;

/**
 * << decorator >>
 * 
 * a utility decorator class for the User entity
 * that adds data retrieval functionality
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class UserWrapper 
{
	private static PeopleTableAdapter people = PeopleTableAdapter.getInstance();
		
	/**
	 * returns the Person object associated with the
	 * User object passed
	 * 
	 * @param User user
	 * 
	 * @return Person
	 */
	public static Person getPerson(User user)
	{
		return people.getByUser( user );
	}
		
}
