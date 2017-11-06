package Banking;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
/*
 * The BankLauncher class is the runs the banking application. This class creates a list of user's and their accounts
 * each time a new user registers. It contains a main menu which prompts the user to: 1. Register, 2. Sign in, or 0. Exit.
 * When register is selected, the program prompts the user to enter their username and password, and then directed to sign in.
 * Once a user signs in they will be given 6 options: 1. Deposit, 2. Withdraw, 3. View accounts, 4. Create new account, 
 * 5. Delete account, and 6. Sign out. If the user selects exit, the program ends and the list of users and each of their accounts
 * will be written to a text file.
 */
public class BankLauncher
{

	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		User newUser = new User();
        Account newAccount = new Account();
        List<User> userList = new ArrayList<User>();
        int userID = 1;
        boolean exit = false;
        boolean leave = false;
        
        //Main Menu
        do {
        	try
            {
        	System.out.println("1. Register");
    		System.out.println("2. Sign in");
    		System.out.println("0. Exit");
    		int choice = sc.nextInt();
    		sc.nextLine();
        	switch(choice)
			{
        	//Case 1 is registration
			case 1: 
				System.out.println("Enter Username:");				
				String username = sc.nextLine();
				
				System.out.println("Enter Password:");
				String password = sc.nextLine();
				
				System.out.println("Enter account type:");
				String str = sc.nextLine();
				
				System.out.println("Starting balance: ");
				double startBalance = sc.nextDouble();
				System.out.println("Your username is: "+username);
				System.out.println("Your password is: "+password);
				System.out.println("Your account: "+str+" = "+startBalance);
				newAccount = new Account(str, startBalance);
				List<Account> newAccountList = new ArrayList<Account>(); 
				newAccountList.add(newAccount);
				newUser = new User(username, password, newAccountList, userID);
				userID++;
				userList.add(newUser);
				System.out.println("Account created please sign in.");
				break;
			//Case 2 is signing in	
			case 2:
				System.out.println("Username: ");
				String userName = sc.nextLine();
				int i = 0;
				//This was meant to be a check for a valid username, but I was unable to get it running properly
				while (userName.equals(userList.get(i).getUsername()) == false)
				{
					if (userName.equals(userList.get(i).getUsername()))
					{
						break;
					}
					else if (i<userList.size()-1)
					{
						i++;
					}
					else
					{
						System.out.println("No user with this username was found.");
						leave = true;
						break;
					}
				 }
						System.out.println("Password: ");
						String userPass = sc.nextLine();
						//Checks if password is valid
						if (userPass.equals(userList.get(i).getPassword()))
						{
							//Sub menu for the user once they sign in successfully
							do
							{
							System.out.println("Welcome "+userName);
							System.out.println("1. Deposit money");
							System.out.println("2. Withdraw money");
							System.out.println("3. View accounts");
							System.out.println("4. Create account");
							System.out.println("5. Delete account");
							System.out.println("6. Sign out");
							choice = sc.nextInt();
							switch (choice) 
							{
								//Case 1 allows the user to make a deposit to the account of their choosing
								case 1:
										if (userList.get(i).getAccountList().size() == 1)
										{
											System.out.println("How much would you like to deposit:");
											userList.get(i).getAccountList().get(0).deposit(sc.nextDouble());
										}
										else
										{
											System.out.println(userList.get(i).getAccountList());
											System.out.println("Which account would you like to make a deposit to? Type '1', '2', '3' to deposit to\n the first, second, third, etc. account respectively.");
											int accIndex = sc.nextInt();
											System.out.println("How much would you like to deposit:");
											userList.get(i).getAccountList().get(accIndex-1).deposit(sc.nextDouble());
										}
									break;
								//Case 2 allows the user to make a withdrawal from the account of their choosing	
								case 2:
										if (userList.get(i).getAccountList().size() == 1)
										{
											System.out.println("How much would you like to withdraw:");
											userList.get(i).getAccountList().get(0).withdrawal(sc.nextDouble());
										}
										else
										{
											System.out.println(userList.get(i).getAccountList());
											System.out.println("Which account would you like to make a withdrawal from? Type '1', '2', '3' to deposit to\n the first, second, third, etc. account respectively.");
											int accIndex = sc.nextInt();
											System.out.println("How much would you like to withdraw:");
											userList.get(i).getAccountList().get(accIndex-1).withdrawal(sc.nextDouble());
										}
									break;
								//Case 3 allows the user to view all of their accounts	
								case 3:
									System.out.println("List of your accounts:\n");
									System.out.println(userList.get(i).getAccountList().toString());
									break;
								//Case 4 allows the user to open a new account	
								case 4:
									sc.nextLine();
									System.out.println("Enter new account name:\n");
									String acc = sc.nextLine();
									System.out.println("Starting balance:\n");
									double bal = sc.nextDouble();
									Account createdAccount = new Account(acc, bal);
									System.out.println(userList.get(i).getAccountList().add(createdAccount));
									break;
								//Case 5 allows the user to delete an account	
								case 5:
									System.out.println("Which account would you like to delete? Type '1', '2', '3' to delete\n the first, second, or third account respectively.");
									int delete = sc.nextInt();
									userList.get(i).getAccountList().remove(delete-1);
									break;
								//Case 6 signs out the current user	
								case 6:
									System.out.println("Goodbye.");
									leave = true;
									break;
								default:
									System.out.println("Invalid input.");
									break;
							
						}
							}while (!leave);
						//Resetting the leave flag to false
						leave = false;
					}
				
					else
					{
						System.out.println("Invalid input");
					}
				
				break;
			case 0:
				exit = true;
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
        }catch(InputMismatchException e)
        {
        	System.out.println("Invalid input");
        	break;
        }
			}  while (!exit); 
        //Writes the users' information to a text file
        try{    
        	FileOutputStream fos = new FileOutputStream("C:\\Users\\Brandon.Brandon-PC\\workspace_2\\BankingProject\\src\\Banking\\userinfo");   
        	for (int i = 0; i<userList.size(); i++)
			{
				String s = userList.get(i).toString()+"\n";
				byte[] b = s.getBytes();
				fos.write(b);
			}
        	fos.close();
           }catch(Exception e){System.out.println(e);}
					System.out.println("Exiting");
					sc.close();	
}
}