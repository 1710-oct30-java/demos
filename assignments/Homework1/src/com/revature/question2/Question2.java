package com.revature.question2;

/*
 * Display first 25 Fibonacci numbers beginning at 0
 */

public class Question2 {
	
	public static void main(String[] args) {
		
		int totalNum = 25;
		int first = 0;
		int second;
		int third;
		
		/* broken down computation of how we get first 3 numbers if we start from 0 */
		
		if (first == 0) {
			second = 1;
			third = first + second;
			System.out.println(first);
			System.out.println(second);
			System.out.println(third);
			first = second;
			second = third;
			
			for(int i = 3; i < totalNum; i++) {
				third = first + second;
				System.out.println(third);
				first = second;
				second = third;
						
			}
			
			
		}
		
		
	}

}
