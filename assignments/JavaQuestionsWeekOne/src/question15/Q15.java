package question15;

public class Q15 {

	/*
	 * Write a program that defines an interface having the following methods:
	 * addition, subtraction, multiplication, and division. Create a class that
	 * implements this interface and provides appropriate functionality to carry out
	 * the required operations. Hard code two operands in a test class having a main
	 * method that calls the implementing class.
	 */

	public static void main(String[] args) {
		DoubleMath dm = new DoubleMath();
		
		System.out.println(dm.Add(10d, 20d));
		System.out.println(dm.Divide(10d, 2d));

	}

}


