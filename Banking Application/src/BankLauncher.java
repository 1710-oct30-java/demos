import java.io.Console;
import java.util.Scanner;

public class BankLauncher {

	Scanner scan = new Scanner(System.in);
	boolean exit;

	public static void main(String[] args) {

		BankLauncher launch = new BankLauncher();
		launch.runMenu();
	}

	public void runMenu() {

		printHeader();

		while (!exit) {
			printMenu();
			int choice = getInput();
			performAction(choice);

		}
	}

	private void printHeader() {

		System.out.println("|----------------------------------------|");
		System.out.println("----------Welcome to Tosh Bank------------");
		System.out.println("|-----------------------------------------");
	}

	private void printMenu() {

		System.out.println("Please make a selection and hit Enter");
		System.out.println("1. Create an account");
		System.out.println("2. Login as a Customer");
		System.out.println("3. Login as an Admin");
		System.out.println("0. Exit");
	}

	private int getInput() {
		int choice = -1;

		do {
			try {
				choice = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid Selection. Numbers only please.");
			}
			if (choice < 0 || choice > 3) {
				System.out.println("Out of range. Please select from the menu");
			}

		} while (choice < 0 || choice > 4);
		return choice;
	}

	private void performAction(int choice) {

		switch (choice) {
		case 0:
			System.out.println("Thank you for choosing Tosh Bank.");
			System.exit(0);
			break;
		case 1:
			createAnAccount();
			break;
		case 2:
			loginCustomer();
			break;
		case 3:
			loginAdmin();
			break;

		default:

		}
	}

	private void loginAdmin() {
		System.out.println("Please enter the userName");

		System.out.println("Please enter the password");
	}

	private void loginCustomer() {
		System.out.println("Please enter the userName");

		System.out.println("Please enter the password");

	}

	private void createAnAccount() {
		String firstName, lastName, userName, password;
		int ssn = -1;

		System.out.println("Please enter your first name");
		firstName = scan.nextLine();
		
		System.out.println("Please enter your last name");
		lastName = scan.nextLine();
		
		System.out.println("Please enter your SSN");
		
		do {
			try {
				
				  ssn = Integer.parseInt(scan.nextLine());
				} catch (Exception e) {
					System.out.println("Invalid entry. Numbers only please.");
				}
				if(ssn<100000000 || ssn>999999999) {
					System.out.println("SSN must be between 100,000,000 to 999,999,999");
				}
		}while(ssn<100000000 || ssn>999999999);
				
		System.out.println("Please enter your user name");
		userName = scan.nextLine();
		
		System.out.println("Please enter your password");
		password = scan.nextLine();
		
		System.out.println("******************************************");
		System.out.println("Your account has been created succesfully!");
		System.out.println("******************************************");
		System.out.println("");
		System.out.println("Your Username is: "+ userName);
		System.out.println("Please login to the account");
		System.out.println("");

		Accounts account = new Accounts();
		int accountID = account.getAccountID();
		Customers customer = new Customers(firstName, lastName, ssn, account, userName, password);
		
		
		
		
		
	}

	private void deleteAccount() {

	}

}
