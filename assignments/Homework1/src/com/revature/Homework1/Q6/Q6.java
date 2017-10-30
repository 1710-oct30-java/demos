package com.revature.Homework1.Q6;

public class Q6 {
	/* 
	 * check if an int is even without %
	 */
	public static void main(String[] args) {
		System.out.println(isEven(1234));//true
		System.out.println(isEven(-1234));//true
		System.out.println(isEven(0));//true
		System.out.println(isEven(3));//false
		System.out.println(isEven(-4));//true
	}
	public static Boolean isEven(int n) {
		if(n < 0) {n = n*-1;}
		while(n > 0) {
			n -= 2;
		}
		if(n == 0) {return true;}
		return(false);
	}
}
