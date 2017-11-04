package question8;

import java.util.ArrayList;
import java.util.List;

/*
 * Write a program that stores the following strings in an ArrayList
 * and saves all the palindromes in another ArrayList.
 */
public class QuestionEight 
{
	public static void main(String[] args) 
	{
		List<String> arrList = new ArrayList<>();
		List<String> palinList = new ArrayList<>();
		arrList.add("karan");
		arrList.add("madam");
		arrList.add("tom");
		arrList.add("civic");
		arrList.add("radar");
		arrList.add("sexes");
		arrList.add("jimmy");
		arrList.add("kayak");
		arrList.add("john");
		arrList.add("refer");
		arrList.add("billy");
		arrList.add("did");
		
		for (int i = 0; i<arrList.size(); i++)
		{
			String str = arrList.get(i);
			if (isPalindrome(str) == true)
			{
				palinList.add(str);
			}
		}
		System.out.println("All strings "+ arrList);
		System.out.println("Palindromes "+ palinList);
	}	
		static boolean isPalindrome(String str)
		{
			int j = 1;
			for (int i = 0; i<str.length(); i++)
			{
				if (str.charAt(i) == str.charAt(str.length()-j))
				{
					j++;
				}
				else
				{
					return false;
				}
			}
			return true;
		}
		
}
