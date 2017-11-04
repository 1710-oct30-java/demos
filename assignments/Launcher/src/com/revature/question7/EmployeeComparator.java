package com.revature.question7;

import java.util.Comparator;

public class EmployeeComparator implements Comparator {

	@Override
	public int compare(Employees e1, Employees e2) {
		// TODO Auto-generated method stub
		return e1.getName().compareTo(e2.getName())+
				e1.getDepartment().compareTo(e2.getDepartment())+
				e1.getAge()-e2.getAge();
	}
	
	
}
