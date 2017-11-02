package assignments.week01.question17;

/**
 * represents an interest calculator
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class InterestCalculator 
{
	/**
	 * 
	 * @param Double principal
	 * @param Double rate
	 * @param Integer time
	 * 
	 * @return Double
	 */
	public Double calculate(Double principal, Double rate, Integer time)
	{
		return principal * rate * time;
	}
}
