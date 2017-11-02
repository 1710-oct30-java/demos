package assignments.week01.question15;

/**
 * represents a calculator 
 * 
 * @author john.w.brown.jr@gmail.com
 *
 * @param <T>
 */
public interface CalculatorInterface<T extends Number> {

	public T add(T a, T b);
	
	public T subtract(T a, T b);
	
	public T multiply(T a, T b);
	
	public T divide(T a, T b);
}
