package com.question15;

/*
 * writing interface and a class implementing addition/subtraction/multiplication/division method
 */
public class Question15
{
	public static void main(String[] args)
	{
		int a = 5;
		int b = 3;
		Question15Math math = new Question15Math();
		
		System.out.println("a + b = "+ a + " + " + b + " = " + math.addition(a, b));
		System.out.println("a - b = "+ a + " - " + b + " = "  + math.subtraction(a, b));
		System.out.println("a * b = "+ a + " * " + b + " = "  + math.multiplication(a, b));
		System.out.println("a / b = "+ a + " / " + b + " = "  + math.division(a, b));
	}
}
