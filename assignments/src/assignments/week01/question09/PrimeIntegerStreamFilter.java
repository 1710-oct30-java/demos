package assignments.week01.question09;

import java.util.function.Predicate;

/**
 * encapsulates the logic for filtering prime
 * numbers out of a stream of integers
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class PrimeIntegerStreamFilter implements Predicate<Integer> 
{
	/**
	 * @param Integer value
	 * 
	 * @return boolean
	 */
	public boolean test(Integer value)
	{
		switch( Math.abs(value) ) {
			case 1:
				return false;	// 1 is not prime
			default :
				/*
				 * if the number passed is divisible by
				 * any number between it and 1 then it is
				 * NOT a prime number
				 */
				for(int i = 2; i < value; i++ ) {
					if ( (value % i) == 0 ) {
						return false;
					}
				}
				
				/*
				 * otherwise it is
				 */
				return true;
		}
	}
}
