package questionFive;

public class Q5 {
	
	/*
	 * Write a substring method that accepts a string str and and integer
	 * idx and returns the substring contained between 0 and idx-1 inclusive. 
	 * Do NOT use any of the existing substring methods in the String, StringBuilder,
	 * or StringBuffer APIs.
	 */

	public static void main(String[] args) {
		System.out.println(sub("Hello", 2));

	}
	
	public static String sub(String str, int idx) {
		String temp = new String();
		
		//Ensure the index will not go out of bounds.
		if (idx > str.length()) {
			idx = str.length();
		}
		
		//Add letters up to the desired index.
		for (int i = 0; i < idx; i++) {
			temp += str.charAt(i);
		}
		
		return temp;
		
	}

}
