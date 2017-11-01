// Christopher Youngblood
// 11/1/2017
// Revature Java Course
// Homework 1 - Question 20

package com.revature.javahw.q20;

//Q20. Create a notepad file called Data.txt and enter the following:
//Mickey:Mouse:35:Arizona
//Hulk:Hogan:50:Virginia
//Roger:Rabbit:22:California
//Wonder:Woman:18:Montana
//
//Write a program that would read from the file and print
//out to the screen in the following format:
//Name: Mickey Mouse
//Age: 35 years
//State: Arizona State

public class BasicInfo {
	
	private String name;
	private int age;
	private String State;
	public BasicInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BasicInfo(String name, int age, String state) {
		super();
		this.name = name;
		this.age = age;
		State = state;
	}
	@Override
	public String toString() {
		return "\nName: " + name + "\nAge: " + age + "\nState: " + State + "\n";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((State == null) ? 0 : State.hashCode());
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasicInfo other = (BasicInfo) obj;
		if (State == null) {
			if (other.State != null)
				return false;
		} else if (!State.equals(other.State))
			return false;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
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
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	
	

}
