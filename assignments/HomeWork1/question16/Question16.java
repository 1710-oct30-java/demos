package question16;

import java.util.HashMap;

/*
 * Q16.  Write a program to display the number of characters for a string input. The string
 * should be entered as a commandline arguement using (String[] args).
 */
public class Question16 {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("No input");
			return;
		}
		//Grab the string from the input array
		String input = args[0];
		//Not 100% what is meant by number of characters so I'll count all the individual characters
		HashMap<String, Integer> map = charCounter(input);
		//loop through the Hashmap and print out the contents
		for (String keys : map.keySet()) {
			System.out.println("There are " + map.get(keys) + " " + keys);
		}
		//Maybe you were actually just wanting the total number of character in the string so here is the string length
		System.out.println("The string " + input + " has " + input.length() + " chars in it");

	}

	private static HashMap<String, Integer> charCounter(String s) {
		//make our storage hashmap
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		//for each character in the string
		for (String item : s.split("")) {
			//if the hashmap already has the character as a key
			if (result.containsKey(item)) {
				//increment the value by 1
				result.replace(item, result.get(item) + 1);
			} else {
				//otherwise put the character into the key and make the value 1
				result.put(item, 1);
			}
		}
		return result;
	}
}
