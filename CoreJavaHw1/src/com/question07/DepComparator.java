package com.question07;

import java.util.Comparator;

public class DepComparator implements Comparator
{
	@Override
	public int compare(Object emp1, Object emp2)
	{
		Employee e1 = (Employee) emp1;
		Employee e2 = (Employee) emp2;
		
		return e1.getDep().compareTo(e2.getDep());
	}
	
}
