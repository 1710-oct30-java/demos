package com.question14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Question14Helper
{
	public void getSqrt()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Num: ");
		double num = input.nextDouble();
		System.out.println("Squareroot of "+num + " is "+ Math.sqrt(num));
	}
	
	public void getCurDate()
	{
		DateFormat dateForm = new SimpleDateFormat("MMM-dd-yyy HH:mm:ss");
		Date date = new Date();
		System.out.println(dateForm.format(date));
	}
}
