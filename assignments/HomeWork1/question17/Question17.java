package question17;

import java.util.Scanner;

/*
 * Write a program that calculates the simple interest on the principle, rate of interest
 * and number of years provided by the user.  Enter principal, rate, and time through the
 * console using the Scanner class.
 */
public class Question17 {
	public static void main(String[] args) {
		//make a scanner to read from stdin
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter principal");
		//read principal from stdin
		double principal = scanner.nextDouble();
		System.out.println("Please Enter rate");
		//read rate from stdin
		double rate = scanner.nextDouble();
		System.out.println("Please Enter time");
		//read time from stdin
		double time = scanner.nextDouble();
		//method for the sake of not having everything in main
		double interest = findInterest(principal,rate,time);
		//close scanner to prevent memory leaks
		scanner.close();
		
		System.out.println("Your interest is: " + interest);
	}
	private static double findInterest(double principal, double rate, double time)
	{
		//return interest
		return principal * rate * time;
	}

}
