/*
 * Question 14
 * Write a program that demonstrates the switch case. Implement the following functionalities in the cases:
 * Case 1: Find the square root of a number using the Math class method.
 * Case 2: Display today's date.
 * Case 3: Split the following string and store it in a string array. 
 * 		"I am learning Core Java"
 * By: Brice Petty
 * Credit To:
 */
package com.revature.question14;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class SwitchCase {
	private static void switchCaseMethod(int inputInteger) {
		switch (inputInteger) {
			case 1: {
				double squareRoot = Math.sqrt(9999999);
				System.out.println("Square Root of 9999999: " + squareRoot);
				break;
			}
	
			case 2: {
				Date outputDate = Calendar.getInstance().getTime();
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				System.out.println(dateFormat.format(outputDate));
				break;
			}
	
			case 3: {
				String inputString = "I am learning core java";
				String inputSplit[] = inputString.split(" ");
				System.out.println(inputString + " is now: " + Arrays.toString(inputSplit));
				break;
			}
		}
	}

	public static void main(String[] args) {
		Scanner inputScan = new Scanner(System.in);
		System.out.println("Please enter an integer case number to check! (1, 2 or 3): ");
		int inputInteger = 0;
		
		try {
			inputInteger = inputScan.nextInt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //just for funsies. Auto generate with Eclipse's "surround with" under try-catch
		
		switchCaseMethod(inputInteger);
		inputScan.close();
	}
}