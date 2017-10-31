package com.homeworkOne.problemTwo;

public class ProblemTwo {
	//write a program to display the first 25 fib numbers
	public static void main(String[] args)
	{
		//init variables
		int fibNumber = 26;
		
		//loop for calculation
		for(int i = 0; i<fibNumber;i++)
		{
			System.out.print(fib(i) +" ");
		}
		
	}	
	//method for fib
	public static int fib(int fibNumber)
	{
		if( fibNumber == 0 || fibNumber == 1)//checks for first 2 elements
			return fibNumber;
		else
			return fib(fibNumber-1) + fib(fibNumber-2);
			
	}

}
