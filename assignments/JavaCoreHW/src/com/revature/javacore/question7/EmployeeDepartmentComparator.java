package com.revature.javacore.question7;

import java.util.Comparator;

public class EmployeeDepartmentComparator implements Comparator<Employee>
{

	@Override
	public int compare(Employee e1, Employee e2)
	{
		if(e1.getDepartment().compareTo(e2.getDepartment()) > 0)
		{
			return 1;
		}
		
		else if(e1.getDepartment().compareTo(e2.getDepartment()) < 0)
		{
			return -1;
		}
		return 0;
	}

}
