package question9;

import java.util.ArrayList;

public class Question9
{
	// Create an ArrayList which stores numbers from 1 to 100 and
	// prints out all the prime numbers to the console.
	public static void main(String[] args)
	{
		// Initialize starting ArrayList for containing numbers.
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		// Add the numbers 1 to 100 to the ArrayList.
		for(int x = 1; x <= 100; x++)
		{
			numbers.add(x);
		}
		
		// Iterate through the numbers ArrayList and call the 
		// isPrime method on each one. If isPrime return true
		// it prints n to the console.
		for(int n : numbers)
		{
			if(isPrime(n) && (n>1))
			{
				System.out.println(n);
			}
		}
	}
	
	// This method determines if a number n is prime by attempting to divide it
	// by all numbers from 2 to n/2 and checking the modulus. If at any point
	// the modulus is zero, it returns false. Otherwise, returns true.
	public static boolean isPrime(int n)
	{
		for(int a = 2; a <= (n/2); a++)
		{
			if((n % a) == 0)
			{
				return false;
			}
		}
		return true;
	}
}