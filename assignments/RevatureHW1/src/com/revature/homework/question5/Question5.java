package com.revature.homework.question5;
// Write a substring method 

public class Question5 {
	public static void main(String[] args) {
		String str ="hello";
		int i =3;
		
		System.out.println(mySubString(str,i));
	}
	// Method accepts string and int args
	public static String mySubString(String str, int idx) {
		// uses creates new string by appending chars to string builder
		StringBuilder newString = new StringBuilder(idx);
		for (int i=0;i<idx;i++) {
			newString.append((str.charAt(i)));
		}
		return newString.toString();
	}
}
