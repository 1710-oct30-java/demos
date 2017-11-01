// Christopher Youngblood
// 10/30/2017
// Revature Java Course
// Homework 1 - Question 10

package com.revature.javahw.q10;

// Q10. Find the minimum of two numbers using ternary operators.

public class Q10 {
	
	public static void main(String[] args) {
		int a = 30;
		int b = 26;
		
		int min;
		min = (a < b) ? a : b;
		
		System.out.println(min);
	}

}
