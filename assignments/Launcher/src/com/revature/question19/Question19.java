package com.revature.question19;

import java.util.ArrayList;


public class Question19 {
	
	static boolean checkPrime(int n) {
		for (int i=2; i < n;i++) {
			if (n%i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>(10);
		ArrayList<Integer> oal = new ArrayList<Integer>();
		ArrayList<Integer> eal = new ArrayList<Integer>();
		ArrayList<Integer> pal = new ArrayList<Integer>();
		for (int i = 1; i < 11; i++) {
			al.add(i);
			
			if (i%2 == 0) {
				eal.add(i);
			}
			
			else {
				oal.add(i);
			}
			
			if(checkPrime(al.get(i-1))) {
				pal.add(al.get(i-1));
				}
		}
		
		
		System.out.println(al);
		System.out.println(eal);
		System.out.println(oal);
		System.out.println(pal);
		
	}

}
