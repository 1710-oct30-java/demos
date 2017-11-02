package assignments.week01.question12;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Question12 {

	public static void main(String[] args) {
		
		int digits = 100; 													// number to count up to
		List<Integer> numbers = generateNumberSequence( digits );			// generate number sequence
		List<Integer> evenNumbers = numbers									// filter out even numbers by stream
				.stream()
				.filter( value -> ( value % 2) == 0 )
				.collect( Collectors.toList() );
		
		display( evenNumbers);												// display to console
				
	}
	
	/**
	 * generate number sequence
	 * 
	 * @param int digits
	 * 
	 * @return List<Integer>
	 */
	public static List<Integer> generateNumberSequence(int digits)
	{
		List<Integer> output = new ArrayList<>();
		
		for(int i = 0; i < digits; i++ ) {
			output.add(  ( i + 1) );
		}
		
		return output;
	}
	
	/**
	 * prints a list of integers to the console
	 * using an enhanced For loop
	 * 
	 * @param List<Integer> values
	 */
	public static void display(List<Integer> values )
	{
		for(Integer value: values ) {
			System.out.println( value );
		}
	}
	
}
