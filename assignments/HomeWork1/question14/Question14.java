package question14;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.stream.Stream;

/*
 * Q14.  Write a program that demonstrates the switch case. Implement the following functionalities in the cases:
 * 
 * Case 1: Find the square root of a number using the Math class method.
 * Case 2: Display today's date.
 * Case 3: Split the following string and store it in a sting array
 * 					"I am learning Core Java"
 */
public class Question14 {

	public static void main(String[] args) {
		//if there is no input then we can't run
		if (args.length < 1) {
			System.out.println("Not enough Arguements!");
			return;
		}
		Scanner scanner;
		switch (Integer.parseInt(args[0])) {
		case 1:
			//grab a Number from input and output the square root of it using the Math Class
			System.out.println("Please input a number so we can try to find the square root of it");
			scanner = new Scanner(System.in);
			double number = scanner.nextDouble();
			scanner.close();
			double sqrt = Math.sqrt(number);
			System.out.println("The square root of " + number + " is " + sqrt);
			break;
		case 2:
			//use LocalDate to get today's date.  Then print out that date.
			LocalDate date = LocalDate.now();
			System.out.println("Today's date is: " + date);
			break;
		case 3:
			//Split the string via String.split() and store the returned String array into a String array.
			String splitOnThis = " ";
			String phraseToSplit = "I am Learning Core Java";
			System.out.println("We will now split 'I am learning Core Java'");
			String[] result = phraseToSplit.split(splitOnThis);
			Stream.of(result).forEach(System.out::println);
			break;
		default:
			//We were only needing case 1 through 3.  If the input isn't between 1 and 3 then call default.
			System.out.println("Well that wasn't one of the options");
			break;
		}
	}
}
