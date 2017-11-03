package question18;

public class StringManipulator extends Question18{
	
	private String myString;

	public StringManipulator(String myString) {
		super();
		this.myString = myString;
	}
	
	

	@Override
	public boolean checkForUppercase() {
		boolean uppercasePresent = false;
		for(char c : myString.toCharArray()) {
			if(c == Character.toUpperCase(c)) {
				uppercasePresent = true;
			}
		}
		return uppercasePresent;
	}

	@Override
	public String convertAllToUppercase() {
		String uppercase = "";
		for(char c : myString.toCharArray()) {
			uppercase += Character.toUpperCase(c);
		}
		return uppercase;
	}

	@Override
	public int addTen() {
		int stringLength = myString.length();
		return stringLength + 10;
	}
	
}
