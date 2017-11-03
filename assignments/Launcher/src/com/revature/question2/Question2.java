package com.revature.question2;

public class Question2 {
	
	public static void fibonacciNumbers() {
		
		// Initialize the array
		int[] myArray = new int[25];
		// Initialize the first two values of the Fibonacci numbers
		myArray[0] = 0;
		myArray[1] = 1;
		
		// fill an array with the Fibonacci numbers
		for (int i=0;i < myArray.length-2; i++) {
			myArray[i+2] = myArray[i] + myArray[i+1];
		}
		
		//Print the values in the array
		for (int j = 0; j < myArray.length;j++) {
		System.out.print(myArray[j]);
			if (j != myArray.length-1) {
				System.out.print(", ");
			}
		}
		
	}
	
	public static void main(String[] args) {
		fibonacciNumbers();
	}
}
