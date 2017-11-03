package question11;

import question11b.FloatContainer;

/***
 * Write a program that would access two float-variables from class that exists
 * in another package. Note, you will need to create two packages to demonstrate
 * the solution
 */
public class Q11 {

	public static void main(String[] args) {

		FloatContainer Q11bFloat = new FloatContainer();

		float Q11Num1 = Q11bFloat.num1;
		float Q11Num2 = Q11bFloat.numb2;
		
		System.out.println("First float variable from another package : " +Q11Num1 );
		System.out.println("Second float variable from another package : " +Q11Num2 );
	}

}
