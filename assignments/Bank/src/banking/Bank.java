package banking;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import users.Admin;
import users.Member;
import users.User;

public class Bank
{
	static List<User>		allUsers	= new ArrayList<>();
	static List<Account>	allAccounts	= new ArrayList<>();
	static Admin			chris		= new Admin("cworcester", "12345678", "Chris", "Worcester");
	// static Member dave = new Member("username", "password", "Dave", "McDude");
	// static Account acc = new Account("checking", 634.20f, dave);
	static Scanner			scan		= new Scanner(System.in);
	static User				currentUser;
	
	// static
	// {
	// allUsers.add(chris);
	// allUsers.add(dave);
	// allAccounts.add(acc);
	// dave.getAccounts().add(acc);
	// }
	
	public static void main(String[] args)
	{
		loadUsers();
		Welcome();
	}
	
	private static void Welcome()
	{
		String input;
		
		System.out.println("[----------------------------------]");
		System.out.println("[----------- Welcome to -----------]");
		System.out.println("[--------- WOODSTONE BANK ---------]");
		System.out.println("[----------------------------------]");
		
		do
		{
			System.out.println("Are you a member with us?\ny-yes, n-no");
			input = scan.nextLine().toLowerCase();
		}
		while (!(input.equals("y") ^ input.equals("n")));
		
		if (input.contains("n"))
		{
			// Allow creation of new account
			currentUser = register();
			saveUsers();
		}
		else
		{
			// allow login
			currentUser = logIn();
		}
		
		System.out.println(
				"Welcome, " + currentUser.getFirstName() + " " + currentUser.getLastName() + ".");
		
		OptionMenu();
	}
	
	private static void OptionMenu()
	{
		String input;
		
		do
		{
			System.out.println(
					"What would you like to do?\n" + "v-view accounts, o-open new account, s-sign out");
			input = scan.nextLine().toLowerCase();
		}
		while (!(input.equals("v") ^ input.equals("o") ^ input.equals("s")));
		
		switch (input)
		{
			case "v":
				viewAccounts();
				break;
			case "o":
				openAccount();
				break;
			case "s":
				signOut();
				break;
			default:
				break;
		}
	}
	
	private static void viewAccounts()
	{
		if (((Member) currentUser).getAccounts().size() == 0)
		{
			System.out.println("It looks like you don't have an account yet.\n");
			openAccount();
		}
		else
		{
			for (int i = 0; i < ((Member) currentUser).getAccounts().size(); i++)
			{
				System.out.println(i + 1);
				System.out.println(((Member) currentUser).getAccounts().get(i));
			}
		}
		
		String input;
		
		System.out.println("Would you like to make changes to an account?\n"
				+ "If so, enter the number associated with the account, shown above.\n"
				+ "Otherwise, press 'n'");
		input = scan.nextLine().toLowerCase();
		
		if (input.equals("n"))
			OptionMenu();
		else
		{
			Account thisAccount = ((Member) currentUser).getAccounts().get(Integer.parseInt(input) - 1);
			System.out.println(thisAccount);
			System.out.println("Would you like to\n" + "w-withdraw, d-deposit, or c=close account");
			input = scan.nextLine().toLowerCase();
			switch (input)
			{
				case "w":
					withdraw(thisAccount);
					break;
				case "d":
					deposit(thisAccount);
					break;
				case "c":
					closeAccount(thisAccount);
					break;
				default:
					break;
			}
		}
	}
	
	private static void withdraw(Account acc)
	{
		String input;
		float withdrawal;
		
		do
		{
			System.out.println("How much would you like to withdraw?");
			input = scan.nextLine();
			withdrawal = Float.parseFloat(input);
		}
		while ((withdrawal > acc.getBalance() || withdrawal <= 0));
		
		acc.setBalance(acc.getBalance() - withdrawal);
		System.out.println("Withdrawal has been made.");
		System.out.println(((Member) currentUser).getAccounts().get(0));
		
		saveAccounts();
		OptionMenu();
	}
	
	private static void deposit(Account acc)
	{
		String input;
		float deposit;
		
		do
		{
			System.out.println("How much would you like to deposit?");
			input = scan.nextLine();
			deposit = Float.parseFloat(input);
		}
		while ((deposit > Float.MAX_VALUE || deposit <= 0));
		
		acc.setBalance(acc.getBalance() + deposit);
		System.out.println("Deposit has been made.");
		System.out.println(((Member) currentUser).getAccounts()
				.get(((Member) currentUser).getAccounts().indexOf(acc)));
		
		saveAccounts();
		OptionMenu();
	}
	
