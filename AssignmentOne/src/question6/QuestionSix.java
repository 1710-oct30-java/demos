package question6;
/*
 * Write a program to determine if an integer is even without using 
 * the modulus operator(%)
 */
import java.util.Scanner;
public class QuestionSix 
{
	public static void main(String[] args)
	{
		//get user input
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int n = reader.nextInt();
		reader.close(); 
		
		//divide by user's input by 2
		int number = (n/2);
		
		//by multiplying by 2, we will receive either a number
		//that is equal if the number is even or a number that is less
		//if the number is odd
		if(number*2 == n)
		{
			System.out.println("n is even");
		}
		else
		{
			System.out.println("n is odd");
		}
		
	}
}
