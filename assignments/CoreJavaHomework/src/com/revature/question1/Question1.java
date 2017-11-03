package com.revature.question1;

/*
 * Perform a bubble sort on the following integer array: 1, 0, 5,6,3,2,3,7,9,8,4
 */
public class Question1 {

	public static void main(String[] args) {

		//int[] array = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		int[] array =  {1, 5, 2, 4, 3};

		boolean isSorted = false;

		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < array.length - 1; i++) {
				// if the first number is greater than the one next to it swap
				if (array[i] > array[i + 1]) {
					int temp = array[i]; 
					array[i] = array[i + 1]; 
					array[i + 1] = temp;
					isSorted = false;
				}
			}
		}
		
		//print sorted array
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
