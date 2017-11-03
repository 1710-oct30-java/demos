package banking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import users.Member;
import users.User;

public class Bank
{
	static List<User>		allUsers	= new ArrayList<>();
	static List<Account>	allAccounts	= new ArrayList<>();
	static Member			chris		= new Member("cworcester", "12345678", "Chris", "Worcester");
	static Scanner			scan		= new Scanner(System.in);
	static User				currentUser;
	
	static
	{
		allUsers.add(chris);
	}
	
	public static void main(String[] args)
	{
		String input;
		
		System.out.println("[---------------------------------]");
		System.out.println("[----Welcome to Woodstone Bank----]");
		System.out.println("[---------------------------------]");
		do
		{
			System.out.println("Are you a member with us?\n(y)es or (n)o");
			input = scan.nextLine();
		}
		while (!(input.contains("y") ^ input.contains("n")));
		
		if (input.contains("n"))
		{
			// Allow creation of new account
			currentUser = register();
			allUsers.add(currentUser);
		}
		else
		{
			// allow login
			currentUser = logIn();
			System.out.println("Welcome, " + currentUser.getFirstName() + " " + currentUser.getLastName()
					+ ".\nWhat would you like to do?");
			System.out.println(currentUser.toString() + " is logged in.");
		}
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
		
		System.out.println("first name: " + first);
		System.out.println("last name: " + last);
		
		return new Member(username, password, first, last);
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
	
	private static boolean passwordValid(String pw)
	{
		return pw.length() > 7;
	}
}
