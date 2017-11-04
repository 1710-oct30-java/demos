package com.revature.question17;

import java.util.Scanner;

public class Question17 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("What is the principal?");
		double principal = scan.nextDouble();
		
		System.out.println("What is the rate of interest?");
		double rate = scan.nextDouble();
		
		System.out.println("Enter the number of years:");
		int time = scan.nextInt();
		
		double interest = principal*rate*time;
		
		System.out.println("The simple interest is " + interest);
	}

}