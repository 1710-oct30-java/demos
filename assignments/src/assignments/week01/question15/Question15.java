package assignments.week01.question15;

public class Question15 {
	public static void main(String[] args) {
		IntegerCalculator calc = new IntegerCalculator();
		
		/*
		 * test operands
		 */
		int a = 50;
		int b = 5;
		
		System.out.println( calc.add(a, b) );
		System.out.println( calc.subtract(a, b) );
		System.out.println( calc.multiply(a, b) );
		System.out.println( calc.divide(a, b) );
	}
}
