package question09;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Question 9: Create an ArrayList which stores numbers from 1 to 100 and 
 * prints out all the prime numbers to the console
 * @author BlueT
 *
 */
public class PrimePrinter {

	public static boolean isPrime(int i) {
		
		//Prime numbers must be greater than 1
		if(i <= 1) return false;
		
		//Exception to next following rule: 2 is even and prime
		if(i==2) return true;
		
		//return false if even, since all even numbers are not prime
		if(i%2 == 0) return false;
		
		/*
		 * check values starting from 3 to the square root of i
		 * (Anything beyond the square root will have a correlating pre-square root
		 * divisor, except for square numbers
		 */
		
		for(int x = 3; x <= Math.sqrt(i); x+=2) {
			if(i%x == 0) return false;
		}
		
		//no divisors found, so return true
		return true;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> intList = new ArrayList<>();
		IntStream.range(1, 100).forEach(i -> intList.add(i));
		
		intList.stream()
				.filter(i -> isPrime(i))
				.forEach(i -> System.out.print(i + ", "));
	}
	
	
}
