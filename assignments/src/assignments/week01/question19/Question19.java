package assignments.week01.question19;

import java.util.List;

public class Question19 {

	public static void main(String[] args) {
	
		NumberRange range = new NumberRange(1, 100);		// instantiate a range of numbers from 1 t0 100
		List<Integer> primes = range.getPrimeNumbers();		// extract the prime numbers in the number range
		
		System.out.println("ALL NUMBERS::");
		displayRange( range.getNumbers() );
		
		System.out.println("EVEN NUMBERS::");
		displayRange( range.getEvenNumbers() );
		
		System.out.println("ODD NUMBERS::");
		displayRange( range.getOddNumbers() );
		
		System.out.println("PRIME NUMBERS::");
		displayRange( primes );
		
		System.out.println("ALL NUMBERS AFTER REMOVING PRIMES::");
		range.removeNumbers( primes );						// remove prime numbers
		displayRange( range.getNumbers() );
	}
	
	/**
	 * display a integer list to the console
	 * 
	 * @param List<Integer> range
	 */
	public static void displayRange(List<Integer> range )
	{
		System.out.println("NUMBERS IN RANGE:");
		System.out.println( range );
		System.out.println( String.format("SUM OF NUMBERS IN RANGE: %d", sumOfRange( range ) ) );
		System.out.println("");
	}
	
	/**
	 * calculates and returns the sum of values in
	 * an integer list
	 * 
	 * @param List<Integer> range
	 * 
	 * @return Integer
	 */
	private static Integer sumOfRange(List<Integer> range)
	{
		return range
			.stream()
			.mapToInt( value -> value )
			.sum();
	}
}
