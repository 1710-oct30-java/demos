package com.revature.Homework1.Q5;

public class Q5 {
	/* 
	 * write a substring method
	 * inputs String str; int idx
	 * return substring of str 0 to idx-1
	 */
	public static void main(String[] args) {
		String input = "This is a test";
		System.out.println(input);
		String output = Substring(input, 4);
		System.out.println(output);
	}
	public static String Substring(String str, int idx) {
		String out = String.valueOf(str.charAt(0));
		for(int i = 1; i < idx; i++) {
			out += String.valueOf(str.charAt(i));
		}
		return out;
	}
}
