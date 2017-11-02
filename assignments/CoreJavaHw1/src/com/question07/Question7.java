package com.question07;

// Sort two employees based on their name, department, and age using the Comparator interface.

public class Question7
{
	public static void main(String[] args)
	{
		Employee john = new Employee("John", "Sales", 27);
		Employee mark = new Employee("Mark", "Acq", 36);
		Employee carlos = new Employee("Carlos", "Admin", 39);
		Employee chris = new Employee("Chris", "IT", 25);
		
		EmployeeComparator ec = new EmployeeComparator();
		
		Employee[] staff = new Employee[] { john, mark, carlos, chris };
		
		for (int i = 0; i < staff.length; i++)
		{
			for (int j = 0; j < staff.length; j++)
			{
				int diff = ec.compare(staff[i], staff[j]);
				System.out.println(staff[i].getName() + " vs. " + staff[j].getName() + ": " + diff);
			}
			System.out.println();
		}
	}
}
