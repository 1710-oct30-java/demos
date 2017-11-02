package question17;

import java.util.Scanner;

/*
 * Kyle Settles
 * Write a program that calculates the simple interest on the 
 * principal, rate of interest, and number of years provided by 
 * the user. Enter principal, rate and time through the console 
 * using the Scanner class.
 */
public class Question17 {
	
	// create a function that calculates the interest using formula
	public static int calculateInterest(int principal, int rate, int time) {
		return (principal*rate*time);
	}
	
	public static void main(String[] args) {

		// create new scanner to listen to input
		Scanner sc = new Scanner(System.in);
		
		// input of the principal
		System.out.println("Please enter the principal: $");
		int principal = sc.nextInt();
		
		// input of rate
		System.out.println("Please enter the rate: ");
		int rate = sc.nextInt();
		
		// input of number of years
		System.out.println("Please enter number of years: ");
		int time = sc.nextInt();
		
		// print out the interest
		System.out.println("Your interest is: $" + calculateInterest(principal,rate,time));
		
		
	}

}
