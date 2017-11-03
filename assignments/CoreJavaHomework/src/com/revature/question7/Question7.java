package com.revature.question7;

import java.util.Arrays;

/*
 * Sort two employees based on their name, department, and age
 * using the Comparator interface
 */

public class Question7 {

	public static void main(String[] args) {

		// Create two employees
		Employee employeeOne = new Employee("John Smith", "sales", 32);
		Employee employeeTwo = new Employee("Sarah Adams", "finance", 27);
		
		//add them to an array
		Employee[] empArray = new Employee[2];
		empArray[0] = employeeOne;
		empArray[1] = employeeTwo;
		
		//sort by name
		Arrays.sort(empArray, new EmployeeNameComparator());
		System.out.println("Sorted by name: " + Arrays.toString(empArray));
		
		//sort by department
		Arrays.sort(empArray, new EmployeeDepartmentComparator());
		System.out.println("Sorted by department: " + Arrays.toString(empArray));
		
		//sort by age
		Arrays.sort(empArray, new EmployeeAgeComparator());
		System.out.println("Sorted by age: " + Arrays.toString(empArray));
		
	}

}
