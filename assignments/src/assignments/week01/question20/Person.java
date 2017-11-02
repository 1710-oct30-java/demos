package assignments.week01.question20;

/**
 * entity class to represent a person
 * 
 * @author john.w.brown.jr@gmail.com
 */
public class Person 
{
	public String lastName;
	public String firstName;
	public int age;
	public String state;
	
	@Override
	public String toString() {
		return "Person [lastName=" + lastName + ", firstName=" + firstName + ", age=" + age + ", state=" + state + "]";
	}
	
	
}
