package com.question06;

// Q6. Write a program to determine if an integer is even without using the modulus operator (%).

public class Question6
{
	public static void main(String[] args)
	{
		System.out.println(isEven(-2));
	}
	
	static boolean isEven(int i)
	{
		// Divide input by two
		float f = (float) i / 2;
		// Cast float to int
		i = (int) f;
		// Check if value was rounded
		return (i == f);
	}
}
