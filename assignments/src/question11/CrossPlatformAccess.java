package question11;

import question11.publicAccess.*;

/**
 * Question 11: Write a program that would access two 
 * float-variables from a class that exists in another package. Note, you will
 * need to create two packages to demonstrate the solution.
 * 
 * @author Mitch Goshorn
 *
 */
public class CrossPlatformAccess {
	public static void main(String[] args) {
		System.out.println(PublicAccess.floatX);
		System.out.println(PublicAccess.floatY);
	}
	
}
