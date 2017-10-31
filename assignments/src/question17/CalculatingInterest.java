package question17;

import java.util.Scanner;

/**
 * Write a program that calculates the simple interest on the principal, rate of interest
 * ad number of years provided by the user. Enter principal, rate and time through the 
 * console using the Scanner class.
 * @author Mitch Goshorn
 *
 */
public class CalculatingInterest {

	private static String inputPrincipal = "Insert the principal.";
	private static String inputRate 	 = "Insert the interest rate";
	private static String inputTime		 = "Insert years of accrual.";
	private static String inputError 	 = "Input formatted incorrectly. ";
	private static String outputFormat 	 = "Interest: %.4f%n";
	
	/**
	 * Handles getting input values from the user
	 * @param requestInputString - String used to ask for value
	 * @param scanner - Scanner instance
	 * @return input value
	 */
	private static double getInputValue(String requestInputString, Scanner scanner) {
		System.out.println(requestInputString);
		while(!scanner.hasNextDouble()) {
			scanner.next();
			System.out.println(inputError + requestInputString);
		}
		return scanner.nextDouble();
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double interest;
		
		double principal = getInputValue(inputPrincipal, scanner);
		double rate = getInputValue(inputRate, scanner);;
		double time = getInputValue(inputTime, scanner);;
		
		interest = principal * rate * time;
		
		System.out.printf(outputFormat, interest);
	}
	
}
