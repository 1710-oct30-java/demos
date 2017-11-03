package com.homeworkOne.problemNineteen;

import java.util.ArrayList;
import java.util.List;
public class ProblemNineteen {
	public static void main(String[] args) {

		//Init variables
		List<Integer> ar = new ArrayList<>();
		int counter;
		
		//Add values to List
		for(int i = 0; i < 10; i++) {
			ar.add(i+1);
		}
		counter = ar.size();
		//Call Methods
		System.out.println(ar);
		System.out.println("Sum of even numbers: "+ addEven(ar));
		System.out.println("Sum of odd numbers: "+ addOdd(ar));
		for(int i = counter; i>0; i--)
		{
			if(i==2||PrimeChecker(i))
				ar.remove(i-1);
		}
		System.out.println("List without primes: "+ ar);
		
	}
	public static int addEven(List<Integer> ar) { //Add even numbers
		int result = 0;
		for (Integer each : ar) {
			if (each % 2 == 0)
				result += each;
		}
		return result;
	}
	
	public static int addOdd(List<Integer> ar) { //Add odd numbers
		int result = 0;
		for (Integer each : ar) {
			if (!(each % 2 == 0))
				result += each;
		}
		return result;
	}
	
	static boolean PrimeChecker(int number) //Check for removing prime numbers
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
