/*
 * Question 1
 * Perform a bubble sort on the following integer array: [1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4]
 * By: Brice Petty
 * Credit To: 
 */
package com.revature.question1;

import java.util.Arrays;

public class BubbleSortArray {
	final static private int[] arrayToBubbleSort = new int[] {1,0,5,6,3,2,3,7,9,8,4};
	final private int length = sortedArrayCopy.length;
	static private int[] sortedArrayCopy = Arrays.copyOf(arrayToBubbleSort, arrayToBubbleSort.length);
	int tempVal = 0;
	
	public int[] bubbleSortArrayMethod (int[] inArray) {
	    for (int i = 0; i < length; i++) {
	        for (int j = 1; j < (length - i); j++) {
	            if (sortedArrayCopy[j - 1] > sortedArrayCopy[j]) {
	                tempVal = sortedArrayCopy[j - 1];
	                sortedArrayCopy[j - 1] = sortedArrayCopy[j];
	                sortedArrayCopy[j] = tempVal;
	            }
	        }
	    }
	    return sortedArrayCopy;
	}
	
	public static void main(String[] args) {
		BubbleSortArray sortObject = new BubbleSortArray();
		System.out.println("Our originsl array is: " + Arrays.toString(arrayToBubbleSort));
		System.out.println("Our sorted array is: " + Arrays.toString(sortObject.bubbleSortArrayMethod(sortedArrayCopy)));
	}
}