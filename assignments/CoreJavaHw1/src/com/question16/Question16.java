package com.question16;

/* Write a program to display the number of characters for a string input.
 * The string should be entered as a command line argument using
 * (String[] args).
*/

public class Question16
{
	public static void main(String[] args)
	{
		// Just prints the String length
		System.out.println("The string \"" + args[0] + "\" has " + args[0].length() + " characters.");
	}
}
