package question14;
/*
 * Write a program that demonstrates the switch case. Implement the following 
 * functionalities in the cases:
 * Case 1: Find the square root of a number using the Math class method
 * Case 2: Display today's date.
 * Case 3: Split the following string and store it in a string array.
 * "I am learning Core Java"
 */
import java.lang.Math;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class QuestionFourteen 
{
	public static void main(String[] args) {
		System.out.println("Enter 1 to see the square root of 25.");
		System.out.println("Enter 2 to see todays date and time.");
		System.out.println("Enter 3 to split the string 'I am learning Core Java, and store it in a string array'.");
		
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		sc.close();
		
		String str = "I am learning Core Java.";
		
		switch(choice)
		{
		case 1: 
			System.out.println("The square root of 25 is "+ Math.sqrt(25));
			break;
		case 2: 
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			break;
		case 3:
			String[] strArray=str.split(" ", 5);
			for (String newStr : strArray)
			System.out.println(newStr);
			break;
		default:
			//default
		}
	}
}
