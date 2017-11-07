package question8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * Write a program that stores the following strings in an ArrayList and saves
 * all the palindromes in another ArrayList. "karan", "madam", "tom", "civic",
 * "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy", "did"
 */
public class Q8 {

	public static void main(String[] args) {

		String[] str = { "karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy",
				"did" };

		List<String> arrList = new ArrayList<String>();
		arrList.addAll(Arrays.asList(str));
		

		List<String> arrListPal = new ArrayList<String>();

		for(int i=0; i<arrList.size(); i++) {
		if (str[i].charAt(i) == str[i].charAt(str[i].length() - (i + 1))) {
			arrListPal.add(str[i]);
		}
		}
		System.out.println(arrListPal);

	}

}
