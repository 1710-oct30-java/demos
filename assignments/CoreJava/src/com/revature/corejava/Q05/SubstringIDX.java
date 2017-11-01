package com.revature.corejava.Q05;

//Author: Micah West
//Date: 11/01/2017
//Purpose: Create a method that gives the substring from 0 to idx in a string str. Solution to Question 5.
//Included files: .java
//Input: none
//Output: Substring from 0 to 3 in "greetings" is "gre"

public class SubstringIDX {
	
	public static void main(String[] args) {
		
		String str = "greetings";
		int idx = 3;
		
		System.out.println("Substring from 0 to " + idx + " in \"" + str + "\" is \"" + substring(str, idx) + "\"");
	}
	
	public static String substring(String input, int idx) {
		
		StringBuilder sbr = new StringBuilder("");
		
		for(int i = 0; i < idx; i++) {
			
			sbr.append(input.charAt(i));
		}
		
		return sbr.toString();
	}
}
