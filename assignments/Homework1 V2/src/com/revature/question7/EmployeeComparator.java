/*
 * Question 7
 * Sort two employees based on their name, department, and age using the Comparator interface
 * By: Brice Petty
 * Credit To:
 */
package com.revature.question7;

import java.util.Arrays;
import com.revature.question7.Employee;
import com.revature.question7.TheComparator;

public class EmployeeComparator {
	public static void main(String[] args) {
		Employee aryEmployee[] = {new Employee(25, "Brice", "Revature Trainee"), new Employee(22, "Micah", "Revature Trainee")};
		TheComparator comparator = new TheComparator();
		System.out.println("Employees to sort " + Arrays.toString(aryEmployee));
		Arrays.sort(aryEmployee, comparator);
		System.out.println("Sorted Empoyees: " + Arrays.toString(aryEmployee));
	} //Instantiate two new Employee objects into an array. Call Array.sort() method on the array of employees using the instantiated comparator 
}