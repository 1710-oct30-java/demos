package question14;

import java.util.Date;
import java.util.Scanner;

/***
 * Write a program that demonstrates the switch case. Implement the following
 * functionalities in the cases: Case 1: Find the square root of a number using
 * the Math class method. Case 2: Display today's date. Case 3: Split the
 * following string and store it in a string array. "I am Learning Core Java"
 *
 */
public class Q14 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		 System.out.println("Please enter a case number 1, 2 or 3");
		
		 int userCase = scan.nextInt(); 

		
		switch (userCase) {

		case 1:
			int j = 25;
			double jSqRoot = Math.sqrt(j);
			
			System.out.println(jSqRoot);
			
			break;

		case 2:
			
			Date dt = new Date();
			System.out.println(dt.toString());
			break;
			
			
		case 3:
			String str = "I am Learning Core Java";		
			String[]  strArr = str.split(" ");
			for(int i =0; i <strArr.length; i++) {
				
				System.out.println(strArr[i]);
			}
			
			break;
		}


	}

}
