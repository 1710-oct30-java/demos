package com.revature.question15;

/*
 * Program that defines an interface having the following methods
 * addition, subtraction, multiplication, division
 * Create class that implements the interface and provides appropriate functionality
 * to carry out required operations
 * Hard code two operands in a test class having a main method that calls implementing class
 */
public class Question15 {

	public static void main(String[] args) {
		
		
		int a = 6;
		int b = 2;
		
		Question15Functionality go = new Question15Functionality();
		
		System.out.println(a + " + " + b + " = " + go.addition(a, b));
		System.out.println(a + " - " + b + " = " + go.subtraction(a, b));
		System.out.println(a + " * " + b + " = " + go.multiplication(a, b));
		System.out.println(a + " / " + b + " = " + go.division(a, b));

	}

}
