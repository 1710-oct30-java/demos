package question15;

/*
 * class that implements the interface where all of these methods are 
 * originally defined. basic mathematical operation
 */

public class Question15 implements Question15Interface{

	@Override
	public int addition(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 + num2;
	}

	@Override
	public int subtraction(int num1, int num2) {
		// TODO Auto-generated method stub
		return num2 - num1;
	}

	@Override
	public int multiplication(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 * num2;
	}

	@Override
	public int division(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 / num2;
	}

}
