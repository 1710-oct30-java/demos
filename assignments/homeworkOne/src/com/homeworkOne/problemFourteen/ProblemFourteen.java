package com.homeworkOne.problemFourteen;
import java.lang.Math;
import java.util.Date;
import java.util.Scanner;
public class ProblemFourteen {
	
	/*Program to implement switch case
	Case 1: square root of a number using Math class method
	Case 2: Display todays date
	Case 3: Split string and store into a string array "I am learning Java Code*/
	
	public static void main(String[] args) {
		int number = 49;
		Date date = new Date();
		Scanner userInput = new Scanner(System.in); 
		int input = userInput.nextInt();
		// Reading from User Input
		System.out.println("Enter a number: ");
		switch(input) {
		case 1:
			break;
		case 2:
			System.out.println(date.toString());
			break;
		case 3:
			break;
		}
		
		
	}
	
	
	
}
