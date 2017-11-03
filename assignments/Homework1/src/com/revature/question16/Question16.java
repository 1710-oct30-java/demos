package com.revature.question16;

/*
 * Display the # of chars for a string input
 * The string should be entered as a command line argument using String[] args
 */

public class Question16 {

	public static void main(String[] args) {
		
		String s = args[0];
		int len = s.length();
		int numC = 0;
		
		for (int i = 0; i < len; i++) {
			numC++;
		}
		
		System.out.println("The command line args[0] is: " + s + " and has " + numC + " chars" );
		

	}

}
