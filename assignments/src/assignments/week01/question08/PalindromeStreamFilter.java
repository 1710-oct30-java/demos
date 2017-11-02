package assignments.week01.question08;

import java.util.function.Predicate;

/**
 * encapsulates the logic for a stream filter
 * that indicates palindromes in a stream
 * of Strings
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
public class PalindromeStreamFilter implements Predicate<String>
{
	public boolean isCaseSensitive;				// palindrome detection is case sensitive if true
	
	public PalindromeStreamFilter()
	{
		this.isCaseSensitive = false; 	// default mode of detecting palindromes
	}
	
	/**
	 * test used by the calling stream filter
	 * 
	 * @param String s
	 * 
	 * @return boolean
	 */
	public boolean test(String s)
	{
		return this.isPalindrome(s);
	}
	
	/**
	 * returns true if the String s is a palindrome
	 * 
	 * @param String s
	 * @return boolean
	 */
	private boolean isPalindrome(String s)
	{
		if ( this.isCaseSensitive == false ){
			return this.isPalindromeWithoutCaseSensitivity(s);
		} else {
			return this.isPalindromeWithCaseSensitivity(s); 
		} 
	}
	
	/**
	 * palindrome check WITHOUT case sensitivity
	 * 
	 * @param String s
	 * @return boolean
	 */
	private boolean isPalindromeWithoutCaseSensitivity(String s)
	{
		String reversed = this.reverseString(s);
		
		return s.equalsIgnoreCase( reversed );
	}
	
	/**
	 * palindrome check WITH case sensitivity
	 * 
	 * @param String s
	 * @return boolean
	 */
	private boolean isPalindromeWithCaseSensitivity(String s)
	{
		String reversed = this.reverseString(s);
		
		return s.equals( reversed );
	}
	
	/**
	 * returns a string with the same characters as the string
	 * passed but transformed to be reversed across the x axis
	 * 
	 * @param String s
	 * @return String
	 */
	private String reverseString(String s)
	{
		 StringBuilder builder = new StringBuilder();
		 
		 for( int i = s.length(); i > 0; i-- ) {
			 builder.append( s.charAt(i - 1) );
		 }
		 
		 return String.valueOf(builder);
	}
}
