package com.revature.homework.question12;

// Store 1-100 in an array and print out evens with for each loop
public class Question12 {

	// need to do it with a for each loop

	public static void main(String[] args) {

		int[] arr = new int[100];

		// Stores the numbers 1-100
		for (int i = 0; i < 100; i++) {
			arr[i] = i + 1;
		}

		for (int each : arr) {
			// if it has no remainder when div by 2 its even
			if ((arr[each - 1]) % 2 == 0) {
				System.out.println(each);
			}
		}
	}
}
