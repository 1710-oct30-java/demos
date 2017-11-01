package com.revature.javacore.question5;

/*
 	Write a substring method that accepts a string str and an integer idx and returns the
	substring methods in the String, StringBuilder, or St APIs.
 */
public class Question5
{

	public static void main(String[] args)
	{
		String str = "Hello World";

		// Compiles fine
		System.out.println(mySubstring(str, 7));
		
		// Will show IndexOutOfBoundsException
		//System.out.println(mySubstring(str, 70));
	}

	// Methods returns string substring from 0 to idx-1
	// It catches IndexOutOfBoundsException
	public static String mySubstring(String str, int idx)
	{
		String s = "";

		try
		{
			// Loop from 0 to idx-1
			for (int i = 0; i <= idx - 1; i++)
			{
				s += str.charAt(i);
			}
		} catch (IndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}

		return s;
	}

}
