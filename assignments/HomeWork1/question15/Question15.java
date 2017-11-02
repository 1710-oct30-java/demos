package question15;

/*
 * Write a program that defines an interface having the following methods: addition,
 * subtraction, multiplication, and division.  Create a class that implements this interface
 * and provides appropriate functionality to carry out the required operations.  Hard code 
 * two operands in a test class have a main method that calls the implementing class.
 */
public class Question15 implements Question15Inteface<Integer> {

	private int num1;
	private int num2;

	public Question15() {
		super();
		num1 = 3;
		num2 = 4;
	}

	@Override
	public Integer addition(Integer num1, Integer num2) {
		return num1 + num2;
	}

	@Override
	public Integer subtraction(Integer num1, Integer num2) {
		return num1 - num2;
	}

	@Override
	public Integer multiplication(Integer num1, Integer num2) {
		return num1 * num2;
	}

	@Override
	public double division(Integer num1, Integer num2) {
		return num1.doubleValue() / num2.doubleValue();
	}

	// toString so we can print out what this class is supposed to do.
	@Override
	public String toString() {
		return "Numbers are: " + num1 + " " + num2 + " |" + " Addition:" + this.addition(num1, num2) + " "
				+ " Subtraction: " + this.subtraction(num1, num2) + " " + " Multiplication: "
				+ this.multiplication(num1, num2) + " " + " Division: " + this.division(num1, num2);
	}

	public static void main(String[] args) {
		Question15 test = new Question15();
		System.out.println(test.toString());
	}

}
