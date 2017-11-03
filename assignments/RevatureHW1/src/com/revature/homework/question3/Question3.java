package com.revature.homework.question3;

// Reverse a string without using a temporary variable

public class Question3 {
	public static void main(String[] args) {
		String str = "Hello World";
		System.out.println("String before reversing: " + str);
		str = reverseString(str);
		System.out.println("String after reversing: " + str);
	}
	
	public static String reverseString(String s) {
		// Appends the characters in reverse to the input string
		for (int i=s.length()-1; i>=0; i--){
			s+=s.charAt(i);
		}
		// cuts the front half of the string off
		return s.substring(s.length()/2, s.length());

	}
}
