package com.revature.Q14;

import java.util.Date;

public class Switch {
	public static void main(String[] args) {
		
		int c = 1;
		
		switch (c){
			
		case 0:
		
		int x = 4;
		
		double y = Math.sqrt(x);
		System.out.println(y);
			
		break;
		
		case 1:
			
		Date date = new Date();
		System.out.println(date);
			
		break;
			
		case 2:
			
		String s = "I am learning Core Java";
		int count = 0;
		String[] splitArray = new String[5];
		
		for (String t:s.split(" ")) {
			splitArray[count] = t;
			count++;
		}
		
		break;
		
		
		}
	}
}
