package com.revature.question5;
/*
 * Write a substring method that accepts a string srt and an integer idx
 * and returns the substring contained between 0 and idx - 1 inclusive. Do not use any
 * of the existing substring methods in the String, StringBuilder, or StringBuffer APIs
 */
public class Question5 {
	
	public static void main(String[] args) {
		System.out.println(substring("banana", 4));
		
	}
	
	//Hello, 3, Hel
	public static String substring(String str, int idx) {
		String sub = "";
		for(int i = 0; i <= idx - 1; i++) {
			sub = sub + str.charAt(i);
		}
		return sub;
	}
}
