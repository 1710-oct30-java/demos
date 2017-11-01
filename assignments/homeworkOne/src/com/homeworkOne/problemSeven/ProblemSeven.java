package com.homeworkOne.problemSeven;

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

//Compare and sort 2 employees by Name, Department, or Age
public class ProblemSeven  {

	public static void main(String[] args) {
		//New List of employees
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee ("Sam", "Sales", 30));
		employees.add(new Employee ("Bob", "Front Desk", 40));
		
		System.out.println("Sorted by Name");
		Collections.sort(employees, new EmployeeNameComparator());
		for(Employee each: employees) {
			System.out.println(each);
		}
		
		System.out.println("Sorted by Department");
		Collections.sort(employees, new EmployeeDepComparator());
		for(Employee each: employees) {
			System.out.println(each);
		}
		
		System.out.println("Sorted by Age");
		Collections.sort(employees, new EmployeeAgeComparator());
		for(Employee each: employees) {
			System.out.println(each);
		}
	}

}
