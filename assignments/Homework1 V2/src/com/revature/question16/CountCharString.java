/*
 * Question 16
 * By: Brice Petty
 * Write a program to display the number of characters for a string input. The string should be entered as a command line argument using (String[] args).
 * Credit To:
 */
package com.revature.question16;

public class CountCharString {
	public static void main(String[] args) {
		System.out.println("The string " + args[0] + " has " + args[0].length() + " chars.");
	}
}