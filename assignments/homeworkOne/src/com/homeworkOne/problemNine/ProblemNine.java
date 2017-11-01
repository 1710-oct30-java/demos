package com.homeworkOne.problemNine;

import java.util.ArrayList;
import java.util.List;

public class ProblemNine {
	
	public static void main(String[] args) {
		List<Integer> primes = new ArrayList<>();
		
		for(int i = 0; i<100; i++)
		{
			if(PrimeChecker(i))
				primes.add(i);
		}
		System.out.println("Primes from 1-100:");
		for(Integer each: primes)
		{
			System.out.print(each + " ");
		}
		
	}
	
	static boolean PrimeChecker(int number)
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
