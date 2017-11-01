package com.revature.javacore.question12;

/*
	Write a program to store numbers from 1 to 100 in an array. Print out all the even
	numbers from the array. Use the enhanced FOR loop for printing out the numbers.
 */

public class Question12 {

	public static void main(String[] args) {
		
		// Initialize array to 100
		int[] array = new int[100];
		
		// Store numbers in array
		for(int i = 0; i < 100; i++)
		{
			array[i] = i+1;
		}
		
		// Enhanced for loop to print out even numbers
		for(Integer i:array)
		{
			// Check that number is even, then print it
			if(i % 2 == 0)
			{
				System.out.print(i + " ");
			}
		}
		
	}

}
