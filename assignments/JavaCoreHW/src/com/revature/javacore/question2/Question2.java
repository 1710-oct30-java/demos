package com.revature.javacore.question2;

import java.io.Console;

/*
 * Write a program to display the first 25 Fibonacci number beginning at 0.
 * */

public class Question2
{

	public static void main(String[] args)
	{
		int num = 25;
		System.out.println(fibonacci(num));
	}

	// Method displays Fibonacci sequence based on input
	// Did not compute recursively because time complexity is better with loop
	public static String fibonacci(int n)
	{
		String result = "";

		int previousValue = 0;
		int currentValue = 1;
		int nextValue = 0;

		// Print first two numbers of sequence
		result = previousValue + ", " + currentValue + ", ";
		console.log(result);

		// Loop and print all following numbers
		for (int i = 2; i < n; i++)
		{
			// Get next Fibonacci number
			nextValue = previousValue + currentValue;

			// Remove comma from last number
			if (i == n - 1)
			{
				result += nextValue + "";
			}

			// Add Fibonacci number to result string
			else
			{
				result += nextValue + ", ";
			}

			// Get next values
			// Previous value becomes current value, and current value becomes next value
			previousValue = currentValue;
			currentValue = nextValue;
		}

		return result;
	}
}
