package question15;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Question 15: Write a program that defines an interface having the following methods: 
 * addition, subtraction, multiplication, and division. Create a class 
 * that implements this interface and provides appropriate functionality
 * to carry out the required operations
 * @author Mitch Goshorn
 *
 */
public class ArithemticUnitTest {
	
	@Test
	public void AdditionTest() throws Exception {
	
		IntegerType a = new IntegerType(5);
		IntegerType b = new IntegerType(6);
		
		int x = a.getValue();
		int y = b.getValue();
	
		a.addition(b);
		x = x + y;
		
		assertTrue(a.getValue() == x);
	}
	
	@Test
	public void SubtractionTest() throws Exception {
	
		IntegerType a = new IntegerType(10);
		IntegerType b = new IntegerType(5);
		
		int x = a.getValue();
		int y = b.getValue();
	
		a.subtraction(b);
		x = x - y;
		
		assertTrue(a.getValue() == x);
	}
	
}
