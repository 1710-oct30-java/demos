package question15;

/**
 * Question 15: Write a program that defines an interface having the following methods: 
 * addition, subtraction, multiplication, and division. Create a class 
 * that implements this interface and provides appropriate functionality
 * to carry out the required operations
 * @author Mitch Goshorn
 *
 */
public interface ArithmeticInterface<T> {
	public void addition(T y);
	public void subtraction(T y);
	public void multiplication(T y);
	public void division(T y);
}
