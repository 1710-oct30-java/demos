package com.question07;

public class Employee
{
	private String	name;
	private String	department;
	private int		age;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getDep()
	{
		return department;
	}
	
	public void setDep(String department)
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
	
	@Override
	public String toString()
	{
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
	
	public Employee(String name, String department, int age)
	{
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
}