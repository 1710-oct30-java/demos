package com.question03;

/*
 * reverse string without using temp variable
 */
public class Question3
{
	public static void main(String[] args)
	{
		String myString = "Revature Tampa";
		int length = myString.length();
		
		for (int i = length-1; i >= 0; i--)
		{
			myString = myString + myString.charAt(i);
		}
		
		myString = myString.substring(length);
	}
}
