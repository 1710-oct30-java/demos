package com.question07;

import java.util.Comparator;

public class EmployeeComparator implements Comparator
{
	
	@Override
	public int compare(Object emp1, Object emp2)
	{
		Employee e1 = (Employee) emp1;
		Employee e2 = (Employee) emp2;
		
		// Compare names
		int difference = e1.getName().compareTo(e2.getName());
		if (difference == 0)
		{
			// Compare departments
			difference = e1.getDep().compareTo(e2.getDep());
			
			if (difference == 0)
			{
				// Compare ages
				difference = e1.getAge() - e2.getAge();
			}
		}
		// return difference;
		return Integer.signum(difference);
	}
	
}
