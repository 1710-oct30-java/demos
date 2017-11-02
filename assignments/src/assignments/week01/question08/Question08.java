package assignments.week01.question08;

import java.util.ArrayList;

public class Question08 {

	public static void main(String[] args) {
		StringCollection strings = new StringCollection();
		
		generateTestData( strings );	// inject test data		
		strings.sort(); 				// sort list
		display( strings );				// display results to console
	}
	
	/**
	 * injects test data into the StringCollection passed
	 * 
	 * @param strings
	 */
	public static void generateTestData(StringCollection strings)
	{
		strings
			.add("karan")
			.add("madam")
			.add("Tom")
			.add("Civic")
			.add("radar")
			.add("sexes")
			.add("Jimmy")
			.add("kayak")
			.add("John")
			.add("refer")
			.add("Billy")
			.add("did");
	}
	
	/**
	 * displays a customized view of the string collection
	 * to the console
	 * 
	 * @return String
	 */
	public static void display(StringCollection strings)
	{
		StringBuilder sb = new StringBuilder();
		
		/*
		 * storing palindromes in an ArrayList
		 */
		ArrayList<String> palindromes = new ArrayList<>();
		palindromes.addAll( strings.getPalindromes() );
		
		sb.append( String.format("StringCollection::\n\tALL:{ %s }\n\tPALINDROMES:{ %s }", 
			strings.getAll(), 
			palindromes 
		));
		
		System.out.println( sb );
	}
}
