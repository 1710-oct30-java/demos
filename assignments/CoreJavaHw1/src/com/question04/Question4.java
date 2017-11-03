package com.question04;

// Q4. Write a program to compute N factorial.

public class Question4
{
	public static void main(String[] args)
	{
		System.out.println(factorial(3));
	}
	
	// recursive factorial method
	static long factorial(int n)
	{
		if (n == 1) // base case
			return n;
		else if (n > 1) // general case
			return n * factorial(n - 1);
		else // prohibit 0 and negative values
		{
			System.err.println(n + " is an invalid input.");
			return 0;
		}
	}
}
