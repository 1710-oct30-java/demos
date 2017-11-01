package com.q07;

// INCOMPLETE: I'm supposed to use the Comparator interface.
// Sort two employees based on their name, department, and age using the Comparator interface.

public class Question7
{
	public static void main(String[] args)
	{
		Employee john = new Employee("John", "Sales", 27);
		Employee mark = new Employee("Mark", "Acq", 36);
		Employee carlos = new Employee("Carlos", "Admin", 39);
		Employee chris = new Employee("Chris", "IT", 25);
		
		System.out.println(compareAge(mark, chris));
	}
	
	public static int compareName(Employee a, Employee b)
	{
		return a.getName().compareTo(b.getName());
	}
	
	public static int compareDep(Employee a, Employee b)
	{
		return a.getDepartment().compareTo(b.getDepartment());
	}
	
	public static int compareAge(Employee a, Employee b)
	{
		return a.getAge() - b.getAge();
	}
}
