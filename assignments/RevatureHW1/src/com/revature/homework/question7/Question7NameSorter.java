package com.revature.homework.question7;

import java.util.Comparator;

// Sort two employees base on their name, dept, and age using the Comparator interface
public class Question7NameSorter implements Comparator<Employee> {
	
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}
	
}
