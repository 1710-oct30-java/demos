package question7;
/*
 * Sort two employees based on their name, department, and age 
 * using the comparator interface.
 */
import java.util.Comparator;

class Employee 
{
	String name;
	String department;
	int age;
	
	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department
				+ ", age=" + age + "]";
	}	
	
}

class SortByName implements Comparator<Employee>
{
	@Override
	public int compare(Employee o1, Employee o2) 
	{
		return o1.name.compareTo(o2.name);
	}
	
}

class SortByDepartment implements Comparator<Employee>
{
	@Override
	public int compare(Employee o1, Employee o2) 
	{
		return o1.department.compareTo(o2.department);
	}
	
}

class SortByAge implements Comparator<Employee>
{
	@Override
	public int compare(Employee o1, Employee o2) 
	{
		return o1.age - o2.age;
	}
	
}
class QuestionSeven 
{
	public static void main(String[] args) 
	{
		Employee A = new Employee("Steve", "Accounting", 38);
		Employee B = new Employee("David", "Marketing", 32);
		SortByName sortN = new SortByName();
		SortByDepartment sortD = new SortByDepartment();
		SortByAge sortA = new SortByAge();
		
//		System.out.println(A.toString());
//		System.out.println(B.toString());
		
		System.out.println("Sorted by name:");
		if (sortN.compare(B, A) < 0)
		{
			System.out.println(B);
			System.out.println(A);
		}
		else
		{
			System.out.println(A);
			System.out.println(B);
		}
		System.out.println("\nSorted by department:");
		if (sortD.compare(B, A) < 0)
		{
			System.out.println(B);
			System.out.println(A);
		}
		else
		{
			System.out.println(A);
			System.out.println(B);
		}
		System.out.println("\nSorted by age:");
		if (sortA.compare(B, A) < 0)
		{
			System.out.println(B);
			System.out.println(A);
		}
		else
		{
			System.out.println(A);
			System.out.println(B);
		}
	}
}
