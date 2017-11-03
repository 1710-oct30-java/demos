package question15;

public class Calculator implements Calculations
{
	// Adds A and B together and returns the result.
	@Override
	public int addition(int a, int b)
	{
		return a + b;
	}

	// Subtracts B from A and returns the result.
	@Override
	public int subtraction(int a, int b)
	{
		return a - b;
	}

	// Multiplies A times B and returns the result.
	@Override
	public int multiplication(int a, int b)
	{
		return a * b;
	}

	// Divides A by B and returns the result.
	@Override
	public int division(int a, int b)
	{
		return a / b;
	}
}