package assignments.week01.project.migration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import assignments.week01.project.bean.Person;
import assignments.week01.project.bean.factory.PersonFactory;
import assignments.week01.project.db.adapter.PeopleTableAdapter;
import assignments.week01.project.db.adapter.TableAdapterInterface;

public class InitializePeopleTable extends AbstractMigration
{
	/**
	 * @see AbstractMigration
	 */
	public void run()
	{
		TableAdapterInterface<Person> people = PeopleTableAdapter.getInstance();
		
		/*
		 * insert People objects directly into database
		 */
		this.getPeople()
			.stream()
			.forEach( person -> people.put( person ) );
	}
	
	/**
	 * generate a List of Person objects to
	 * insert into the database
	 * 
	 * @return List<Person>
	 */
	private List<Person> getPeople()
	{
		List<Person> people = new ArrayList<>();
		PersonFactory factory = PersonFactory.getInstance();
		Map<String, String> data = new HashMap<>();
		String[][] rawData = {
			{ "123456781", "Brown", "John", "Wesley", "jbrown@gmail.com" },
			{ "123456782", "Smith", "Joseph", "", "jsmith@gmail.com" },
			{ "123456783", "Kruppa", "Blake", "", "bkruppa@gmail.com" },
			{ "123456784", "Fay", "David", "", "dfay@gmail.com" },
			{ "123456785", "Jones", "Brian", "", "bjones@gmail.com" },
			{ "123456786", "Hatcher", "Wanda", "", "whatcher@gmail.com" },
		};
		
		for(String[] raw: rawData ) {
			data.clear();
			data.put("ssn", raw[0]);
			data.put("lastName", raw[1]);
			data.put("firstName", raw[2]);
			data.put("middleName", raw[3]);
			data.put("email", raw[4]);
			
			people.add( factory.create(data) );
		}
		
		
		return people;
	}
}
