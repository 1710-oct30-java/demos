// Christopher Youngblood
// 10/30/2017
// Revature Java Course
// Homework 1 - Question 2

package com.revature.javahw.q2;

// Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0

public class Q2 {

	public static void main (String[] args) {
		int f1 = 0;
		int f2 = 1;
		
		// #1&2 of the fibonacci numbers
		System.out.println("Fibonacci #1: " + f1);
		System.out.println("Fibonacci #2: " + f2);
		
		//the other 23
		for (int i = 3; i <= 25; i++) {
			//calculate the next number
			int f3 = f1 + f2;
			
			//fancy debugging/user friendly print statement
			System.out.println("Fibonacci #" + i + ": " +f3);
			
			//update for the next itteration
			f1 = f2;
			f2 = f3;
		}
	}
	
}
