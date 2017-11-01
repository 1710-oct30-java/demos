package com.question04;

// Q4. Write a program to compute N factorial.

public class Question4
{
	public static void main(String[] args)
	{
		System.out.println(factorial(10));
	}
	
	static int factorial(int n)
	{
		if (n < 1) // prohibit 0 and negative values
		{
			System.err.println(n + " is an invalid input. Please try again.");
			return 0;
		}
		else if (n == 1) // base case
			return n;
		else // general case
			return n * factorial(n - 1);
	}
}
