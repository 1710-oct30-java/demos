
public class Customers {

	private String firstName;
	private String lastName;
	private int ssn;
	private Accounts account;
	private String userName;
	private String password;

	public Customers(String firstName, String lastName, int ssn, Accounts account, String userName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.account = account;
		this.userName = userName;
		this.password = password;
		
	}
	
	@Override
	
	public String toString() {
		 return "\nCustomer Infomation\n" +
				 "First Name: " + firstName + "\n"+
				 "Last Name: " + lastName + "\n"+
				 "SSN: " + ssn + "\n"+
				 account;
	}
	

}
