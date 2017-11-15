/* Author: Stephen Huelsman
 * Write a substring method that accepts a string str and an integer idx and returns the 
 * substring contained between 0 and idx-1 inclusive
 */
package com.revature.Q5;

public class Substring {
	
	public static void main(String[] args) {
		String s = "shoopdewoop";
		int x = 5;
		String d = substring(s, 5);
		System.out.println(d);
	}

	private static String substring(String str, int idx) {
		String output = "";
		
		for(int i = 0; i < idx; i++ ) {
			output = output + str.charAt(i);
		}
		
		
		return output;
	}
}
