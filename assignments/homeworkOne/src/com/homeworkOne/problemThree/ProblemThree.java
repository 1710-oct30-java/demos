package com.homeworkOne.problemThree;

public class ProblemThree {
	public static void main(String[] args) 
	{
		
		String reverse = "reverse";
		char[] reversal = reverse.toCharArray();

		for (int i = reversal.length - 1; i >= 0; i--) 
		{
			System.out.println(reversal[i]);
		}
	}

}
