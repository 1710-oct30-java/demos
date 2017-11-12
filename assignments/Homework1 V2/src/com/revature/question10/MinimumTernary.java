/*
 * Question 10
 * Find the minimum of two numbers using ternary operators.
 * By: Brice Petty
 * Credit To:
 */
package com.revature.question10;

public class MinimumTernary {
	static int whichIsLess(int a, int b) {
		int minVal = (a < b) ? a : b;
		return minVal;
	}

	static int whichIsMore(int a, int b) {
		int maxVal = (a > b) ? a : b;
		return maxVal;
	} //Not part of the prompt, but in the event you wanted a method to return a max value here she be!
	
	public static void main(String[] args) {
		System.out.println(whichIsLess(-15, 1159238) + " is the lesser of the two ints");
		System.out.println(whichIsMore(95, 0) + " is the greater of the two ints even though the questions doesn't call for it");
	}
}
