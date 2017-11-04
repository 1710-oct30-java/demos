package question18;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		MySuperClass obj = new MySubClass();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string to check for uppercase letters.");
		String a = sc.nextLine();
		System.out.println(obj.checkUpper(a));
		System.out.println("Enter a string to convert all lowercase letters to uppercase:");
		String b = sc.nextLine();
		System.out.println(obj.returnUpper(b));
		System.out.println("Enter a string to convert to an integer and add ten to the result:");
		String c = sc.nextLine();
		System.out.println(obj.stringToInt(c));
	}
}
