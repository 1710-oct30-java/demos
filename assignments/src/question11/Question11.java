package question11;

import question11floats.Question11Floats;

public class Question11
{
	// Write a program that would access two float-variables
	// from a class that exists in another package. Note, you
	// will need to create two packages to demonstrate the solution.
	public static void main(String[] args)
	{
		Question11Floats q11f = new Question11Floats();
		
		System.out.println("There are two float values: " + q11f.floatOne + " and " + q11f.floatTwo);
	}
}