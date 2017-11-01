// Christopher Youngblood
// 10/30/2017
// Revature Java Course
// Homework 1 - Question 4

package com.revature.javahw.q4;

// Q4. Write a program to compute N factorial

public class Q4 {
	public static void main(String[] args) {
	
		//for sake of expediency, I'm skipping however you would input N
		int n = 5;
		int factorial = 1;
		
		for (int i = 1; i <= n; i++) {
			factorial = factorial * i;
		}
		
		System.out.println("The factorial of " + n + " is: " + factorial);
	}
}
