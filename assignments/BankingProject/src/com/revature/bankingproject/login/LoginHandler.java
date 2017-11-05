package com.revature.bankingproject.login;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.bankingproject.files.FileHandler;
import com.revature.bankingproject.tools.EncryptionHandler;
import com.revature.bankingproject.tools.InputValidator;
import com.revature.bankingproject.user.DuplicateUserException;
import com.revature.bankingproject.user.User;

public class LoginHandler implements LoginInterface {
	private static Logger log = Logger.getRootLogger();
	private Scanner scan = new Scanner(System.in);
	//Create user, throw exception if email is duplicate
	@Override
	public User create(String name, String password, String email, List<User> users) throws DuplicateUserException {
		log.info("Attempting to create new user");
		log.trace("Create name: " + name + " password: " + password + " email: " + email);
		if (users.stream().anyMatch(i -> i.getEmail().equals(email))) {
			throw new DuplicateUserException();
		}
		log.info("Adding new user");
		User newUser = new User(User.userIdCount++, name, EncryptionHandler.Encrypt(password), email);
		users.add(newUser);
		return newUser;
	}
	//Primary view and portal for Landing Page
	@Override
	public User userLandingPage(List<User> users) {
		User currentUser = null;
		log.info("On landing page");
		boolean validInput;
		String inputString;
		do {
			do {
				System.out.println("Hello! Please Enter 1,2 or 9");
				System.out.println("1. I am an Existing User");
				System.out.println("2. I am a New User");
				System.out.println("9. Exit");
				inputString = scan.nextLine();
				validInput = InputValidator.validLandingInput(inputString);
			} while (!validInput);
			switch (inputString) {
			case ("1"):
				currentUser = userLoginPage(users);
				break;
			case ("2"):
				currentUser = userCreatePage(users);
				break;
			case ("9"):
				return null;
			}
			if(currentUser != null && currentUser.getFlagged())
			{
				System.out.println("I am sorry but this account need to be verified by the ADMIN");
				currentUser = null;
			}
		} while (currentUser == null);
		log.debug("Landing page Returning currentUser");
		return currentUser;
	}
	//Primary view and logic for Logging in an Existing user
	private User userLoginPage(List<User> users) {
		log.info("User is attempting to log in");
		Optional<User> checkUserLogin = null;
		String userEmail;
		String password;

		do {
			System.out.println("If you would like to return to the previous page leave any field blank");
			System.out.println("Please Enter Your Email:");
			userEmail = scan.nextLine();
			System.out.println("Please Enter Your Password");
			password = scan.nextLine();
			if (userEmail.length() == 0 || password.length() == 0) {
				return null;
			}
			final String finalUserEmail = userEmail;
			final String pass = password;
			checkUserLogin = users.stream().filter(i -> i.getEmail().equals(finalUserEmail) && (i.getPassword().equals(EncryptionHandler.Encrypt(pass)))).findFirst();
			if(!checkUserLogin.isPresent())
				System.out.println("I'm sorry there are no user accounts with that verification");
		} while (!checkUserLogin.isPresent());
		return checkUserLogin.get();
	}
	//Primary view and logic for creating a new user
	private User userCreatePage(List<User> users) {
		log.info("User is attempting to create a new User");
		String name, email, password;
		System.out.println("If you would like to return to the previous page leave any field blank");
		System.out.println("Please enter your name:");
		name = scan.nextLine();
		System.out.println("Please enter your email address:");
		email = scan.nextLine();
		System.out.println("Please enter your password");
		password = scan.nextLine();
		if (name.length() == 0 || email.length() == 0 || password.length() == 0)
			return null;
		log.debug("User name: " + name + " User email: " + email + "User password " + password);
		User newUser = null;
		try {
			newUser = create(name, EncryptionHandler.Encrypt(password), email, users);
		} catch (DuplicateUserException e) {
			System.out.println("I'm sorry someone has alread opened an account with those credentials");
			userCreatePage(users);
		}
		FileHandler.saveSerializedFile(users);
		return newUser;

	}
	@Override
	protected void finalize() throws Throwable {
		scan.close();
		super.finalize();
	}
}
