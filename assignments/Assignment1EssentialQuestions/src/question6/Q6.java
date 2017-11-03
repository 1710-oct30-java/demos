package question6;

import java.util.Scanner;

/***
 * Write a program to determine if an integer is even without
 * using the modulus operator(%)
 */
public class Q6 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number to check if it's Even");
		int userInt = scan.nextInt();
		System.out.println(isEven(userInt));
	}
	
	public static boolean isEven(int num) {
		
		if(num/2*2==num) {
			return true;
		}
		else return false;
		
		
		
	}
	

}
