package question5;

/*
 * Write a substring method that accepts a string str and an integer idx and
 * returns the substring contained between 0 and idx-1 inclusive. Do NOT use
 * any of the existing substring methods in the STring, StringBuilder, or 
 * StringBuffer APIs.
 */
public class Question5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello";
		int idx = 4;
		
		// split the string into an array of its characters
		String[] strArray = str.split("");
		
		// create new array to hold substring of the string
		String[] newArray = new String[idx-1];
		
		// put the substring into the new array
		for(int i = 0; i < idx-1; i++) {
			newArray[i] = strArray[i];
			//System.out.println(newArray[i]);
		}
		
		// put the string back together from array of characters
		String finalStr = String.join("", newArray);
		
		//display final string
		System.out.println(finalStr);
	}

}
