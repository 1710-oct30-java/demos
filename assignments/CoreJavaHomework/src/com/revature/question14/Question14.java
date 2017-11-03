package com.revature.question14;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/*
 * Write a program that demonstrates the switch case. Implement
 * the following functionalities in the cases:
 * 
 * case 1: find the square root of a number using the Math class method
 * 
 * case 2: Display today's date
 * 
 * case 3: Split the following string and store it in a string array
 *  "I am learning Core Java"
 */
public class Question14 {

	public static void main(String[] args) {
		switchMethod(1);
		switchMethod(2);
		switchMethod(3);
		switchMethod(5);
	}

	public static void switchMethod(int option) {
		switch (option) {
		//case 1: find the square root of a number using the Math class method
		case 1:
			double squareRootOfNum = Math.sqrt(4);
			System.out.println("The square root of 4 is: " + squareRootOfNum);
			break;
			
		//case 2: Display today's date
		case 2:
			System.out.println(Calendar.getInstance().getTime());
			break;
		
		/*Split the following string and store it in a string array
		 *  "I am learning Core Java"*/
		case 3:
			String str = "I am learning Core Java";
			String[] arr = str.split(" ", 5);
			System.out.println(Arrays.toString(arr));
			break;

		default:
			System.out.println("Not an option");
			break;
		}
	}

}
