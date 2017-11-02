package assignments.week01.question07;

/**
 * represents an employee [ data class ]
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class  Employee {
	
	public String name;
	public int age;
	public String department;
	
	public Employee(String name, int age, String department)
	{
		this.name = name;
		this.age = age;
		this.department = department;
	}
	
	public String toString() 
	{
		return String.format("{ name:%s, age:%d, department:%s }",
				this.name,
				this.age,
				this.department
		);
	}
	
}
