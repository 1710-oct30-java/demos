package com.revature.question5;

public class Question5 {
	
	static char[] substring(String s, int index) {
		char[] charArray = s.toCharArray();
		for (int i=0; i<index; i++) {
			System.out.print(charArray[i]);
		}
		return charArray;
	}
	
public static void main(String[] args) {
		substring("abcdefg", 4);
	}
}
