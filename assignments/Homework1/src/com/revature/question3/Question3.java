package com.revature.question3;

/* 
 * Reverse a string without using a temporary variable
 */
public class Question3 {

	public static void main(String[] args) {
		
		String a = "austin";
		String b = "";
		int len = a.length();
		
		for (int i = len - 1; i >= 0; i--) {
			b += a.charAt(i);		
			}
		
		System.out.println(b);
		

	}

}
