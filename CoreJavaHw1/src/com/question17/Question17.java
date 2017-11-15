package com.question17;

import java.util.Scanner;

/* Q17. Write a program that calculates the simple interest on the principal,
 * rate of interest and number of years provided by the user. Enter principal,
 * rate and time through the console using the Scanner class.
*/

public class Question17
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter the initial principle: ");
		double principal = scan.nextDouble();
		System.out.println("Enter the interest rate as a decimal:\n(.05 represents 5% interest) ");
		double rate = scan.nextDouble();
		System.out.println("Enter the number of time periods since loan began: ");
		double time = scan.nextDouble();
		
		System.out.println("The simple interest is " + simpInterest(principal, rate, time));
	}
	
	private static double simpInterest(double p, double r, double t)
	{
		return p * r * t;
	}
}
