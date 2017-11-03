package question5;

//write a method that takes in a string str and int idx and returns the substring
public class MySubString {
	
	public static void main(String[] args) {
		System.out.println(myMethod("test", 3));;
	}
	
	public static String myMethod(String str, int i) {
		String newString = "";
		
		for(int j = 0; j < i; j++) {
			newString = newString += str.charAt(j);
		}
		
		return newString;
	}
}
