package question12;

import java.util.stream.IntStream;

/**
 * Question 12: Write a program to store numbers from 1 to 100 in an array.
 * Print out all the even numbers from the array. Use the enhanced
 * FOR loop for printing out the numbers.
 * 
 * @author Mitch Goshorn
 *
 */
public class EnhancedForPrintsEvens {
	
	/**
	 * Is even predicate
	 * @param value - input value
	 * @return true if even, false otherwise
	 */
	public static boolean isEven(int value) {
		return value % 2 == 0;
	}
	
	public static void main(String[] args) {
		int[] intArr = new int[100];
		
		//Steam range into int array
		IntStream.range(1, 101).forEach(i -> intArr[i-1] = i);
		
		//Use enhanced FOR loop to print out even numbers
		for(Integer i : intArr) {
			if(isEven(i)) System.out.printf("%d ", i);
		}
	}

}
