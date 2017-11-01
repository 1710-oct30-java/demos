//Author: Micah West
//Date: 10/31/2017
//Purpose: Calculate the minimum value between two numbers using ternary operators. Solution to Question 10.
//Included files: TernaryOperator.java
//Input: none
//Output: 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, ...

package com.revature.corejava.Q10;

public class TernaryOperator {
	
	public static void main(String[] args) {
		
		int val1 = 8;
		int val2 = 12;
		
		// Calculate the minimum value of two values using the ternary operator.
		int minVal = ((val1 < val2) ? val1 : val2);
		
		System.out.println("Minimum value of " + val1 + " and " + val2 + " is " + minVal);
	}
}
