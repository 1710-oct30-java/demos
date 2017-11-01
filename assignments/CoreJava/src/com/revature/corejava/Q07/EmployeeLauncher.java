//Author: Micah West
//Date: 11/01/2017
//Purpose: Sort two employees based on name, department, and age. Solution to Question 7.
//Included files: EmployeeLauncher.java, Employee.java, EmployeeComparator.java
//Input: none
//Output: Sorting [Employee [name=John, department=Human Resources, age=35], Employee [name=Alex, department=R&D, age=22]]
//		  Sorted [Employee [name=Alex, department=R&D, age=22], Employee [name=John, department=Human Resources, age=35]]

package com.revature.corejava.Q07;

import java.util.Arrays;

public class EmployeeLauncher {
	
	public static void main(String[] args) {
		
		Employee aryEmployee[] = {new Employee("John", "Human Resources", 35),
								  new Employee("Alex", "R&D", 22)};
		
		EmployeeComparator comparator = new EmployeeComparator();
		
		System.out.println("Sorting " + Arrays.toString(aryEmployee));
		
		Arrays.sort(aryEmployee, comparator);
		
		System.out.println("Sorted " + Arrays.toString(aryEmployee));
		
	}
	
}
