//Author: Micah West
//Date: 11/01/2017
//Purpose: Create a program that computes N factorial. Solution to Question 4.
//Included files: FactorialLauncher.java
//Input: none
//Output: 10! = 3628800

package com.revature.corejava.Q04;

public class FactorialLauncher {
	
	public static void main(String[] args) {
		
		int n = 10;
		
		System.out.println(n + "! = " + factorial(n));
	}
	
	// Simple recursive formula for computing the factorial of a number.
	public static int factorial(int n)
	{
		if(n < 2)
		{
			return 1;
		}
		else
		{
			return n * factorial(n-1);
		}
	}
}
