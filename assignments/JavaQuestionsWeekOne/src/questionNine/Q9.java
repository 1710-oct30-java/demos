package questionNine;

import java.util.ArrayList;

public class Q9 {
	
	//Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		for (int i = 1; i <= 100; i++) {
			numbers.add(i);
		}
		
		for (Integer integer : numbers) {
			if (primeCheck(integer)) System.out.println(integer);
		}

	}

	public static boolean primeCheck(Integer integer) {

		//0 and 1 are not prime.
		if (integer < 2) {
			return false;
			}
		
		//If a number can be found to divide the integer that leaves no remainder, the number is not prime.
		for (int i = 2; i < integer; i++) {
			if (integer % i == 0) return false;
		}
		
		//If no divisions resulted in 0 remainder, the number is prime.
		return true;
	}

}
