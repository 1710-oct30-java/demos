package com.homeworkOne.problemSixteen;

import java.util.Scanner;

public class ProblemSixteen {
	
//Display number of characters in a string
	public static void main(String[] args) {
		//Init variables
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string");
		//User input
		String string  = input.nextLine();
		System.out.println(string + " has " + (string.length()-1) + " characters");
	}
}
