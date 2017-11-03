package question17;

import java.util.Scanner;

public class Question17 {
	// Write a program that calculates the simple interest on
	// the principal, rate of interest and number of years
	// provided by the user. Enter principal, rate and time
	// through the console using the Scanner class.
	//
	// Interest = Principal * Rate * Time
	public static void main(String[] args) {
		// Initialize a new Scanner to take input from console.
		Scanner scan = new Scanner(System.in);
		
		// Take input from console for principal amount.
		System.out.print("Please enter a principal amount: ");
		double principal = scan.nextDouble();
		
		// Take input from console for rate of interest.
		System.out.print("\nPlease enter an interest rate: ");
		double interest = scan.nextDouble();
		
		// Take input from console for number of years.
		System.out.print("\nPlease enter a number of years: ");
		int years = scan.nextInt();
		
		// Calculate the amount of money gained.
		double amountGained = principal * interest * years;
		
		// Final output.
		System.out.print("\nAfter " + years + " years at an interest rate of " + interest + " you will earn " + amountGained + " in interest.");
	}
}