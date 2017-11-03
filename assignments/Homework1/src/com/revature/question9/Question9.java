package com.revature.question9;

import java.util.ArrayList;
import java.util.List;

/*
 * Create ArrayList to store numbers from 1 to 100 and prints out all the prime numbers to
 * console
 */
public class Question9 {

	public static void main(String[] args) {

		List<Integer> nums = new ArrayList<Integer>();
		int temp = 0;

		for (int i = 1; i <= 100; i++) {
			nums.add(i);
		}
		
		for (int i = 0; i < nums.size(); i++) {
			int counter  = 0;
			for (temp = i + 1; temp >= 1; temp--) {
				if(i % temp == 0)
					counter = counter + 1;
			}
			if (counter == 2)
				System.out.print(i + " ");
		}
			
		
		
	}
}
