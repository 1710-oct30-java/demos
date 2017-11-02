package assignments.week01.question18;

/**
 * abstract string wrapper class
 * 
 * @author john.w.brown.jr@gmail.com
 *
 */
abstract public class AbstractStringWrapper {
	
	/**
	 * returns true of the string passed has one or more
	 * uppercase characters
	 * 
	 * @param String s
	 * 
	 * @return boolean
	 */
	abstract public boolean hasUppercaseLetters(String s);
	
	/**
	 * converts the string passed to all uppercase
	 * 
	 * @param String s
	 * 
	 * @return boolean
	 */
	abstract public String toUpper(String s);
	
	/**
	 * converts the string passed to an integer
	 * and adds 10 to it
	 * 
	 * @param String s
	 * 
	 * @return int
	 */
	abstract public int displayValuePlusTen(String s);

}
