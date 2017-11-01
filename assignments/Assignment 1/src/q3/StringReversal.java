package q3;

public class StringReversal {

	public String reverseString(String s) {
		// start at end of string, append the word backwards to the end of the string
		for (int i = s.length() - 1; i >= 0; i--) {
			s = s + s.charAt(i);

		}
		// return only the second half of the string thats reversed
		return s.substring(s.length() / 2, s.length());
	}

	public static void main(String[] args) {

		StringReversal instance = new StringReversal();
		String s = "hello";
		String answer = instance.reverseString(s);
		System.out.println(answer);
	}
}
