// Christopher Youngblood
// 10/30/2017
// Revature Java Course
// Homework 1 - Question 1

package com.revature.javahw.q1;

import java.util.Arrays;

//Q1. Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4
//assumed to be ascending

public class Q1 {

	public static void main(String[] args) {
		int array[] = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.println(Arrays.toString(array));
		
		boolean done;
		do {
			done = true;
			for(int i = 0; i < (array.length - 1); i++ ) {
				
				if (array[i] > array[i+1]) {
					//we're not done, so update
					done = false;
					//swap
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					
					//print out an updated list
					System.out.println(Arrays.toString(array));
				}
			}
		}
		while (done == false);
	}
}
