package question4;

import java.util.Scanner;

/***
 * Write a program to compute N factorial
 */
public class Q4 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number you want to factorial of");
		int userInput = scan.nextInt();
		System.out.println(factorial(userInput));

	}

	public static int factorial(int num) {

		int sum = 1;
		for (int i = 1; i <= num; i++) {
			sum = sum * i;
		}

		return sum;

	}

}
