//Author: Micah West
//Date: 11/01/2017
//Purpose: Reverse a string without any temporary variables.
//Included files: StringReversal.java
//Input: hello (from console)
//Output: String "hello" reversed as "olleh"

package com.revature.corejava.Q03;

import java.util.Scanner;

public class StringReversal {
	
	public static void main(String[] args) {
		
		// Take user input for the string to reverse
		Scanner consoleIn = new Scanner(System.in);
		String input;
		
		System.out.println("Enter string to reverse: ");
		input = consoleIn.nextLine();
		
		System.out.println("String \"" + input + "\" reversed as \"" + reverse(input) + "\"");
		
		consoleIn.close();
		
	}
	
	public static String reverse(String input)
	{
		// Using a StringBuilder to keep from building up garbage.
		// Notice that I will not just be building the string in reverse.
		// Doing so would break the "no temporary variables" requirement.
		StringBuilder builder = new StringBuilder(input);
		
		// Iterate through the string, append the second to last character from the initial
		// then delete that original character from the new string.
		// This results in a series of operations on the same object without creating a new one.
		for(int i = 0; i < builder.length()-1; i++)
		{
			builder.append(builder.charAt(builder.length()-2-i));
			builder.deleteCharAt(builder.length()-3-i);
		}
		
		return builder.toString();
	}
}
