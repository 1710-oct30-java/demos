package com.revature.javacore.question11_one;

/*
	Write a program that would access two float-variables from a class that exists in
	another package. Note, you will need to create two packages that demonstrate
	the solution.
 */

// This package contains getter methods to access the two float fields since they are private

/* 
   These variables can also be accessed from another package if they are public static
   simply by calling this class (i.e Question11.num2)
*/

public class Question11
{
	private float num1 = 5;
	private float num2 = 2;
	
	public float getNum1()
	{
		return num1;
	}
	
	public float getNum2()
	{
		return num2;
	}
}
