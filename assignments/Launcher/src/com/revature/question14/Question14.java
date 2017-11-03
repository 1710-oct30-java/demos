package com.revature.question14;

import java.util.Date;
import java.lang.Math;

public class Question14 {

	int test = 1;
	
	switch (test) {
	
		case 1: Math.sqrt(100);
				break;
		
		case 2: Date d = new Date();
				System.out.println(d.toString());
				break;
		
		case 3: String s = "I am learning Core Java";
				String[] stringArray = s.split(" ");
				break;
				
		default: break;
	}
}
