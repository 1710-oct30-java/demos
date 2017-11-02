package com.revature.javacore.question4;

/*
 * Write a program to compute N factorial
 * */

public class Question4
{

	public static void main(String[] args)
	{
		int num1 = 4;
		int num2 = 7;
		
		computeFactorial(num1);
		computeFactorial(num2);
	}
	
	// Method computes N factorial based on input
	public static void computeFactorial(int n)
	{
		// Start result at 1 so you won;t get zero when you multiply initially
		int result = 1;
		
		// Loop backwards until i is greater than 1 and get result
		for (int i = n; i > 1; i--)
		{
			result *= i;
		}
		
		// Display result
		System.out.println(n + "! = " + result);
	}

}
