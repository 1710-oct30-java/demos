package question11a;

import question11b.IHaveFloats;

/*
 * Q11. Write a program that would access two float-variables from a class that exists in another package.  Note, you will need to create 2 packages to demonstrate this solution.
 */
public class Question11 {

 	public static void main(String[] args) {
 		//Grab the floats from the other package
		float newFloata = IHaveFloats.a;
		float newFloatb = IHaveFloats.b;
		//Print out these floats
		System.out.println("I am from another package: " + newFloata);
		System.out.println("I am also from another package: " + newFloatb);
	}
}
