// Christopher Youngblood
// 10/30/2017
// Revature Java Course
// Homework 1 - Question 6

package com.revature.javahw.q6;

// Q6. Write a program to determine if an integer is even without
//     using the modulus operator (%)

public class Q6 {
	public static void main(String[] args) {
		
		//The integer to be determined
		int integer = 21;
		
		boolean done = false;
		do {
			if (integer < 0) {
				integer = integer * -1;
			}
			if (integer == 0) {
				done = true;
				System.out.println("Integer is EVEN!");
			}
			else if (integer == 1) {
				done = true;
				System.out.println("Integer is ODD!");
			}
			else {
				integer = integer - 2;
			}
		}
		while (done == false);
	}
}
