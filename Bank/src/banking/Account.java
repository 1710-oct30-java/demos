package banking;

import java.io.Serializable;

import users.User;

public class Account implements Serializable
{
	private static final long	serialVersionUID	= -5474690029261822324L;
	private String				type;
	private float				balance				= 0;
	private User				owner;
	
	public String getType()
	{
		return type;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public float getBalance()
	{
		return balance;
	}
	
	public void setBalance(float balance)
	{
		this.balance = balance;
	}
	
	public User getOwner()
	{
		return owner;
	}
	
	public void setOwner(User owner)
	{
		this.owner = owner;
	}
	
	@Override
	public String toString()
	{
		// return "Account [type=" + type + ", balance=" + balance + ", owner=" + owner + "]";
		return owner.getFirstName() + "'s " + type + " account\n" + "Balance: $" + balance + "\n";
	}
	
	public Account(String type, float balance, User owner)
	{
		super();
		this.type = type;
		this.balance = balance;
		this.owner = owner;
	}
}