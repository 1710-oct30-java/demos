package com.revature.question1;

public class Question1 {
	public void bubbleSortIntArray(int[] inputArray) {

		int count = inputArray.length;
		int temp = 0;

		for (int i = 0; i < count; i++) {
			for (int j = 1; j < (count - i); j++) {

				if (inputArray[j - 1] > inputArray[j]) {
					temp = inputArray[j - 1];
					inputArray[j - 1] = inputArray[j];
					inputArray[j] = temp;
				}
			}
		}
	}

	public void printArray(int[] x) {
		for (int i = 0; i < x.length; i++)
			System.out.print(x[i] + " ");
		System.out.println(" ");
	}

	public static void main(String[] args) {

		Question1 herp = new Question1();
		int[] myArray = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };

		System.out.print("Before: ");
		herp.printArray(myArray);
		herp.bubbleSortIntArray(myArray);
		System.out.print("After: ");
		herp.printArray(myArray);

	}
}
