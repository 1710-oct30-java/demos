package com.revature.question7;

public class Question7Employee {
	
	public String name;
	public String department;
	public int age;
	
	public Question7Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public String toString() {
		return this.name + " " + this.department + " " + this.age;
	}
}
	


