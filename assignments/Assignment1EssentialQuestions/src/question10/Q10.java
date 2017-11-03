package question10;

import java.util.Scanner;

/***
 * Find the minimum of two numbers using ternary operators.
 *
 */
public class Q10 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Please enter the first number");

		int num1 = scan.nextInt();

		System.out.println("Please enter the first number");

		int num2 = scan.nextInt();
		
		System.out.println(num1>num2?"Num 1 is greater":"Num 2 is greater");

	} 

}
