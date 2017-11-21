//Author: Micah West
//Date: 11/01/2017
//Purpose: Defines a comparator for the Employee class. Part of the solution to Number 7.
//Included files: EmployeeLauncher.java, Employee.java, EmployeeComparator.java
//Input: none
//Output: none

package com.revature.corejava.Q07;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName()) 
				+ o1.getDepartment().compareTo(o2.getDepartment())
				+ (o1.getAge() - o2.getAge());
	}
}
