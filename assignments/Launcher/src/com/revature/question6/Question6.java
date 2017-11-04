package com.revature.question6;


public class Question6 {
	public static void isEven(int n) {
		
		// finds whether a number is even or odd.
		// if it is odd, then dividing an odd-numbered
		// int by 2 would round it down, meaning that
		// if you multiply it by 2 again then you
		// won't get the same answer.
		// 
		// But if you divide an even number by 2 and
		// then multiply it by 2 again, then you will
		// get the number n that you orginally had before
		int quotient = n/2;
		if (n == quotient * 2)
			System.out.println(n + " is even");
		else {
			System.out.println(n + "is odd");
		}
	}
	
	public static void main(String[] args) {
		isEven(8);
	}

}
