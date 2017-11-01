package com.question01;

import java.util.Arrays;

// INCOMPLETE: See To-Do below
// Q1. Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4

public class Question1
{
	public static void main(String[] args)
	{
		int vals[] = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		System.out.println(Arrays.toString(bubbleSort(vals)));
	}
	
	static int[] bubbleSort(int[] arr)
	{
		boolean swapOccured = true;
		
		// TODO change this to a while that detects when the array is sorted
		while (swapOccured)
		{
			swapOccured = false;
			
			for (int j = 0; j < arr.length - 1; j++)
			{
				if (arr[j + 1] < arr[j]) // Check if pair needs to switch places
				{
					// Swap
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapOccured = true;
				}
			}
		}
		return arr;
	}
}
