/* Author: Stephen Huelsman
 * Write a program to display the first 25 Fibonacci numbers beginning at 0
 */
package com.revature.Q2;

public class Fibonacci {
	public static void main(String[] args) {
		int zero = 0;
		System.out.println(zero);
		int one = 1;
		System.out.println(one);
		int fibonacci = 0;
		for (int x = 0; x < 23; x++) {
			fibonacci = zero + one;
			System.out.println(fibonacci);
			zero = one;
			one = fibonacci;
		}
	}
}
