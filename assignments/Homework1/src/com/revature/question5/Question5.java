package com.revature.question5;

import java.util.Scanner;

/* 
 * Write a substring method that accepts string str and int idx and returns
 * substring contained between 0 and idx-1 inclusive. 
 * 
 * DONT USE existing substring methods (String, StringBuilder, StringBuffer)
 * 
 */

public class Question5 {

	public static void main(String[] args) {
		
		System.out.print("Enter your string: ");
		Scanner scanner = new Scanner (System.in);
		String str = scanner.nextLine();
		System.out.print("Enter int for index: ");
		int idx = scanner.nextInt();
		
		String newStr = "";
		
		for (int i = 0; i < idx; i++) {
			newStr += str.charAt(i);
		}
		
		System.out.println(newStr);

	}

}
