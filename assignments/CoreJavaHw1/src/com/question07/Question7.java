package com.question07;

// Sort two employees based on their name, department, and age using the Comparator interface.

public class Question7
{
	public static void main(String[] args)
	{
		Employee john = new Employee("John", "Sales", 27);
		Employee mark = new Employee("Mark", "Sales", 25);
		Employee carlos = new Employee("John", "Admin", 39);
		Employee chris = new Employee("Chris", "IT", 25);
		
		EmployeeComparator ec = new EmployeeComparator();
		
		Employee[] staff = new Employee[] { john, mark, carlos, chris };
		
		// Compare each Employee to each Employee, including itself
		for (int i = 0; i < staff.length; i++)
		{
			for (int j = 0; j < staff.length; j++)
			{
				int diff = ec.compare(staff[i], staff[j]);
				
				// print comparison
				System.out.println(staff[i].getDep() + " " + staff[i].getName() + " vs. "
						+ staff[j].getDep() + " " + staff[j].getName() + ": " + diff);
			}
			System.out.println();
		}
	}
}
