package com.revature.javacore.question15;

/*
	Write a program that defines an interface having the following methods: addition,
	subtraction, multiplication, and division. Create a class that implements this interface
	and provides appropriate functionality to carry out the required operations. Hard code
	two operands in a test class having a main method that calls the implementing class.
 */

public class Question15
{
	public static void main(String[] args)
	{
		Operation op = new Operation();
		
		double num1 = 2.2;
		double num2 = 4;
		
		op.add(num1, num2);
		op.subtract(num1, num2);
		op.multiply(num1, num2);
		op.divide(num1, num2);
		
		System.out.println();
		
		double num3 = 5;
		double num4 = 0;
		
		op.add(num3, num4);
		op.subtract(num3, num4);
		op.multiply(num3, num4);
		op.divide(num3, num4);
	}
}
