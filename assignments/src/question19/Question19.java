package question19;

import java.util.ArrayList;

import question9.Question9;

public class Question19 {
	// Create an ArrayList and insert integers 1 through 10.
	// Display the ArrayList. Add all the even numbers up and
	// display the result. Add all the odd numbers up and display
	// the result. Remove the prime numbers from the ArrayList
	// and print out the remaining ArrayList.
	public static void main(String[] args) {
		// Create ArrayList
		ArrayList<Integer> numbers = new ArrayList<>();
		
		// Add numbers to list.
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		numbers.add(8);
		numbers.add(9);
		numbers.add(10);
		
		// Initialize variables for storing values.
		int evens = 0;
		int odds = 0;
		ArrayList<Integer> primes = new ArrayList<>();
		
		// Determine evens, odds and primes.
		for(int i : numbers) {
			if(i % 2 == 0) {
				evens = evens + i;
			}
			else {
				odds = odds + i;
			}
			if(Question9.isPrime(i)) {
				primes.add(i);
			}
		}
		
		// Remove primes.
		for(int i : primes) {
			numbers.remove(Integer.valueOf(i));
		}
		
		// Print the outputs to console.
		System.out.println("The total of all even numbers is " + evens + ".");
		System.out.println("The total of all odd numbers is " + odds + ".");
		System.out.println("The ArrayList with all the prime numbers removed is...");
		for(int i : numbers) {
			System.out.println(i);
		}
	}
}