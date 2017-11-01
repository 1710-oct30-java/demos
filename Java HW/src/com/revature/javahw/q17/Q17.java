// Christopher Youngblood
// 11/1/2017
// Revature Java Course
// Homework 1 - Question 17

package com.revature.javahw.q17;

import java.util.Scanner;

// Q17. Write a program that calculates the simple interest on
//		the principal, rate of interest, and number of years
//		provided by the user. Enter principal, rate and time
//		through the console using the Scanner class.
//		Interest = Principal * Rate * Time

public class Q17 {

	public static void main(String[] args) {
		double principal = 0, rate = 0, time = 0;
		Scanner input = new Scanner(System.in);
		
		//User input and conversion
		System.out.println("Enter the principal ammount:");
		principal = Double.parseDouble(input.nextLine());
		
		System.out.println("Enter the rate (in decimal, not percentage):");
		rate = Double.parseDouble(input.nextLine());
		
		System.out.println("Enter the amount of time it has been accruing interest:");
		time = Double.parseDouble(input.nextLine());
		
		double interest = principal * rate * time;
		
		System.out.println("Your total amount of interest: " + interest);
	}
	
}
