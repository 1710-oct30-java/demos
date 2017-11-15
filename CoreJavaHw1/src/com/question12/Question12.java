package com.question12;

/* Q12, Write a program to store numbers from 1 to 100 in an array. Print
 * out all the even numbers from the array. Use the enhanced FOR loop for
 * printing out the numbers.
*/

public class Question12
{
	static int[] ints = new int[100];
	
	public static void main(String[] args)
	{
		// Fill array
		for (int i = 0; i < ints.length; i++)
			ints[i] = i + 1;
		
		// Print evens
		for (int i : ints)
		{
			if (i % 2 == 0)
				System.out.println(i);
		}
	}
}
