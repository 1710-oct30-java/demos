package assignments.week01.question17;

import java.util.Scanner;

public class Question17 
{
	public static void main(String[] args) 
	{
		InterestCalculator calc = new InterestCalculator();
		Scanner sc = new Scanner(System.in);
		Double principal;
		Double rate;
		Integer time;
		
		System.out.print("Enter the principal amount: ");
		principal = readDouble( sc.nextLine() );
		
		System.out.print("Enter the interest ratio: ");
		rate = readDouble( sc.nextLine() );
		
		System.out.print("Enter the term length in whole years: ");
		time = readInteger( sc.nextLine() );
		
		sc.close();
		
		System.out.println( String.format("The simple interest amount is: $ %.2f", 
			calc.calculate(principal, rate, time)
		));		
	}
	
	/**
	 * translate a String into a Double value
	 * 
	 * @param String input
	 * 
	 * @return Double
	 */
	public static Double readDouble(String input)
	{
		Double output = 0.0;
		
		try {
			output = Double.parseDouble( input );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return output;
	}
	
	/**
	 * translate a String into an Integer value
	 * 
	 * @param String input
	 * 
	 * @return Integer
	 */
	public static Integer readInteger(String input)
	{
		Integer output = 0;
		
		try {
			output = Integer.parseInt( input );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return output;
	}
}
