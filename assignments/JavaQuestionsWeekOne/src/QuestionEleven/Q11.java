package QuestionEleven;
import questionElevenClass.Q11Class;

public class Q11 {

	// Write a program that would access two float-variables from a class that
	// exists in another package. Note: you will need to create two packages to
	// demonstrate the solution.

	public static void main(String[] args) {
		Q11Class otherPackageClass = new Q11Class(12.3f, 15.2f);
		
		//Add the two floats together.
		System.out.println(otherPackageClass.getFloatOne() + otherPackageClass.getFloatTwo());
	}

}
