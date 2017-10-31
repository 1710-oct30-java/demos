package com.homeworkOne.problemFour;

import java.util.Scanner;

public class ProblemFour 
{
	// Compute Factorial of N 
	public static void main(String[] args) 
	{
		
		Scanner input = new Scanner(System.in); 
		// Reading from User Input
		System.out.println("Enter a number: ");
		int number = input.nextInt();
		int numberFactorial = 1;

		//Perform Operation
		for (int i = number; i > 0; i--) 
		{
			numberFactorial *= i;
		}
		
		//Print result
		System.out.println("The factorial of " + number + " is " + numberFactorial);
	}
}
