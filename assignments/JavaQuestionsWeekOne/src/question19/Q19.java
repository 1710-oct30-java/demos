package question19;

import java.util.ArrayList;

import question09.Q9;

public class Q19 {

	/*
	 * Create an ArrayList and insert integers 1 through 10. Display the ArrayList.
	 * Add all the even numbers up and display the result. Add all the odd numbers
	 * up and display the result. Remove the prime numbers from the ArrayList and
	 * print out the remaining ArrayList.
	 */

	public static void main(String[] args) {
		ArrayList<Integer> oneThruTen = new ArrayList<>();
		ArrayList<Integer> nonPrimes = new ArrayList<>();
		int oddTotal = 0;
		int evenTotal = 0;
		
		for (int i = 1; i <= 10; i++) {
			oneThruTen.add(i);
		}
		
		for (Integer integer : oneThruTen) {

			if (integer % 2 == 0) evenTotal += integer;
			else oddTotal += integer;
		}
		
		System.out.println("Odd Total: " + oddTotal);
		System.out.println("Even Total: " + evenTotal);
		
		for (Integer integer : oneThruTen) {
			if (!Q9.primeCheck(integer)) nonPrimes.add(integer);	
		}
		
		System.out.println(nonPrimes);
	}

}