	private static void closeAccount(Account acc)
	{
		((Member) acc.getOwner()).getAccounts().remove(acc);
		acc.setOwner(null);
		allAccounts.remove(acc);
		
		System.out.println("Account is now closed.");
		
		saveAccounts();
		saveUsers();
		OptionMenu();
	}
	
	private static void openAccount()
	{
		String input;
		do
		{
			System.out
					.println("What type of account would you like to open?\n" + "c-checking, s-savings");
			input = scan.nextLine().toLowerCase();
		}
		while (!(input.equals("c") ^ input.equals("s")));
		
		String accountType = null;
		
		switch (input)
		{
			case "c":
				accountType = "checking";
				break;
			case "s":
				accountType = "savings";
				break;
			default:
				break;
		}
		
		System.out.println(
				"How much would you like to deposit into your new " + accountType + " account?");
		
		input = scan.nextLine();
		float initialDeposit = Float.parseFloat(input);
		
		while ((initialDeposit > Float.MAX_VALUE) || initialDeposit < 100)
		{
			System.out.println("Initial deposit must be at least $100.\n" + "Please try again.");
			input = scan.nextLine();
			initialDeposit = Float.parseFloat(input);
		}
		
		Account newAccount = new Account(accountType, initialDeposit, currentUser);
		((Member) currentUser).getAccounts().add(newAccount);
		allAccounts.add(newAccount);
		saveAccounts();
		saveUsers();
		
		System.out.println("Congratulations, " + currentUser.getFirstName() + ". Your " + accountType
				+ " account has been opened with a balance of $" + initialDeposit);
		
		OptionMenu();
	}
	
	private static void signOut()
	{
		System.out.println("You have been signed out.\n\n\n\n");
		currentUser = null;
		try
		{
			TimeUnit.SECONDS.sleep(1);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Welcome();
	}
	
	private static User logIn()
	{
		System.out.println("Enter your username: ");
		String username = scan.nextLine();
		
		while (findUser(username) == null)
		{
			System.out.println("Sorry, there is no member with the username \"" + username
					+ "\"\nPlease try again.");
			username = scan.nextLine();
		}
		
		System.out.println("Please enter your password: ");
		String password = scan.nextLine();
		
		while (!password.equals(findUser(username).getPassword()))
		{
			System.out.println("Username and password do not match. \nPlease try again.");
			password = scan.nextLine();
		}
		
		return findUser(username);
	}
	
	private static Member register()
	{
		// Choose username
		System.out.println("To create a new account, enter your chosen username: ");
		String username = scan.nextLine();
		while (findUser(username) != null)
		{
			System.out.println("Sorry. That username is taken. Please try again: ");
			username = scan.nextLine();
		} ;
		
		// Choose password
		System.out.println("Please enter a password: ");
		String password = scan.nextLine();
		while (!passwordValid(password))
		{
			System.out.println("Sorry. That password does not meet security requirements.\n"
					+ "Ensure it is at least 8 characters long and try again: ");
			password = scan.nextLine();
		} ;
		
		// Enter name
		String name;
		System.out.println("Thank you, " + username + ". ");
		do
		{
			System.out.println("Please enter your first and last name separated by a space: ");
			name = scan.nextLine();
		}
		while (!name.contains(" "));
		
		String[] splitName = name.split(" ");
		
		String first = splitName[0];
		String last = splitName[1];
		
		Member newMember = new Member(username, password, first, last);
		allUsers.add(newMember);
		saveUsers();
		return newMember;
	}
	
	private static User findUser(String newUn)
	{
		// for (User u : allUsers)
		for (int i = 0; i < allUsers.size(); i++)
		{
			User thisUser = allUsers.get(i);
			
			if (newUn.equalsIgnoreCase(thisUser.getUsername()))
				return thisUser;
		}
		return null;
	}
	
	private static void loadUsers()
	{
		allUsers.clear();
		
		try
		{
			FileInputStream fis = new FileInputStream("Users.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			allUsers = (List<User>) ois.readObject();
		}
		catch (Exception e)
		{
			return;
		}
	}
	
	private static void saveUsers()
	{
		try
		{
			// Serialize data object to a file
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Users.txt"));
			oos.writeObject(allUsers);
			oos.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private static void loadAccounts()
	{
		allAccounts.clear();
		
		try
		{
			FileInputStream fis = new FileInputStream("Accounts.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			allAccounts = (List<Account>) ois.readObject();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return;
		}
	}
	
	private static void saveAccounts()
	{
		try
		{
			// Serialize data object to a file
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Accounts.txt"));
			oos.writeObject(allAccounts);
			oos.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private static boolean passwordValid(String pw)
	{
		return pw.length() > 7;
	}
}
