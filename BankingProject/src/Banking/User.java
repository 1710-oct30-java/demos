package Banking;

import java.util.List;
/*
 * Class User is created each time a new user registers
 * A user has a username, password, and an account list
 */
public class User
{
	private String username;
	private String password;
	private List<Account> accountList;
	private int ID;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Constructor
	public User(String username, String password, List<Account> accountList, int iD) {
		super();
		this.username = username;
		this.password = password;
		this.accountList = accountList;
		this.ID = iD;
	}
	//gets user's username
	public String getUsername() {
		return username;
	}
	//sets user's
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Account> getAccountList() {
		return accountList;
	}
	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((accountList == null) ? 0 : accountList.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (ID != other.ID)
			return false;
		if (accountList == null) {
			if (other.accountList != null)
				return false;
		} else if (!accountList.equals(other.accountList))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", accountList=" + accountList + ", ID=" + ID
				+ "]";
	}
	
	
	
	
}
