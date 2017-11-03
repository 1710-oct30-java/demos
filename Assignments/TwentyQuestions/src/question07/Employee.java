package question07;

/**
 * Question 7: Sort two employees based on their name, department, and age 
 * using the Comparator interface.
 * 
 * @author Mitch Goshorn
 *
 */
public class Employee {
	String name;
	String department;
	long dateofbirth;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public long getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(long dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	
	public Employee(String name, String department, long dateofbirth) {
		super();
		this.name = name;
		this.department = department;
		this.dateofbirth = dateofbirth;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", dateofbirth=" + dateofbirth + "]";
	}
	
	
}
