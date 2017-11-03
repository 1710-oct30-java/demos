package question17;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q17 {

	/*
	 * Write a program that calculates the simple interest on the principal, rate of
	 * interest and number of years provided by the user. Enter principal, rate, and
	 * time through the console using the Scanner class.
	 * Interest = Principal * Rate * Time
	 */

	public static void main(String[] args) {
			
		double principal = TakeDoubleInput("Please enter principal: ");
		double rate = TakeDoubleInput("Please enter rate: ");
		double time = TakeDoubleInput("Please enter time: ");
		
		System.out.println("Interest = $" + principal * rate * time);
			
	}
	
	public static double TakeDoubleInput(String message) {
		boolean acceptableInput = false;
		double value = 0;
		
		Scanner scan = new Scanner(System.in);
		//A message is given to prompt the user for input.
		
		
		//Continue looping until a valid number is given.
		do {
			try {
				System.out.println(message);
				value = scan.nextDouble();
				acceptableInput = true;
				
			} catch (InputMismatchException e) {
				System.out.println("Invalid value.");
				acceptableInput = false;
			}
			//Clear the scanner.
			scan.nextLine();
			
		} while (!acceptableInput);
		
		
		return value;
	}

}
