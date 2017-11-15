package com.question19;

import java.util.ArrayList;
import java.util.List;

import com.question09.Question9;

/* Q19. Create an ArrayList and insert integers 1 through 10. Display the
 * ArrayList. Add all the even numbers up and display the result. Add all
 * the odd numbers up and display the result. Remove the prime numbers
 * from the ArrayList and print out the remaining ArrayList.
*/

public class Question19
{
	public static void main(String[] args)
	{
		List<Integer> nums = new ArrayList<>();
		
		// Fill list
		for (int i = 0; i < 10; i++)
			nums.add(i + 1);
		
		System.out.println(nums);
		
		int evenTotal = 0;
		int oddtotal = 0;
		
		// Add up evens and odds
		for (int i : nums)
		{
			if (i % 2 == 0)
				evenTotal += i;
			else
				oddtotal += i;
		}
		
		// Print total results
		System.out.println("The total of all even numbers one through ten is " + evenTotal);
		System.out.println("The total of all odd numbers one through ten is " + oddtotal);
		
		// Remove all primes
		for (int i = 0; i < nums.size(); i++)
		{
			if (Question9.isPrime(nums.get(i)))
				nums.remove(i);
		}
		
		System.out.println("These are the composite numbers between one and ten:\n" + nums);
	}
}
