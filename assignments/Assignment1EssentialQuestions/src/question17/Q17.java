package question17;

import java.util.Scanner;

/***
 * Write a program that calculates the simple interest on the principal, rate of
 * interest and number of years provided by the user. Enter principal, rate and
 * time through the console using the Scanner class. Interest =
 * Principal*Rate*Time
 */
public class Q17 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Please enter the principal amount");

		int principal = scan.nextInt();

		System.out.println("Please enter the rate of interest");

		int rate = scan.nextInt();

		System.out.println("Please enter the number of years");

		int years = scan.nextInt();

		System.out.println("Total Interest: "+ "$"+calculateInterest(principal, rate, years));

	}

	private static int calculateInterest(int principal, int rate, int years) {
		
		int result = (principal * rate * years)/100;
		
		return result;
	}

}
