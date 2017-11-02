package com.revature.javacore.question3;

/*
 * Reverse a string without using a temporary variable. Do NOT use reverse() in the
	StringBuffer or the StringBuilder APIs.
 * */

public class Question3
{
	
	public static void main(String[] args)
	{
		String s = "Hello world";
		
		// Method to reverse string
		System.out.println(reverseString(s));
	}
	
	public static String reverseString(String s)
	{
		// Append to original string
		for(int i = s.length()-1; i >= 0; i--)
		{
			s += s.charAt(i);
		}
		
		// Return substring of string that was appended, located at middle of string
		return s.substring( ( s.length()/2) );
	}

}
