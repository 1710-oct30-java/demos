package question19;

import java.util.ArrayList;
import java.util.stream.IntStream;

import question09.PrimePrinter;

/**
 * Question 19: Creates an ArrayList and insert integers 1 through 10. Display the ArrayList.
 * Add all the even numbers up and display the result. .Add all the odd numbers up
 * and display the result. Remove the prime numbers from the arrayList and print out
 * the remaining ArrayList.
 * 
 * @author Mitch Goshorn
 *
 */
public class ArrayListManipulation {

	public static boolean isEven(Integer i) {
		return i % 2 == 0;
	}
	
	
	public static void main(String[] args) {
		ArrayList<Integer> ints = new ArrayList<>();
		IntStream.range(1, 11).forEach(v -> ints.add(v));
		
		Integer evenSum = 0;
		Integer oddSum = 0;
		
		//Display arraylist
		System.out.println(ints);
		
		//Find sum of all even values
		evenSum = ints.stream()
				.filter(i -> isEven(i))
				.mapToInt(Integer::intValue)
				.sum();
	
		System.out.println("Sum of evens: " + evenSum);
		
		//Find sum of all odd values
		oddSum = ints.stream()
				.filter(i -> !isEven(i))
				.mapToInt(Integer::intValue)
				.sum();
		
		System.out.println("Sum of odds: " + oddSum);
		
		/** Remove primes - Uses prime predicate from {@link question09.PrimePrinter} */
		ints.removeIf(v -> PrimePrinter.isPrime(v));
		System.out.println(ints);
		
	}
	
}
