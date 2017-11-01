// Christopher Youngblood
// 10/30/2017
// Revature Java Course
// Homework 1 - Question 5

package com.revature.javahw.q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Q7. Sort Two employees based on their name, department, and
//     age using the comparator interface

public class Q7 {
	
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();
		
		employees.add(new Employee("Jason Todd", "Security", 22));
		employees.add(new Employee("Ashoka Tano", "Recruiting", 24));
		
		System.out.println("Orginal: " + employees);
		
		Collections.sort(employees, new sortByName());	
		System.out.println("Sort by Name: " + employees);
		
		Collections.sort(employees, new sortByDepartment());	
		System.out.println("Sort by Department: " + employees);
		
		Collections.sort(employees, new sortByAge());	
		System.out.println("Sort by Age: " + employees);
		}

}
