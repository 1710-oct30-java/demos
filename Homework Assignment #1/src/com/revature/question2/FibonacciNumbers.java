package com.revature.question2;

public class FibonacciNumbers {

		public static void main (String[] args)
		{
		         int fiboCount = 15;
		         int[] fib = new int[fiboCount];
		         fib[0] = 0;
		         fib[1] = 1;
		         for(int i=2; i < fiboCount; i++){
		             fib[i] = fib[i-1] + fib[i-2];
		         }
		 //Print the sequence of numbers
		         
		         for(int i=0; i< fiboCount; i++){
		                 System.out.print(fib[i] + " ");
		         }
		    }
		
			
		
	}


