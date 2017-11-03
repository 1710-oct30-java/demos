package com.homeworkOne.problemSeventeen;

import java.util.Scanner;

public class ProblemSeventeen {
	public static void main(String[] args) {
		//Program to calculate simple interest
		
		//Init variables
		Scanner input = new Scanner(System.in);
		double principal = 0, rate = 0, total;
		int time = 0;
		
		//Take in user input
		System.out.println("Enter principal: ");
		principal = input.nextDouble();
		System.out.println("Enter rate: ");
		rate = input.nextDouble();
		System.out.println("Enter Number of Months: ");
		time = input.nextInt();
		
		//Interest Calculation
		total = principal*rate*time;
		System.out.println(total);
		
	}
}
