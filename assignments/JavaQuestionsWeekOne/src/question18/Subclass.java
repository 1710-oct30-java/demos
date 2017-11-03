package question18;

public class Subclass extends AbstractParentClass {

	@Override
	boolean checkForUppercase(String string) {
		for (int i = 0; i < string.length(); i++) {
			if(Character.isUpperCase(string.charAt(i))) return true;
		}
		
		return false;
	}

	@Override
	String convertToUpper(String string) {
		return string.toUpperCase();
	}

	@Override
	int addTenToString(String string) {
		int value;
		try {
			value = Integer.parseInt(string) + 10;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Invalid input.");
			return 0;
		}
		
		return value;
		
	}

}
