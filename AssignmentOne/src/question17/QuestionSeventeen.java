package question17;
/*
 * Write a program that calculates the simple interest on the principal,
 * rate of interest and number of years provided by the user. Enter
 * principal, rate, and time through the console using the Scanner class.
 * Interest = Principal*Rate*Time
 */
import java.util.Scanner;

public class QuestionSeventeen 
{
	public static void main(String[] args) {
		double principal, rate, time;
		
		System.out.println("Enter principal: ");
		Scanner sc = new Scanner(System.in);
		principal = sc.nextDouble();
		System.out.println("Enter rate of interest: ");
		rate = sc.nextDouble()/100;
		System.out.println("Enter number of years: ");
		time = sc.nextDouble();
		sc.close();
		System.out.println("Your interest is: "+ principal*rate*time);
		
	}
}
