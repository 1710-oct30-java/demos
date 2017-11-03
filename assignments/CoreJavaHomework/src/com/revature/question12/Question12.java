package com.revature.question12;

import java.util.Arrays;

/*
 * Write a program to store numbers 1 to 100 in an array.
 * Print out all the even numbers from the array. Use the enhanced FOR loop for 
 * printing out the numbers
 */
public class Question12 {
	public static void main(String[] args) {

		// Declare an array to store numbers 1 - 100
		int[] array = new int[100];

		// populate the array
		for (int i = 1; i <= 100; i++) {
			array[i - 1] = i;
		}

		// System.out.println(Arrays.toString(array));

		// Use enhance loop to print out the even numbers
		for (int num : array) {
			if (num % 2 == 0) {
				System.out.println(num);
			}
		}

	}

}
