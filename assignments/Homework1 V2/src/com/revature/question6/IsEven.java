/*
 * Question 6
 * Write a program that determines if an integer is even without using the modulus % operator
 * By: Brice Petty
 * Credit To: 
 */
package com.revature.question6;

import java.util.Scanner;

public class IsEven {
	public static boolean isItEven(int inputInteger) {
		int originalInt = inputInteger;
		int b = originalInt / 2;
		int testEven = b * 2;

		if (originalInt == testEven) {
			return true;
		}

		else {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println("Please provide an integer to test for evenness: ");
		Scanner checkEven = new Scanner(System.in);
		int testEven = checkEven.nextInt();
		System.out.println(isItEven(testEven));
		checkEven.close();
	}
}