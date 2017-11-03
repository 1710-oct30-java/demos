package question3;

/***
 * Reverse a string without using a temporary variable.
 * Do NOT use reverse() in the stringBuffer or the StringBuilder APIs.
 *
 */
public class Q3 {

	public static void main(String[] args) {
		

		String str = "Revature";
		
	
		
		for(int i =0; i<str.length(); i++) {
			
			str= str.substring(1, str.length()-i) + 
					str.substring(0, 1)+
					str.substring(str.length()-i, str.length());
		}
		System.out.println(str);
		
		
		
	}

}
