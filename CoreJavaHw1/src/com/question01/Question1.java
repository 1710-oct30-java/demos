package com.question01;

import java.util.Arrays;

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
		
		// Stop trying to sort when array is sorted
		while (swapOccured)
		{
			swapOccured = false;
			
			for (int j = 0; j < arr.length - 1; j++)
			{
				// Check if pair needs to switch places
				if (arr[j + 1] < arr[j])
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
