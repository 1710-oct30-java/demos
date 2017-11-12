package com.revature.question7;

public class Employee {
	private int age;
	private String name;
	private String department;
	
	public Employee(int age, String name, String department) {
		super();
		this.setAge(age);
		this.setName(name);
		this.department = department;
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}