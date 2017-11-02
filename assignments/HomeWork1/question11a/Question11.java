package question11a;

import question11b.IHaveFloats;

/*
 * Q11. Write a program that would access two float-variables from a class that exists in another package.  Note, you will need to create 2 packages to demonstrate this solution.
 */
public class Question11 {

	public static void main(String[] args) {
		// Grab the floats from the other package
		float newFloata = IHaveFloats.a;
		float newFloatb = IHaveFloats.b;
		IHaveFloats holder = new IHaveFloats();
		// Print out these floats
		System.out.println("I am a static from another package: " + newFloata);
		System.out.println("I am also a static from another package: " + newFloatb);
		System.out.println("I am a nonstatic from another package" + holder.notStaticA);
		System.out.println("I am aother nonstatic from another package" + holder.notStaticB);
	}
}
