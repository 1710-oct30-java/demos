/*
 * Question 17
 * By: Brice Petty
 * Write a program that calculates the simple interest on the principal, rate of interest and number of years provided by the user. 
 * Enter principal, rate and time through the console using the scanner class.
 * Interest = principal * rate * time
 * Credit To:
 */
package com.revature.question17;

import java.util.Scanner;

public class PrincipalRateTime {
	public static void main(String[] args) {	
		System.out.println("Please input the amount of initial principle in Bitcoin!");
		Scanner cIn = new Scanner(System.in);
		double principal = cIn.nextDouble();
		System.out.println("Please input the amount of interest as a decimal");
		double interest = cIn.nextDouble();
		System.out.println("Please input the amount of years you intend to collect interest");
		double years = cIn.nextDouble();
		System.out.println(((principal*interest*years)+principal) + " is your new Bitcoin value!");
		cIn.close();		
	}
}
