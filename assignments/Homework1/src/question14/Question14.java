package question14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Question14 {

	private static final DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Please enter a number to complete an operation");
		System.out.println("Operation 1: calculate square root");
		System.out.println("Operation 2: Display today's date");
		System.out.println("Operation 3: String operation");
		Scanner in = new Scanner(System.in);
		int cases = Integer.parseInt(in.nextLine());
		
		switch(cases) 
		{
		case 1: 
			System.out.println("Please enter a number to calculate the square root of it: ");
			int num = in.nextInt();
			System.out.println(Math.sqrt(num));
			
			break;
			
		case 2:
			Date date = new Date();
			System.out.println("Today's Date is " + sdf.format(date));
			
			break;
			
		case 3:
			
			String[] strArray = "I am learning Core Java".split("");
			System.out.println(Arrays.toString(strArray));
			
			break;
		}
	}

}
