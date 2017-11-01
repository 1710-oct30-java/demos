package com.question02;

// Q2. Write a program to display the first 25 Fibonacci numbers starting at 0.

public class Question2
{
	public static void main(String[] args)
	{
		spitFibs(25);
	}
	
	static void spitFibs(long max)
	{
		// Prevent going over max long value
		if (max > 92)
			return;
		
		// Declare the first two fibonacci numbers
		long fib1 = 0;
		long fib2 = 1;
		System.out.println(fib1);
		System.out.println(fib2);
		
		// Calculate new fibonacci numbers
		for (int i = 2; i < max; i++)
		{
			long newFib = fib1 + fib2;
			fib1 = fib2;
			System.out.println(newFib);
			fib2 = newFib;
		}
	}
}
