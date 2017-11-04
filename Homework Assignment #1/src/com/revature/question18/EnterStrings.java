package com.revature.question18;

import java.util.Scanner;
import java.util.scanner;


public class EnterStrings {
	public static void main(String[] args) {
		
		Question18 obj = new SubClass();
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a string to do an Upper Case letter check");
		
		String i = sc.nextLine();
		System.out.println(obj.upperCheck(i));
		System.out.println("Enter a string to convert all lowercase letters to uppercase:");
		String j = sc.nextLine();
		System.out.println(obj.returnCheck(j));
		System.out.println("Enter a string to covert to integer and add 10");
		String c = sc.nextLine();
		System.out.println(obj.stringToInt(j));
		
	}

}
