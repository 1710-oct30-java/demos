package com.question14;

import java.util.Arrays;
import java.util.Scanner;
/*
 * switch cases 
 * 1 - find square root
 * 2 - display date
 * 3 - split string and store in string array
 */
public class Question14
{	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Question14Helper helper = new Question14Helper();
		String str = "I am learning Core Java";
		
		System.out.print("From 1-3: ");
		int choice = input.nextInt();
		
		switch(choice)
		{
			case 1: 
				helper.getSqrt();	
				break;
			case 2: 
				helper.getCurDate();
				break;
			case 3: 
				String[] words = str.split(" ");
				System.out.println(Arrays.toString(words));
				break;
			default:
				System.out.println("Wrong Selection");
		}
	}
}
