/*
 * Question 12
 * Write a program to store numbers from 1 to 100 in an array. Print out all the eve numbers from the array.
 * Use the enhanced FOR loop for printing out the numbers
 * By: Brice Petty
 * Credit To:
 */
package com.revature.question12;

public class EnhancedForLoop {
	private static int[] populateArray100() {
		int[] array100 = new int[100];
		
		for (int i = 0; i < 100; i++) {
			array100[i] = i + 1;
		}
		return array100;
	}
	
	private static void printEvens(int[] inputArray) {
		for (int i : inputArray) {
			if (i % 2 == 0 ) {
				System.out.println(i + " is an even value within the array.");
			}
		}
	}
	
	public static void main(String[] args) {
		printEvens(populateArray100());
	}
}