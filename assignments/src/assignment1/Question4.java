package assignment1;

public class Question4
{
	// Write a program to compute n factorial.
	public static void main(String[] args)
	{
		int n = 5;
		int factorial = 1;
		for(int x = n; x > 0; x--)
		{
			factorial = factorial * n;
		}
		System.out.println("The factorial of " + n + " is " + factorial + ".");
	}
}