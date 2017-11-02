package question3;

/*
 * Reverse a string without using a temporary variable. Do NOT use reverse()
 * in the StringBuffer or the StringBuilder APIs
 */
public class Question3 {

	// method used to reverse a string
	public static String reverse(String word) {	
		
		// grabs the letters from the end, adds them to the original string 
		for(int i = (word.length() - 1); i >= 0; i--) {
			word += word.charAt(i);
		}
		
		// removes the original word from the new string using the substring method
		word = word.substring(word.length()/2);
		return word;
	}
	
	public static void main(String[] args) {

		// test string "hello" should output "olleh"
		System.out.println(reverse("hello"));
		
		// another test string to show it is working correctly
		System.out.println(reverse("my name is kyle"));
	}

}
