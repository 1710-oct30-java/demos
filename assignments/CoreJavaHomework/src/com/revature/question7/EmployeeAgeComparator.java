package com.revature.question7;

import java.util.Comparator;

public class EmployeeAgeComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		Integer age1 = o1.getAge();
		Integer age2 = o2.getAge();
		
		return age1.compareTo(age2);
	}
	

}

