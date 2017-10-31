package com.revature.javacore.question3;

/*
 * Reverse a string without using a temporary variable. Do NOT use reverse() in the
	StringBuffer or the StringBuilder APIs.
 * */

public class Question3
{

	public static void main(String[] args)
	{
		String s = "Hello";
		System.out.println(reverseString(s));
	}
	
	// Method returns the reverse string of input
	public static String reverseString(String s)
	{
		String reversed = "";
		
		// Loop backwards to reverse string
		for(int i = s.length()-1; i >= 0; i--)
		{
			reversed += s.charAt(i);
		}
		
		return reversed;
	}

}
