package com.homeworkOne.problemNine;

import java.util.ArrayList;
import java.util.List;

public class ProblemNine {
	
	public static void main(String[] args) {
		//Init variables
		List<Integer> primes = new ArrayList<>();
		
		//Call method to check prime numbers
		for(int i = 0; i<100; i++)
		{
			if(i==2||PrimeChecker(i))
				primes.add(i);
		}
		//Print result
		System.out.println("Primes from 1-100:");
		for(Integer each: primes)
		{
			System.out.print(each + " ");
		}
		
	}
	
	static boolean PrimeChecker(int number)//Method to check prime numbers
	{
		if(number%2 == 0)
			return false;
		for(int i=3; i*i<=number; i+=2) 
		{
	        if(number%i == 0)
	            return false;
	    }
	    return true;
	}
}
