package question3;

//reverse a string
public class ReverseString {
	public static void main(String[] args) {
		String test = "hello world";
		int lastIndex = test.length() - 1;
		
		for(int i = 0; i < test.length(); i++) {
			System.out.println(test.charAt(lastIndex));
			lastIndex--;
		}
		
	}
}
