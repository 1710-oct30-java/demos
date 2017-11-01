package assignment1;

public class Question2
{
	// Write a program to display the first 25 Fibonacci numbers starting at 0.
	public static void main(String[] args)
	{
		System.out.println("The first 25 Fibonacci numbers are...");
		long x = 0;
		long y = 1;
		System.out.println(x);
		for(int a = 0; a < 12; a++)
		{
			System.out.println(x+y);
			y = x+y;
			System.out.println(x+y);
			x = x+y;
		}
	}
}