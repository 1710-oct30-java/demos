package com.revature.javacore.question17;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/*
 	Write a program that calculates the simple interest on the principal, rate of interest
	and number of years provided by the user. Enter principal, rate, and time through
	the console using the Scanner class.
		Interest = Principal * Rate * Time
 */

public class Question17
{

	public static void main(String[] args)
	{
		menu();
	}

	// Method calculates interest based principal, rate (years), and time (%)
	public static double calculateInterest(double principal, double rate, int time)
	{
		return principal * (rate / 100) * time;
	}

	public static void menu()
	{
		Scanner scanner1 = null;
		Scanner scanner2 = null;
		Scanner scanner3 = null;
		
		try
		{
			// Enter principal amount and save it to a double
			System.out.print("Enter principal: ");
			scanner1 = new Scanner(System.in);
			double principal = scanner1.nextDouble();
			
			// Enter rate in years and save it to a double
			System.out.print("Enter rate (%): ");
			scanner2 = new Scanner(System.in);
			double rate = scanner2.nextDouble();
			
			// Enter time in years
			System.out.print("Enter time (years): ");
			scanner3 = new Scanner(System.in);
			int time = scanner3.nextInt();
			
			// Calculate interest and save it to a double
			double interest = calculateInterest(principal, rate, time);
			
			// Format interest result
			NumberFormat formatter = new DecimalFormat("#0.00");
			
			// Print out interest
			System.out.print("Your interest: $" + formatter.format(interest));
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			scanner1.close();
			scanner2.close();
			scanner3.close();
		}
	}

}
