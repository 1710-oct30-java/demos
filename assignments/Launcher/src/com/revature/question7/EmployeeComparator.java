package com.revature.question7;

import java.util.Comparator;

public class EmployeeComparator implements Comparator {

	// Calculate the difference between the letter values
	// in the names of the employee name and department,
	// and between the ages of two employees
	@Override
	public int compare(Employees e1, Employees e2) {
		 return e1.getName().compareTo(e2.getName())+
				e1.getDepartment().compareTo(e2.getDepartment())+
				e1.getAge()-e2.getAge();
	}
	
}
