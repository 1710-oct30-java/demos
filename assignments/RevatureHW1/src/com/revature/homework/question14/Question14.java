package com.revature.homework.question14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// demonstrate use of the switch statement with three cases

public class Question14 {
	public static void main(String[] args) {
		int i=3;
		double num =5;
		switch (i) {
		case 1:
			System.out.println(Math.sqrt(num));
			break;
		case 2:
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date)); 
			break;
		case 3:
			String str = "I am learning core Jave";
			String[] strArr = str.split(" ");
			System.out.println(strArr[0]+strArr[1]+"\t split \t"+strArr[2]+strArr[3]+strArr[4]);
			break;
			
		}
	}
}
