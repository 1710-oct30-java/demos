package assignments.week01.project.migration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import assignments.week01.project.bean.User;
import assignments.week01.project.bean.factory.UserFactory;
import assignments.week01.project.db.adapter.TableAdapterInterface;
import assignments.week01.project.db.adapter.UsersTableAdapter;

public class InitializeUsersTable extends AbstractMigration
{
	/**
	 * @see AbstractMigration
	 */
	public void run()
	{
		TableAdapterInterface<User> users = new UsersTableAdapter();
		
		/**
		 * insert User objects directly into database
		 */
		this.getUsers()
			.stream()
			.forEach( user -> users.put( user ) );
	}
	
	/**
	 * generate a List of Person objects to
	 * insert into the database
	 * 
	 * @return List<Person>
	 */
	private List<User> getUsers()
	{
		List<User> users = new ArrayList<>();
		UserFactory factory = UserFactory.getInstance();
		Map<String, String> data = new HashMap<>();
		String[][] rawData = {
			{ "brownj", "password", "123456781", String.valueOf(User.TYPE_ADMIN) },
			{ "smithj", "password", "123456782", String.valueOf(User.TYPE_NORMAL) },
			{ "kruppab", "password", "123456783", String.valueOf(User.TYPE_ADMIN) },
			{ "fayd", "password", "123456784", String.valueOf(User.TYPE_NORMAL) },
			{ "jonesb", "password", "123456785", String.valueOf(User.TYPE_NORMAL) },
			{ "hatcherw", "password", "123456786", String.valueOf(User.TYPE_NORMAL) },
		};
		
		for(String[] raw: rawData ) {
			data.clear();
			data.put("identity", raw[0]);
			data.put("password", raw[1]);
			data.put("ssn", raw[2]);
			data.put("type", raw[3]);
			
			users.add( factory.create(data) );
		}
		
		
		return users;
	}
}
