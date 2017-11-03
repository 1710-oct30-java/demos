package com.revature.question1;


/*
 * Perform bubble sort on int array 1 0 5 6 3 2 3 7 9 8 4
 */

public class Question1 {
	
	public static void main(String[] args) {
		
	
	int [] array = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
	int temp = 0;
	for (int i = 0; i < array.length; i++) {
		for(int j = 1; j < (array.length - 1); j++) {
			if(array[j-1] > array[j]) {
				temp = array[j-1];
				array[j-1] = array[j];
				array[j] = temp;
				
				
			}				
		}	
	}
	
	for(int i = 0; i < array.length; i++)
		System.out.print(array[i] + " " );
	
	
	
	}
}
