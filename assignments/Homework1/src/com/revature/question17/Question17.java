package com.revature.question17;

import java.util.Scanner;

/* 
 * Write a program that calculates the simple interest on the principal
 * rate of interest, and # of years provided by the user
 * Enter principal, rate, and time through the console using the Scanner class
 * 			Interest = Principal * Rate * Time
 */
public class Question17 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner (System.in);
		System.out.println("Enter principal: ");
		int principal = scanner.nextInt();
		
		System.out.println("Enter rate of interest: ");
		int rate = scanner.nextInt();
		
		System.out.println("Enter the amount of years: ");
		int time = scanner.nextInt();
		
		int interest = principal * rate * time;
		System.out.println("The interest is: " + interest);
	}

}
