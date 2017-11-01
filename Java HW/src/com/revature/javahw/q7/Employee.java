package com.revature.javahw.q7;

import java.util.Comparator;

public class Employee {
	private String name;
	private String department;
	private int age;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	class sortByAge implements Comparator<Employee> {
		public int compare(Employee a, Employee b) {
			return a.getAge() - b.getAge();
		}
	}
	
	class sortByName implements Comparator<Employee> {
		public int compare(Employee a, Employee b) {
			return a.getName().compareTo(b.getName());
		}
	}

	class sortByDepartment implements Comparator<Employee> {
		public int compare(Employee a, Employee b) {
			return a.getDepartment().compareTo(b.getDepartment());
		}
	}