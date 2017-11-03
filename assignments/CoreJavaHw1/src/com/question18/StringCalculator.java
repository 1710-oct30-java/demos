package com.question18;

/* Q18. Write a program having a concrete subclass that inherits three abstract
 * methods from a superclass. Provide the following three implementations in the
 * subclass corresponding to the abstract methods in the superclass...
*/

public class StringCalculator extends AbstractStringCalculator
{
	
	@Override
	public boolean hasCaps(String str)
	{
		// Regex for capital letters
		return str.matches("^(?=.*[A-Z]).+$");
	}
	
	@Override
	public String allCaps(String str)
	{
		return str.toUpperCase();
	}
	
	@Override
	public int addTen(String str)
	{
		int num = Integer.parseInt(str);
		num += 10;
		return num;
	}
}
