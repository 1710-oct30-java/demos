package com.revature.question14;

import java.util.Date;

public class Question14 {

	public static void main(String[] args) {
		int test = 1;
		
		switch (test) {
		
			case 1: 
					System.out.println("The square root is " + Math.sqrt(100));
					System.out.println();
					break;
			
			case 2: 
					Date d = new Date();
					System.out.println(d.toString());
					break;
			
			case 3: 
					String s = "I am learning Core Java";
					String[] stringArray = s.split(" ");
					
					for (String str : stringArray)
						System.out.println(str);
					
					break;
					
			default: break;
		}
	}
	
}
