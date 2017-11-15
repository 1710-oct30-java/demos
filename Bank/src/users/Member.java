package users;

import java.util.ArrayList;
import java.util.List;

import banking.Account;

public class Member extends User
{
	private List<Account> ownedAccounts = new ArrayList<>();
	
	public Member(String username, String password, String firstName, String lastName)
	{
		super(username, password, firstName, lastName);
		// TODO Auto-generated constructor stub
	}
	
	public List<Account> getAccounts()
	{
		return ownedAccounts;
	}

	public void setAccounts(List<Account> ownedAccounts)
	{
		this.ownedAccounts = ownedAccounts;
	}

	List<Account> accounts = new ArrayList<Account>();
}
