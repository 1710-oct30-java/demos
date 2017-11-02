package assignments.week01.question08;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * encapsulates a String collection to add functionality
 * 
 * @author john.w.brown.jr@gmail.com
 */
public class StringCollection {

	
	private List<String> strings;						// collection that is encapsulated by the class
	private Comparator<String> comparator;				// encapsulated logic for sorting strings in the collection
	private Map<String, Predicate<String> > filters;	// map of filters that can be applied to the collection streams
								
	public StringCollection()
	{
		super();
		
		this.strings = new ArrayList<String>();		
		this.comparator = new StringComparator();
		this.filters = new HashMap<>();
		
		this.filters.put("palindrome", new PalindromeStreamFilter() ); // add the palindrome stream filter
	}
	
	/**
	 * sorts underlying collection using comparator logic
	 */
	public void sort()
	{
		this.strings.sort( this.comparator );
	}
	
	/**
	 * adds a string to the collection
	 * 
	 * @param String s
	 * 
	 * @return self
	 */
	public StringCollection add(String s)
	{
		this.strings.add(s);
		return this;
	}
	
	/**
	 * returns all strings in the collection
	 * 
	 * @return List<String>
	 */
	public List<String> getAll()
	{
		return this.strings;
	}
	
	/**
	 * returns all strings that are palindromes in the collection
	 * 
	 * @return List<String>
	 */
	public List<String> getPalindromes()
	{
		return this.strings.stream()
				.filter( this.filters.get("palindrome") )
				.collect( Collectors.toList() );
	}

}
