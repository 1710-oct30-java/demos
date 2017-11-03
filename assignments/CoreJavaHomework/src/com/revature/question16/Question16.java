package com.revature.question16;
/*
 * Write a program to display the number of characters
 * for a string input. The string should be entered as a command line argument
 * using (String[] args).
 */
public class Question16 {
	public static void main(String[] args) {
		
		//get the length of the strings in each element of the args array and add them
		int numOfChar = 0;
		for(int i = 0; i < args.length; i++) {
			numOfChar = numOfChar + args[i].length();
		}
		
		//Display the number of characters for the string input
		System.out.println("The number of characters for the string input is: " + numOfChar);
	}
}
