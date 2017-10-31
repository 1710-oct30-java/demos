package com.revature.javacore.question5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Write a program to determine if an integer is even without using the modulus operator (%)
 */

public class Question6 {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 5;
		int num3 = 0;
		int num4 = 1546;
		int num5 = 1547;
		
		isEven(num1);
		isEven(num2);
		isEven(num3);
		isEven(num4);
		isEven(num5);
	}
	
	// Method checks if number is even or odd
	// Converts integer to string and uses regular expression to evaluate
	public static void isEven(int n)
	{
		try {
			String str = Integer.toString(n);
			String regex = "[02468]$";
			
			// Create pattern object
			Pattern pattern = Pattern.compile(regex);
			
			// Create matcher object
			Matcher matcher = pattern.matcher(str);
			
			// Number is even if string ends with 0,2,4,6, or 8
			if(matcher.find())
			{
				System.out.println(n + " - Number is even!");
			}
			else
			{
				System.out.println(n + " - Number is odd!");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
