package assignments.week01.question18;

public class StringWrapper extends AbstractStringWrapper
{
	/**
	 * returns true of the string passed has one or more
	 * uppercase characters
	 * 
	 * @param String s
	 * 
	 * @return boolean
	 */
	public boolean hasUppercaseLetters(String s)
	{
		String upperCaseCopy = s.toUpperCase();
		
			
		for(int i = 0; i < s.length(); i++ ) {
			char current = s.charAt(i);
			char upper = upperCaseCopy.charAt(i);
			
			/*
			 * if the current character is a number, skip
			 */
			if ( s.substring(i, i + 1).matches("[0-9]") ) {
				continue;
			}
			
			/*
			 * if an uppercase character is found
			 * return true
			 */
			if ( current == upper ) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * converts the string passed to all uppercase
	 * 
	 * @param String s
	 * 
	 * @return boolean
	 */
	public String toUpper(String s)
	{
		return s.toUpperCase();
	}
	
	/**
	 * converts the string passed to an integer
	 * and adds 10 to it
	 * 
	 * @param String s
	 * 
	 * @return int
	 */
	public int displayValuePlusTen(String s)
	{
		
		Integer value = 10;
		
		try {
			value += Integer.parseInt(s);
		} catch(Exception e) {
			// stub
		} 

		return value;
		
	}

}
