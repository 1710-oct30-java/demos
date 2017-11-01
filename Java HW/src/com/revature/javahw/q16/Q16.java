// Christopher Youngblood
// 11/1/2017
// Revature Java Course
// Homework 1 - Question 16

package com.revature.javahw.q16;

// Q16. Write a program to display the number of characters for
//		a string input. The string should be entered as a
//		command line argument using (String[] args).

public class Q16 {

	public static void main(String[] args) {
		
		//remove all whitespace so only characters are left
		//(I'm assuming whitespace != a character)
		args[0] = args[0].replaceAll("\\s+", "");
		
		int len = args[0].length();
		
		System.out.println(len);
	}
	
}
