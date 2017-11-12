/*
 * Question 5
 * Write a substring method that a string str and an integer idx and returns the substring contained between 0 and idx-1 inclusive. Do NOT use any of the
 * available substring methods in String, StringBuffer, or the StringBuilder APIs  
 * By: Brice Petty
 * Credit To: 
 */
package com.revature.question5;

import java.util.Scanner;

public class SubstringMethod {
	public static String returnTheSubstring(String str, int idx) {
		String processedString = "";
		
		for (int i = 0; i < idx; i++) {
			processedString += str.charAt(i);
		}
		return processedString;
	}
	
	public static void main(String[] args) {
		System.out.println("Please enter the desired string for substringing");
		Scanner inString = new Scanner(System.in);
		String str = inString.nextLine();
		System.out.println("Please enter the desired integer index for the substring");
		Scanner inIdx = new Scanner(System.in);
		int idx = inIdx.nextInt();
		System.out.println("Your finalized substring is: " + returnTheSubstring(str, idx));
		inString.close();
		inIdx.close();
	}
}
