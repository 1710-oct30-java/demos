//Author: Micah West
//Date: 11/01/2017
//Purpose: Without using mod, determine if an integer is even. Solution to Question 6.
//Included files: DivisibleByTwo.java
//Input: none
//Output: Is 5 even? false
//		  Is 8 even? true

package com.revature.corejava.Q06;

public class DivisibleByTwo {
	
	public static void main(String[] args) {
		
		int num1 = 5;
		int num2 = 8;
		
		System.out.println("Is " + num1 + " even? " + isEven(num1));
		System.out.println("Is " + num2 + " even? " + isEven(num2));
	}
	
	public static boolean isEven(int input) {
		
		// Because ints truncate for uneven division, divide by 2 and then multiply by 2.
		// If the resulting number is not equivalent to the original number, then the number
		// was not even.
		return (input / 2 * 2) == input;
	}
}
