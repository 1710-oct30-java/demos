//Author: Micah West
//Date: 10/31/2017
//Purpose: From a string input from command line, print the number of characters it has.
//         Solution to question 16.
//Included files: StringCounter.java
//Input: hello (in command line)
//Output: String "hello" has 5 characters.

package com.revature.corejava.Q16;

public class StringCounter {
	
	public static void main(String[] args) {
		
		// Just an if/else statement solves this problem.
		// If there aren't any arguments given, print that there need to be some.
		// Otherwise, print the string and the number of characters the string contains.
		if(args.length < 1) {
			
			System.out.println("Please enter a string in the command line arguments.");
		}
		else {
		
			System.out.println("String \"" + args[0] + "\" has a length of " + args[0].length() + " characters.");
		}
	}
}
