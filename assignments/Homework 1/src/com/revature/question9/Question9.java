package com.revature.question9;

import java.util.ArrayList;

public class Question9 {
	static boolean isPrime(int n) {
		if (n % 2 == 0)
			return false;
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {

		ArrayList<Integer> aList = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i++) {
			aList.add(i);
			if (isPrime(aList.get(i - 1))) {
				System.out.println(i + " is a prime number");
			}
		}
	}
}
