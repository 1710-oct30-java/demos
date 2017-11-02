package assignments.week01.question15;

/**
 * a calculator for integer values
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class IntegerCalculator implements CalculatorInterface<Integer> {
	
	/**
	 * @param Integer a
	 * @param Integer b
	 * 
	 * @return Integer
	 */
	public Integer add(Integer a, Integer b)
	{
		return a + b;
	}
	
	/**
	 * @param Integer a
	 * @param Integer b
	 * 
	 * @return Integer
	 */
	public Integer subtract(Integer a, Integer b)
	{
		return a - b;
	}
	
	/**
	 * @param Integer a
	 * @param Integer b
	 * 
	 * @return Integer
	 */
	public Integer multiply(Integer a, Integer b)
	{
		return a * b;
	}
	
	/**
	 * @param Integer a
	 * @param Integer b
	 * 
	 * @return Integer
	 */
	public Integer divide(Integer a, Integer b)
	{
		Integer result;
		
		try {
			result = a / b;
		} catch (Exception e) {
			result = 0;		// return 0 if an attempt to divide by zero is made
		}
		
		return result;
	}
}
