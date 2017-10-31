package com.homeworkOne.problemThree;

public class ProblemThree {
	//Reverse a string
	public static void main(String[] args) 
	{
		//init string
		String reverse = "reverse";
		
		//convert to char array
		char[] reversal = reverse.toCharArray();
		
		//print out in reverse
		for (int i = reversal.length - 1; i >= 0; i--) 
		{
			System.out.println(reversal[i]);
		}
	}

}
