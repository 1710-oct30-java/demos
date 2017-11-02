package question1;

import java.util.stream.IntStream;

/*
 * Q1. Perform a bubble sort on the following integer array: 1,0,5,6,3,2,7,9,8,4
 */
public class Question1 {
	public static void main(String[] args) {
		int[] numberArray = { 1, 0, 5, 6, 3, 2, 3, 7, 98, 4 };
		// print out the current array
		System.out.println("The Current Array is: ");
		IntStream.of(numberArray).forEach(i -> System.out.print(i + " "));
		numberArray = bubbleSort(numberArray);
		// print out the new array. NOTE: the initial \n is for aesthetics
		System.out.println("\nThe array after bubblesort is: ");
		IntStream.of(numberArray).forEach(i -> System.out.print(i + " "));

	}

	/*
	 * BubbleSort: Compare each adjacent number and switch if the number on the left
	 * is larger than the number on the right.
	 */
	public static int[] bubbleSort(int[] array) {
		// count is to verify that no item of the array was moved
		int count;
		do {
			count = 0;
			// traverse the array
			for (int i = 0; i < array.length - 1; i++) {
				// if the current number is greater than the next number then swap numbers and
				// increment count
				if (array[i] > array[i + 1]) {
					int temp = array[i + 1];
					array[i + 1] = array[i];
					array[i] = temp;
					count++;
				}
			}
			// If nothing has shifted then we're done
		} while (count > 0);
		return array;
	}
}
