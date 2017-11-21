//Author: Micah West
//Date: 10/31/2017
//Purpose: Implement the methods created by the CalculatorInterface. Part of the solution to Question 15.
//Included files: CalculatorInterface.java, Calculator.java, CalculatorLauncher.java
//Input: none
//Output: none

package com.revature.corejava.Q15;

public class Calculator implements CalculatorInterface {
	
	@Override
	public double add(double x, double y) {
		return x + y;
	}

	@Override
	public double subtract(double x, double y) {
		return x - y;
	}

	@Override
	public double multiply(double x, double y) {
		return x * y;
	}

	@Override
	public double divide(double x, double y) {
		return x / y;
	}

}
