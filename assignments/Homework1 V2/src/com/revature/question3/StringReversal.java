/*
 * Question 3
 * Reverse a string without using any temporary variables. Do NOT use reverse() in the StringBuffer or StringBuilder APIs.
 * By: Brice Petty
 * Credit To: 
 */
package com.revature.question3;

public class StringReversal {
	static String testString = "The quick brown fox jumps over the lazy dog";
	
	public static String reverseString(String inputString) {
		final int stringLength = inputString.length();
		
		for (int i = (stringLength - 1); i >= 0; --i) {
			inputString = inputString + inputString.charAt(i);
		}
		
		inputString = inputString.substring(stringLength);
		return inputString;
	}
	
	public static void main(String[] args) {
		System.out.println("Our initial string to be reversed is: " + testString);
		System.out.println("Our final reversed string is: " + reverseString(testString));
	}
}