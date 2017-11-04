package com.revature.question17;

import java.util.Scanner;

public class Question17 {
	
	public static void main(String[] args) {	
		System.out.println("Please input the amount of initial principle in whole Bitcoin!");
		Scanner cIn = new Scanner(System.in);
		double principal = cIn.nextDouble();
		System.out.println("Please input the amount of interest as a decimal");
		double interest = cIn.nextDouble();
		System.out.println("Please input the amount of years you intend to collect interest");
		double years = cIn.nextDouble();
		System.out.println(((principal*interest*years)+principal) + " is your new Bitcoin value!");
		cIn.close();		
	}
}
