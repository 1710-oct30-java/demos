package assignments.week01.project.bean.wrapper;

import java.util.List;

import assignments.week01.project.bean.Account;
import assignments.week01.project.bean.Person;
import assignments.week01.project.bean.User;
import assignments.week01.project.db.adapter.AccountsTableAdapter;
import assignments.week01.project.db.adapter.UsersTableAdapter;

/**
 * << decorator >>
 * 
 * a utility class for decorating the Person class
 * that adds database retrieval functionality
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class PersonWrapper 
{
	private static AccountsTableAdapter accounts = AccountsTableAdapter.getInstance();
	private static UsersTableAdapter users = new UsersTableAdapter();
	
	/**
	 * returns a List of Account objects associated
	 * with the Person object passed
	 * 
	 * @param Person person
	 * 
	 * @return List<Account>
	 */
	public static List<Account> getAccounts(Person person)
	{
		return accounts.getByOwner( person );
	}
	
	/**
	 * returns the User objects associated with the
	 * Person object passed
	 * 
	 * @param Person person
	 * 
	 * @return List<User>
	 */
	public static List<User> getUsers(Person person)
	{
		return users.getByPerson( person );
	}
}
