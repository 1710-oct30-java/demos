package assignments.week01.question09;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Question09 {

	public static void main(String[] args) {
		int digits = 100; 													// number to count up to
		List<Integer> numbers = generateNumberSequence( digits );			// generate number array list
		PrimeIntegerStreamFilter filter = new PrimeIntegerStreamFilter();	// instantiate prime number integer filter
		List<Integer> primeNumbers = numbers.stream()						// filter prime numbers out of numbers list
				.filter( filter )
				.collect( Collectors.toList() );
		
		/*
		 * prints prime numbers to console
		 */
		System.out.println( primeNumbers );					
	}
	
	/**
	 * generate number sequence
	 * 
	 * @param int digits
	 * 
	 * @return List<Integer>
	 */
	public static List<Integer> generateNumberSequence(int digits)
	{
		List<Integer> output = new ArrayList<>();
		
		for(int i = 0; i < digits; i++ ) {
			output.add(  ( i + 1) );
		}
		
		return output;
	}
	
}
