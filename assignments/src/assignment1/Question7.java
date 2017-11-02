package assignment1;

import java.util.Comparator;

public class Question7
{
	// Sort two employees based on their name, department and age using the Comparator interface.
	public static void main(String[] args)
	{
		EmployeeComparator ec = new EmployeeComparator();
		Employee e1 = new Employee("Dennis", "Doggo Department", 30);
		Employee e2 = new Employee("Marcus", "Catten Department", 26);
		
		System.out.println(ec.compare(e1, e2));
	}
	
	static class Employee
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

	static class EmployeeComparator implements Comparator<Object>
	{
		// This method overrides the compare method from the Comparator interface. It compares two Employee
		// Objects based on name, then department, then age.
		@Override
		public int compare(Object o1, Object o2)
		{
			Employee e1 = (Employee) o1;
			Employee e2 = (Employee) o2;
			
			if(e1.name.compareTo(e2.name) != 0)
			{
				return e1.name.compareTo(e2.name);
			}
			if(e1.department.compareTo(e2.department) != 0)
			{
				return e1.department.compareTo(e2.department);
			}
			if(e1.age != e2.age)
			{
				if(e1.age < e2.age)
				{
					return -1;
				}
				if(e1.age > e2.age)
				{
					return 1;
				}
			}
			return 0;
		}
	}
}