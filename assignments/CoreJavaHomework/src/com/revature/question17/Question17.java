package com.revature.question17;

import java.util.Scanner;

/*
 * Write a program that calculates the simple interest
 * on the principal, rate of interest and number of years 
 * provided by the user. Enter principal, rate and time 
 * through the console using the Scanner class
 * 
 * Interest = Principal*Rate*Time
 */
public class Question17 {
	
	public static void main(String[] args) {
		//Create scanner to read user input
		Scanner input = new Scanner(System.in);
		//Ask user for principal and store in principal variable
		System.out.println("enter principal: ");
		double principal = Double.parseDouble(input.nextLine());
		
		//Ask user for rate and store in rate variable
		System.out.println("enter rate of interest: ");
		double rate = Double.parseDouble(input.nextLine());
		
		//Ask user for time and store in time variable
		System.out.println("enter the number of years: ");
		int time = Integer.parseInt(input.nextLine());

		double interest = principal * rate * time;
		
		System.out.println("The simple interest is: " + interest);
	}
}
