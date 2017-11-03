package com.revature.Homework1.Q9;

import java.util.ArrayList;

public class Q9 {
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i ++) {
			nums.add(i);
		}
		for(int i = 0; i < nums.size(); i ++) {
			if(isPrime(nums.get(i))) {
				System.out.println(nums.get(i));
			}
		}
	}
	static boolean isPrime(int n) {
		if(n == 1) {return false;}
		if(n == 2) {return true;}
		for(int i = 2; i < n; i++) {
			if(n%i == 0) {return false;}
		}
		return true;
	}
}
