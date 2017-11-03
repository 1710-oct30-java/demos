package com.revature.homework.question18;

import java.util.Scanner;

// Write a program using abstract and concrete classes to:
//1. check for uppercase chars return boolean
//2. convert all lower case chars to uppercase
//3. convert the input string to integer and add 10

public class Question18test {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Question18Con q = new Question18Con();
		
		System.out.println("Please enter a string: ");
		String input = scan.nextLine();
		System.out.println("This String contains an Uppercase character: " + q.checkUppercase(input));
		System.out.println("Converting lowercase to Uppercase: "+ q.convertLowerToUpper(input));
		System.out.println("Converting string to int and adding ten: " +q.convertStringToInt(input));
		
	}
}
