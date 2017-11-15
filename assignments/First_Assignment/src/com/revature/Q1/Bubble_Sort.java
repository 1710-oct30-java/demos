/* Author: Stephen Huelsman
 * Perform a bubble sort on the following integer array: 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4
 */
package com.revature.Q1;

public class Bubble_Sort {
	public static void main(String [] args) {
		int[] numbers = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		boolean finished = false;
		int temp = 0;
		
		do {
			finished = true;
			for(int i = 0; i < numbers.length-1; i++) {
				if(numbers[i] > numbers[i+1]) {
					temp = numbers[i];
					numbers[i] = numbers[i+1];
					numbers[i+1] = temp;
					finished = false;
				}
			}
		}
		while(!finished);
		for(int j = 0; j < numbers.length; j++) {
			System.out.println(numbers[j]);
		}
	}
}
