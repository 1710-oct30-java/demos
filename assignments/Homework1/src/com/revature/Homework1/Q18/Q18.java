package com.revature.Homework1.Q18;

public class Q18 {
	//use an abstract parent class; have a child extend it.
	public static void main(String[] args) {
		Child child = new Child();
		String test = "HelloWorld";
		System.out.println(child.uppercaseLettersExist(test));
		System.out.println(child.upperToLower(test));
		child.toIntAdd10(test);
	}
}
