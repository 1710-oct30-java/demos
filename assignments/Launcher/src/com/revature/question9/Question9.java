package com.revature.question9;

import java.util.ArrayList;

public class Question9 {
	
	public static boolean isPrime(int n) {
		for (int i=2; i < n;i++) {
			if (n%i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		
		ArrayList<Integer> al = new ArrayList<Integer>(100);
		ArrayList<Integer> pal = new ArrayList<Integer>();
		
		for (int i = 1; i < 101;i++) {
			al.add(i);
			
			if(isPrime(al.get(i-1))) {
			pal.add(al.get(i-1));
			}
		}
		System.out.println(pal);
	}
}
