package com.revature.homework.question7;

import java.util.Comparator;

public class Question7DeptSorter implements Comparator<Employee> {
	
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getDepartment().compareTo(o2.getDepartment());
	}
	
}
