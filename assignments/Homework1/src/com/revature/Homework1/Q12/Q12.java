package com.revature.Homework1.Q12;

public class Q12 {
	// store 1-100; print them out with 'enhanced' for loop
	public static void main(String[] args) {
		int[] nums = new int[100];
		//normal
		for(int i = 1; i<=100; i++) {
			nums[i-1] = i;
		}
		//OMG ENHANCED!!!
		for(int i : nums) {
			if(i%2 == 0) {
				System.out.println(i);
			}
		}
	}
}
