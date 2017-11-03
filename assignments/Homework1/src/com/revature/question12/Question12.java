package com.revature.question12;

/*
 * Store numbers from 1 to 100 in array
 * Print out all even numbers from array
 * Use enhanced for loop for printing out numbers
 * 
 */

public class Question12 {

	public static void main(String[] args) {
		
		int arr[] = new int[101];
		for (int i = 1; i <= 100; i++) {
			arr[i] = i;
		}
		
		for (int num: arr) {
			if (num % 2 == 0 & num !=0)
				System.out.print(num + " ");
		}
	}

}
