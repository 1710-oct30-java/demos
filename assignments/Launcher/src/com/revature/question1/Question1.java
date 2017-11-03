package com.revature.question1;

public class Question1 {
	
	static int temp;
	static int[] myArray = {1,0,5,6,3,2,3,7,9,8,4};
	
	static void bubbleSort(int[] array) {
		
		// Repeat the loop as many times as the length
		// of the array. For instance, if the array's lowest value is
		// at the end of the array, then it will need to loop for
		// array.length-1 number of times to sort it to the
		// beginning of the array
		for (int j = 0; j < array.length - 1;j++) {
			
			// iterate through each value of the array
			for (int i = 0; i < array.length-1;i++) {
				
				// Swap the values of two adjacent indexes if needed
				// as long as i is not the last index
				if (array[i] > array[i+1]) {
					temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}
			}
		}
	}
	
	static void printArray(int[] array) {
		
		// Loop through the array and print out each value
		for (int i=0; i < array.length;i++) {
			System.out.print(array[i]);
			
			// Print a space after each number except the last one
			if (i < array.length-1) {
				System.out.print(", ");
			}
		}
	}
	
	public static void main(String[] args) {
		bubbleSort(myArray);
		printArray(myArray);
	}
}
