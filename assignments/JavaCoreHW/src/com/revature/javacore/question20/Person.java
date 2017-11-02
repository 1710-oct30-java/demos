package com.revature.javacore.question20;

public class Person
{
	private String firstName;
	private String lastName;
	private int age;
	private String state;
	
	public Person()
	{
		
	}
	
	public Person(String firstName, String lastName, int age, String state)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.state = state;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	// Displays the person data in correct format
	@Override
	public String toString()
	{
		return "Name: " + firstName + " " + lastName + "\nAge: " + age + "\nState: " + state + "\n";
	}
	
	
	
}
