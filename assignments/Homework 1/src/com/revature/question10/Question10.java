package com.revature.question10;

public class Question10 {
	static void whichIsLess(int a, int b) {
		int minVal = a < b ? a : b;
		System.out.println(minVal);
	}

	public static void main(String[] args) {

		int x = 5;
		int y = 3;
		
		whichIsLess(x, y);
	}
}
