package com.revature.homework.question17;

import java.util.Scanner;
// write a program to calculate interest using user input
public class Question17 {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	
	System.out.println("What is the principle? (Enter a number)");
	double p = scan.nextDouble();
	System.out.println("What is the rate? (Enter a decimal number)");
	double r = scan.nextDouble();
	System.out.println("What is the time? (Enter a number)");
	double t = scan.nextDouble();
	
	System.out.println("Your interest is: $"+interest(p,r,t));
	
}
	public static double interest(double principle, double rate, double time) {
		return principle*rate*time;
	}
}
