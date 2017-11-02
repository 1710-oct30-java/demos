package assignments.week01.question11;

import assignments.week01.question11.p2.Account;

public class Question11 {
	public static void main(String[] args) {
		Account checking = new Account("Checking Account", 50.79f, 25.79f );
		
		display( checking );	// display to console
	}
	
	/**
	 * display account detail to console
	 * 
	 * @param account
	 */
	public static void display(Account account)
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append( String.format("ACCOUNT ID:\t\t%s\n", account.getId() ) );
		sb.append( String.format("TOTAL BALANCE:\t\t%.2f\n", account.getBalance() ) );
		sb.append( String.format("AVAILABLE BALANCE:\t%.2f\n", account.getAvailable() ) );
		
		System.out.println( sb );
	}
}
