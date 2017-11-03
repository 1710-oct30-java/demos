package com.revature.javacore.question7;

/*
	Employee class has all the employees info with setters and getters.
	It also implements the Comparator interface.
*/

import java.util.Comparator;

public class Employee implements Comparator<Employee>
{
	private String name;
	private int age;
	private String department;

	public Employee()
	{
		
	}
	
	public Employee(String name, int age, String department)
	{
		this.name = name;
		this.age = age;
		this.department = department;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getDepartment()
	{
		return department;
	}

	public void setDepartment(String department)
	{
		this.department = department;
	}
	
	// Sort first by name, then by age, then by department at the same time
	@Override
	public int compare(Employee e1, Employee e2)
	{
		// Compare names first
		if(e1.getName().compareTo(e2.getName()) > 0)
		{
			return 1;
		}
		
		else if(e1.getName().compareTo(e2.getName()) < 0)
		{
			return -1;
		}
		
		// If names are equal, then compare age
		else if(e1.getName().compareTo(e2.getName()) == 0)
		{
			if(e1.getAge() > e2.getAge())
			{
				return 1;
			}
			
			else if(e1.getAge() < e2.getAge())
			{
				return -1;
			}
			
			// If name and age are equal, then compare department
			else if(e1.getAge() == e2.getAge())
			{
				if(e1.getDepartment().compareTo(e2.getDepartment()) > 0)
				{
					return 1;
				}
				
				else if(e1.getDepartment().compareTo(e2.getDepartment()) < 0)
				{
					return -1;
				}
			}
		}
		
		return 0;
	}
	
	@Override
	public String toString()
	{
		return name + ", " + age + ", " + department;
	}

}