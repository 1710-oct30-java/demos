package com.revature.question5;

public class Question5 {
	
	// Find the substring of a given string
	// from index 0 to index index-1
	static char[] mySubstring(String s, int index) {
		char[] charArray = s.toCharArray();
		for (int i=0; i<index; i++) {
			System.out.print(charArray[i]);
		}
		return charArray;
	}

public static void main(String[] args) {
		mySubstring("abcdefg", 4);
	}
}
