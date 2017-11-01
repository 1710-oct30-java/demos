//Author: Micah West
//Date: 10/31/2017
//Purpose: Implement the methods created by the CalculatorInterface. Part of the solution to Question 15.
//Included files: CalculatorInterface.java, Calculator.java, CalculatorLauncher.java
//Input: none
//Output: Numbers 5.0 and 10.0
//		  Addition: 15.0
//		  Subtraction: -5.0
//		  Multiplication: 50.0
//		  Division: 0.5

package com.revature.corejava.Q15;

public class CalculatorLauncher {
	
	public static void main(String[] args) {
		
		// Instantiate the object calculator so its methods can be called.
		Calculator calc = new Calculator();
		
		double value1 = 5;
		double value2 = 10;
		
		// Print the outputs of all the functions from Calculator.
		System.out.println("Numbers " + value1 + " and " + value2);
		System.out.println("Addition: " + calc.add(value1, value2));
		System.out.println("Subtraction: " + calc.subtract(value1, value2));
		System.out.println("Multiplication: " + calc.multiply(value1, value2));
		System.out.println("Division: " + calc.divide(value1, value2));
	}
}
