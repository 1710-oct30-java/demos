//Author: Micah West
//Date: 10/31/2017
//Purpose: Calculates simple interest based on user input from the console. Solution to Question 17.
//Included files: SimpleInterest.java
//Input: 20000
//		 0.2
//		 10
//Output: 40000.0
//Example run:
//	Enter the principal: 20000
//	Enter the interest rate: 0.2
//	Enter the time: 10
//	Calculated interest: 40000.0

package com.revature.corejava.Q17;

import java.util.Scanner;

public class SimpleInterest {
	
	public static void main(String[] args) {
		
		// Define the scanner and interest variables.
		
		Scanner consoleIn = new Scanner(System.in);
		double principal, rate, time;
		
		// Receive the values from the user.
		System.out.println("This program will calculate interest based on a principal, interest rate, and an amount of time.");
		System.out.print("Enter the principal: ");
		
		principal = consoleIn.nextDouble();
		
		System.out.print("Enter the interest rate: ");
		rate = consoleIn.nextDouble();
		
		System.out.print("Enter the time: ");
		time = consoleIn.nextDouble();
		consoleIn.close();
		
		// Print the result of the simple interest calculation.
		System.out.println("Calculated interest: " + (principal * rate * time));
		
	}
}
