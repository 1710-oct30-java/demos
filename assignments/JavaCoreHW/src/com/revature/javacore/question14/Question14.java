package com.revature.javacore.question14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 	Write a program that demonstrates the switch case. Implement the following 
	functionalities in the cases:
		Case 1: Find the square root of a number using the Math class method.
		Case 2: Display today's date.
		Case 3: Split the following string and store it in a string array
			"I am learning Core Java"
 */

public class Question14 {

	public static void main(String[] args) {
		
		String menu = "1) Square root of a number\n"
					+ "2) Display today's date\n"
					+ "3) Split string and store it in a string array\n";
		
		System.out.println(menu);
		
		try {
			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();

			// Switch for selecting option
			switch (num) 
			{
				case 1:
					squareRoot();
					break;
				case 2:
					displayTodaysDate();
					break;
		
				case 3:
					splitString();
					break;
		
				default:
					System.out.println("Invalid input!");
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Case 1: Find the square root of a number using the Math class method.
	public static void squareRoot()
	{
		Scanner input = new Scanner(System.in);
		try {
			System.out.print("Please input a number: ");
			int inputNum = input.nextInt();
			System.out.println("sqrt(" + inputNum + ") = " + Math.sqrt(inputNum));
		} catch (Exception e) {
			
		}
	}
	
	// Case 2: Display today's date.
	public static void displayTodaysDate()
	{
		DateFormat dateFormatter = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
		Date date = new Date();
		System.out.println(dateFormatter.format(date));
		
	}
	
	//Case 3: Split the following string and store it in a string array
	//"I am learning Core Java"
	public static void splitString()
	{
		String str = "I am learning Core Java";
		
		// Split string and stores values in array
		String strArray[] = str.split(" ");
		
		// Display values inside array
		for (int i = 0; i < strArray.length; i++)
		{
			System.out.println("array[" + i + "]: " + strArray[i]);
		}
	}

}
