import java.util.Formatter;

public class CreateAccountEntry {

	public CreateAccountEntry(int accountID, String userName, String password, String firstName, String lastName, Integer ssn) {
		
	}
	private Formatter x;

	public void openFile() {
		try {
			x = new Formatter("AccAndUserInfo.txt");
		} catch (Exception e) {
			System.out.println("Error Occured");
		}
	}
	
	public void storeUserInfo(int accountID, String userName, String password, String firstName, String lastName, Integer ssn) {
		x.format("%s%s%s", accountID, userName, password, firstName, lastName, ssn);
	}
	
	public void closeFile() {
		x.close();
	}

}
