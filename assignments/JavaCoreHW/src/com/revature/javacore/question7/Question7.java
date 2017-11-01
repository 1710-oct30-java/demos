package com.revature.javacore.question7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
	Sort two employees based on their name, department, and age without using the 
	Comparator interface.
 */

public class Question7 {

	public static void main(String[] args) {
		// Create two new employees
		Employee emp1 = new Employee("Bruce Wayne", 34, "Bat Cave");
		Employee emp2 = new Employee("Barry Allen", 24, "Speed Force");
		
		// Add employees to ArrayList
		List<Employee> employees = new ArrayList<>();
		employees.add(emp1);
		employees.add(emp2);
		
		// Use the Comparator sort from Collections to sort ArrayList
		Collections.sort(employees, new Employee());
		
		// Print sorted list of employees
		for(Employee emp:employees)
		{
			System.out.println(emp);
		}
	}

}
