package assignments.week01.question19;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * represents a number range that encapsulates a 
 * list of integers that fall between a min and
 * max integer
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class NumberRange {
	private List<Integer> numbers;
	
	/**
	 * instantiate a NumberRange that ranges
	 * from the first to the last integer passed
	 * 
	 * @param int first
	 * @param int last
	 */
	public NumberRange(int first, int last)
	{
		this.numbers = this.generateNumbers(first, last); // would a LinkedList be more efficient?s
	}
	
	/**
	 * retrieve the list of numbers encapsulated
	 * 
	 * @return List<Integer>
	 */
	public List<Integer> getNumbers()
	{
		return this.numbers;
	}
	
	/**
	 * return a list of the encapsulated integers
	 * that are even
	 * 
	 * @return List<Integer>
	 */
	public List<Integer> getEvenNumbers()
	{		
		return this.numbers
			.stream()
			.filter( number -> ( number % 2 ) == 0)
			.collect( Collectors.toList() );
	}
	
	/**
	 * return a list of the encapsulated integers
	 * that are odd
	 * 
	 * @return List<Integer>
	 */
	public List<Integer> getOddNumbers()
	{
		return this.numbers
			.stream()
			.filter( number -> ( number % 2 ) != 0)
			.collect( Collectors.toList() );
	}
	
	/**
	 * return a list of the encapsulated integers
	 * that are prime
	 * 
	 * @return List<Integer>
	 */
	public List<Integer> getPrimeNumbers()
	{
		return this.numbers
			.stream()
			.filter( value -> {
				/* 
				 * if number is 1 then it is not prime
				 */
				if ( Math.abs(value) == 1) {
					return false;  
				} else {
					for(int i = 2; i < value ; i++ ) {
						/*
						 * if the number passed is divisible by
						 * any number between it and 1 then it is
						 * NOT a prime number
						 */
						if ( ( value % i) == 0 ) {
							return false;
						}
					}
					/*
					 * otherwise it is
					 */
					return true;
				}
			})
			.collect( Collectors.toList() );
	}
	
	/**
	 * remove the numbers passed in the List<Integer>
	 * from the encapsulated collection of integers
	 * 
	 * @param List<Integer> deletions
	 */
	public void removeNumbers(List<Integer> deletions)
	{
		for(Integer number : deletions ) {
			this.numbers.remove( number );
		}
	}

	/**
	 * generate a list of numbers
	 * 
	 * @param int first
	 * @param int last
	 * 
	 * @return List<Integer>
	 */
	private List<Integer> generateNumbers(int first, int last)
	{
		List<Integer> numbers = new ArrayList<>();
		
		for(int i = first; i <= last; i++ ) {
			numbers.add(i);
		}
		
		return numbers;
	}
}
