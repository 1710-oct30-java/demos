package question4;
import java.util.Scanner;
/*
 * Write a program to compute N factorial
 */
public class QuestionFour 
{
	public static void main(String[] args)
	{
		//get user input
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int n = reader.nextInt(); 
		reader.close();
		
		int factorial= 1;		
		//n factorial
		for(int i=1; i<=n; i++)
		{
			factorial=i*factorial;
		}
		System.out.println(factorial);
	}
}
