package users;

import java.util.ArrayList;
import java.util.List;

import banking.Account;

public class Member extends User
{
	public Member(String username, String password, String firstName, String lastName)
	{
		super(username, password, firstName, lastName);
		// TODO Auto-generated constructor stub
	}
	
	List<Account> accounts = new ArrayList<Account>();
}
