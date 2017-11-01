package q15;

public class ArithmeticTest {
	public static void main(String[] args) {
		//testing on operands 2 and 4
		int a = 2;
		int b = 4;
		ArithmeticImplementation test = new ArithmeticImplementation();
		System.out.println("add: " + test.addition(a,b));
		System.out.println("multiply: " + test.multiplication(a, b));
		System.out.println("divide: " + test.division(a, b));
		System.out.println("subtract: " + test.subtraction(a, b));
	}
}
