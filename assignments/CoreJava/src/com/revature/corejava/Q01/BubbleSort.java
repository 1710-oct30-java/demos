//Author: Micah West
//Date: 11/01/2017
//Purpose: Perform a bubble sort on a list of integers. Solution to Question 1.
//Included files: BubbleSort.java
//Input: none
//Output: Sorting unsorted list: 
//				[1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4]
//		  Sorted list: 
//				[0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9]

package com.revature.corejava.Q01;

import java.util.Arrays;

public class BubbleSort {
	
	public static void main(String[] args) {
		
		int aryInts[] = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		
		System.out.println("Sorting unsorted list: \n\t" + Arrays.toString(aryInts) + "\n");
		aryInts = sort(aryInts);
		System.out.println("Sorted list: \n\t" + Arrays.toString(aryInts));
		
	}
	
	public static int[] sort(int[] aryInts) {
		
		for(int i = 0; i < aryInts.length-1; i++) {
			
			for(int j = 0; j < aryInts.length-i-1; j++) {
				
				if(aryInts[j] > aryInts[j+1]) {
					
					int tmp = aryInts[j];
					aryInts[j] = aryInts[j+1];
					aryInts[j+1] = tmp;
				}
			}
		}
		
		return aryInts;
		
	}
}
