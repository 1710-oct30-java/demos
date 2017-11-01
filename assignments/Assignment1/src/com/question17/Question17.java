package com.question17;
/*
 * takes in principal, rate, time from user and calculate interest
 */
import java.util.Scanner;

public class Question17
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String input;
		double interest, time, principal, rate;
		
		System.out.print("Enter Principal: ");
		input = scanner.nextLine();
		principal = Double.parseDouble(input);
		
		System.out.print("Enter Rate: ");
		input = scanner.nextLine();
		rate = Double.parseDouble(input);
		
		System.out.print("Enter Duration (year): ");
		input = scanner.nextLine();
		time = Double.parseDouble(input);
		
		System.out.println("Your interest is: $"+ principal * rate * time);
		
		
		
		
		
	}
}
