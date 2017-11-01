// Christopher Youngblood
// 10/30/2017
// Revature Java Course
// Homework 1 - Question 5

package com.revature.javahw.q5;

// Q5. Write a substring method that accepts a string str and an
//     integer idx and returns the substring contained between
//     0 and idx-1 inclusive. Do NOT use any of the existing
//     substring methods in the String, StringBuilder, or
//     StringBuffer APIs.

public class Q5 {
	
	public static void main(String[] args) {
		
		String str = "Hello World";
		int idx = 5;
		
		System.out.println("Input; str: " + str + "  idx: " + idx);
		
		if (idx < str.length()) {
			String subStr = substring(str, idx);
			System.out.println("Output: " + subStr);
		}
		else {
			System.out.println("idx is too large");
		}
		
	}
	
	private static String substring(String str, int idx) {
		
		//I used char[] mostly to play around with the conversions and figure out how the functions work
		char[] newStr = new char[str.length()];
				
		for(int i = 0; i < idx; i++) {
			newStr[i] = str.charAt(i);
		}
		str = new String(newStr);
		
		return str;
	}

}
