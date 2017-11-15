package com.revature.Q9;

import java.util.ArrayList;

public class PrimeNumbers {
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		boolean prime = true;
		
		for(int i = 1; i <= 100; i++) {
			numbers.add(i);
		}
		
		for(int j = 2; j < 100; j++) {
			prime = true;
			for (int k = 2; k < numbers.get(j); k++) {
				if(numbers.get(j)%k==0) {
					k = numbers.get(j);
					prime = false;
				}
				else {
					
				}
			}
			if(prime==true) {
				System.out.println(numbers.get(j));
			}
		}
	}
}
