package q18;

public class Subclass extends Superclass {

	public Boolean containsCapital(String s) {
		// iterate through string, check if any capital letters
		Boolean isUpper = false;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i))) {
				isUpper = true;
			}
		}
		return isUpper;

	}

	public String convertCapital(String s) {
		// convert string to capital
		String upper = s.toUpperCase();
		return upper;
	}

	public int convertInt(String s) {
		// convert string to integer then add 10
		int result = Integer.parseInt(s) + 10;
		return result;
	}

	public static void main(String[] args) {
		String s = "hello";
		Subclass test = new Subclass();
		String n = "10";

		Boolean isUpper = test.containsCapital(s);
		String result = test.convertCapital(s);
		int n2 = test.convertInt(n);

		System.out.println(isUpper);
		System.out.println(result);
		System.out.println(n2);
	}

}
