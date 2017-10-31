package com.homeworkOne.problemFour;

public class ProblemFour 
{

	public static void main(String[] args) 
	{

		int number = 10;
		int numberFactorial = 1;

		for (int i = number; i > 0; i--) 
		{
			numberFactorial *= i;
		}
		System.out.println(numberFactorial);
	}
}
