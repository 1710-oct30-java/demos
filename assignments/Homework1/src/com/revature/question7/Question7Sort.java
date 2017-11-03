package com.revature.question7;

import java.util.Comparator;

/*
 * Name sort of Employee
 */

public class Question7Sort implements Comparator<Question7Employee> {

	@Override
	public int compare(Question7Employee o1, Question7Employee o2) {
		return o1.name.compareTo(o2.name);
		
	}
	

}
