package assignment1;

import java.util.Comparator;

public class Question7 implements Comparator
{
	// Sort two employees based on their name, department and age using the Comparator interface.
	public static void main(String[] args)
	{
		
	}
	
	class Employee
	{
		String name = "";
		String department = "";
		int age = 0;
		
		public Employee()
		{
		}
		
		public Employee(String n, String d, int a)
		{
			this.name = n;
			this.department = d;
			this.age = a;
		}
		
		public String getName()
		{
			return this.name;
		}
		
		public String getDepartment()
		{
			return this.department;
		}
		
		public int getAge()
		{
			return this.age;
		}
		
		public void setName(String n)
		{
			this.name = n;
		}
		
		public void setDepartment(String d)
		{
			this.department = d;
		}
		
		public void setAge(int a)
		{
			this.age = a;
		}
	}
}