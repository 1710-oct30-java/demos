package assignments.week01.question08;

import java.util.Comparator;

/**
 * encapsulates the logic for comparing strings
 * in a collection
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class StringComparator implements Comparator<String> {
	
	/**
	 * compare two strings and return an integer that is
	 * - negative 	( string a sorts before string b)
	 * - zero		( string a is equal to string b)
	 * - positive	( string a sorts after string b)		
	 * 
	 * comparison is case insensitive
	 * 	
	 * @param String a
	 * @param String b
	 * 
	 * @return int
	 */
	public int compare(String a, String b) {
		return a.compareToIgnoreCase(b);
	}
}
