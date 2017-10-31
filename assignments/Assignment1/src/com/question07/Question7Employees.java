package com.question07;
import java.util.Comparator;


public class Question7Employees
{
	private String name;
	private String department;
	private int age;
	
	public Question7Employees()
	{
		
	}
	public Question7Employees(String name, String department, int age)
	{
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDepartment()
	{
		return department;
	}

	public void setDepartment(String department)
	{
		this.department = department;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}
	
	
}
