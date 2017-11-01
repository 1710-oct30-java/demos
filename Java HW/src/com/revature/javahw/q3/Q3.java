// Christopher Youngblood
// 10/30/2017
// Revature Java Course
// Homework 1 - Question 3

package com.revature.javahw.q3;

import java.lang.String;

// Q3. Reverse a string without using a temporary variable. Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.

public class Q3 {
	public static void main(String[] args) {
		String str = "Hello World!";
		
		for (int i = 0; i < (str.length()) ; i++) {
			str = str.substring(1, (str.length() - i)).concat(str.substring(0, 1)).concat(str.substring((str.length()-i)));
		}
		
		System.out.println(str);		
	}
}
