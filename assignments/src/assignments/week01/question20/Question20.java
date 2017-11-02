package assignments.week01.question20;

import java.util.List;

public class Question20 
{
	public static void main(String[] args) 
	{
		/*
		 * instantiate Person object storage using the 
		 * data.txt file
		 */
		PersonStore storage = new PersonStore("data.txt");
		
		List<Person> people = storage.retrieve();			// retrieve Person objects in storage
		
		/*
		 * loop through retrieve objects and
		 * display each to console
		 */
		for(Person person : people ) {
			displayPerson( person );
		}
	}
	
	/**
	 * display a Person object to console formatted
	 * as specified
	 * 
	 * @param Person person
	 */
	public static void displayPerson(Person person)
	{
		System.out.println( String.format("Name: %s %s\nAge: %d years\nState: %s\n",
			person.firstName,
			person.lastName,
			person.age,
			person.state
		) );
	}
}
