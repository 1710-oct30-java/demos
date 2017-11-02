package question15;

//Generic Interface.  Division is double for that increased accuracy
public interface Question15Inteface<T extends Number> {
	T addition(T num1, T num2);

	T subtraction(T num1, T num2);

	T multiplication(T num1, T num2);

	double division(T num1, T num2);

}
