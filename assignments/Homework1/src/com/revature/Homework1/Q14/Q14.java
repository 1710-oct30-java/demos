package com.revature.Homework1.Q14;

import java.util.Calendar;

public class Q14 {
	public static void main(String[] args) {
		for(int i = 1; i <= 3; i++) {
			switch(i) {
				case 1:
					System.out.println("\nCase 1:");
					System.out.println("sqrt 16 = " +Math.sqrt(16.0));
					break;
				case 2:
					System.out.println("\nCase 2:");
					//Date today = new Date();
					Calendar myCalender = Calendar.getInstance();
					String date =  (myCalender.get(Calendar.MONTH)+1)+"/"+myCalender.get(Calendar.DAY_OF_MONTH)+"/"+myCalender.get(Calendar.YEAR);
					System.out.println("Today's date is "+date);
					break;
				case 3:
					System.out.println("\nCase 3:");
					String initial = "I am learning core Java";
					String[] splitString = initial.split(" ");
					System.out.println("initial string:\n"+initial+"\n\nNow I split it: ");
					for(int j =0;j<splitString.length;j++) {
						System.out.println(splitString[j]);
					}
					break;
				default:
					System.out.println("I should not be here . . .");
					break;
			}
		}
	}
}
