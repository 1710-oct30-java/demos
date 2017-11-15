package com.question10;

// Find the minimum of two numbers using ternary operators.

public class Question10
{
	public static void main(String[] args)
	{
		System.out.println(getMin(52, 16) + " is the minimum.");
	}
	
	static int getMin(int a, int b)
	{
		return (a < b) ? a : b;
	}
}
