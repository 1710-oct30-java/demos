package com.revature.question7;

import java.util.Comparator;

public class Question7DepartmentSort implements Comparator<Question7Employee> {

	@Override
	public int compare(Question7Employee o1, Question7Employee o2) {
		return o1.department.compareTo(o2.department);
	}

}
