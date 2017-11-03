package com.revature.javacore.question7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
	Sort two employees based on their name, department, and age using the 
	Comparator interface.
*/

public class Question7 {

	public static List<Employee> employees = new ArrayList<>();
	
	public static void main(String[] args) {
		// Create two new employees
		Employee emp1 = new Employee("Bruce Wayne", 34, "Bat Cave");
		Employee emp2 = new Employee("Barry Allen", 24, "Speed Force");
		Employee emp3 = new Employee("Kara Danvers", 21, "Krypton");
		Employee emp4 = new Employee("Oliver Queen", 29, "Star City");
		Employee emp5 = new Employee("Robert Downey Jr", 37, "Stark Industries");
		
		// Add employees to ArrayList
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		employees.add(emp5);
		
		// Sort by name, age, and department at the same time
		System.out.println("Sorting by name, age, and department...");
		Collections.sort(employees, new Employee());		
		displayEmployeeList();
		
		// Sort by age
		System.out.println("Sorting by age...");
		Collections.sort(employees, new EmployeeAgeComparator());
		displayEmployeeList();
		
		// Sort by department
		System.out.println("Sorting by department...");
		Collections.sort(employees, new EmployeeDepartmentComparator());
		displayEmployeeList();
	}
	
	// Display list of employees
	public static void displayEmployeeList()
	{
		// Print sorted list of employees
		for(Employee emp:employees)
		{
			System.out.println(emp);
		}
		System.out.println();
	}

}
