//Author: Micah West
//Date: 11/01/2017
//Purpose: Defines a basic employee class. Part of the solution to Number 7.
//Included files: EmployeeLauncher.java, Employee.java, EmployeeComparator.java
//Input: none
//Output: none

package com.revature.corejava.Q07;

public class Employee {

	private String name;
	private String department;
	private int age;
	
	
	public Employee(String name, String department, int age) {
		
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}

	public String getName() {
		
		return name;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public String getDepartment() {
		
		return department;
	}
	
	public void setDepartment(String department) {
		
		this.department = department;
	}
	
	public int getAge() {
		
		return age;
	}
	
	public void setAge(int age) {
		
		this.age = age;
	}

	@Override
	public String toString() {
		
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
}
