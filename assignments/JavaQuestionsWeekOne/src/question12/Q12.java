package question12;

public class Q12 {

	/*
	 * Write a program to store numbers from 1 to 100 in an array. Print out all the
	 * even numbers from the array. Use the enhanced FOR loop for printing out the
	 * numbers.
	 */

	public static void main(String[] args) {
		int[] array = new int[100];

		//Set up the array with 1-100.
		for (int i = 0; i < array.length; i++) {
			array[i] = i+1;
		}
		
		//Print out the even numbers.
		for (int i : array) {
			if (i % 2 == 0)
				System.out.println(i);
		}

	}

}
