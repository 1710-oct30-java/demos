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
		int result = 1;
		
		for (int i = 1; i <= n; i++)
		{
			result *= i;
		}
		
		System.out.println(n + "! = " + result);
	}

}
