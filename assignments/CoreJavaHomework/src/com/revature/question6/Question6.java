package com.revature.question6;

public class Question6 {
	//Write a program to determine if an integer is even
	//without using the modulus operator(%)
	public static void main(String[] args) {
		System.out.println(even(33));
	}
	
	//if an int is divided by 2 and them multiplied by 2 and is still the same number it is even due to int division
	public static boolean even(int n) {
		if(((n / 2)* 2) == n){
			return true;
		}
		else
			return false;
	}

}
