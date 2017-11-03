package question18;

public class Question18 {
	// Write a program having a concrete subclass that inherits
	// three abstract methods from a superclass. Provide the
	// following three implementations in the subclass
	// corresponding to the abstract methods in the superclass.
	//
	// 1. Check for uppercase characters in a string, and return
	// 'true' or 'false' depending if any are found.
	// 2. Convert all of the lower case characters to uppercase
	// in the input string and return the result.
	// 3. Convert the input string to integer and add 10, output the
	// result to the console.
	//
	// Create an appropriate class having a main method to test
	// the above setup.
	public static void main(String[] args) {
		 SubClass sc = new SubClass();
		 
		 String str = "Hello";
		 String number = "10";
		 
		 System.out.println("Does the string " + str + " have upper case characters? " + sc.checkForUpper(str));
		 
		 System.out.println(sc.toUpper(str));
		 
		 System.out.print("The number " + number + " plus ten equals ");
		 sc.addTen(number);
	}
}