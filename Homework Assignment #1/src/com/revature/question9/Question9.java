package com.revature.question9;

import java.util.ArrayList;
//Robert Choboy
//Homework assignment Week 1 Question 9

public class Question9 {

	public static void main (String[]  args)
	{
		
		ArrayList <Integer> values = new ArrayList <Integer>();
		
		for (int n=0; n <100; n++) {
			values.add(n+1);}
				
		//Check Prime
		
		for (int n = 0; n <100; n++) {
			if (checkPrime(values.get(n))) {
				System.out.println(values.get(n));
			}
		}
			
		}
		
			public static boolean checkPrime (int i) {
				for (int n = 2; n<i; n++){
					if (i%n==0)
						return false;
					
				}
				        return true;
				        
			}
}

			
			
		
		
	
		



