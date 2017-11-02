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
		System.out.println("Enter a number: ");
		Scanner userInput = new Scanner(System.in); 
		String phrase = "I am learning Java Code";
		int input = userInput.nextInt();
		// Reading from User Input
		
		switch(input) {
		case 1:
			System.out.println(Math.sqrt(number));
			break;
		case 2:
			System.out.println(date.toString());
			break;
		case 3:
			String[] breakUp = phrase.split(" ");
			for(String each: breakUp)
			{
				System.out.print(each+ " ");
			}
			break;
		}
		
		
	}
	
	
	
}
