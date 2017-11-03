package com.revature.question3;

//Question3 - Reverse a string without using a temporary variable. Do NOT use 
//reverse() in the StringBuffer or the StringBuilder APIs
public class Question3 {
	public static void main(String[] args) {
		String str = "hello";
		System.out.println(str.length());
		System.out.println(reverse(str));
	}

	public static String reverse(String str) {
		char firstCharacter = str.charAt(0);
		// if the string is of length 1 return the string
		if (str.length() <= 1) {
			return str;
		}
		
		//call reverse with the rest of the string 
		return reverse(str.substring(1)) + str.charAt(0);
				
	}
}
