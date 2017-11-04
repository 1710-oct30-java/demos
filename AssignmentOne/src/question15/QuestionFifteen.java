package question15;
/*
 * Write a program that defines an interface having the following
 * methods: addition, subtraction, multiplication, and division. 
 * Create a class that implements this interface and provides appropriate
 * functionality to carry out the required operations. Hard code two
 * operands in a test class having a main method that calls the 
 * implementing class.
 */
class QuestionFifteen implements MyInterface
{
	//adds the two integer parameters
	@Override
	public int add(int a, int b) {
		return a+b;
	}
	
	//subtracts the two integer parameters
	@Override
	public int subtract(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}
	
	//multiplies the two integer parameters
	@Override
	public int multiplication(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}
	
	//divides the two integer parameters
	@Override
	public int division(int a, int b) {
		/*
		 * if (b == 0)
		 * {
		 * 	  System.out.println("Cannot divide by zero.");
		 * }
		 */
		return a/b;
}
}