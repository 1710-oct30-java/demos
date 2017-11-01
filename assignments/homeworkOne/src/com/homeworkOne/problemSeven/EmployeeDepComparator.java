package com.homeworkOne.problemSeven;

import java.util.Comparator;

public class EmployeeDepComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getDepartment().compareTo(e2.getDepartment());
	}

}
