package objects;

public class Account {
	private String accID;
	private String userID;
	private double balance;
	private String type;

	public Account(String accID, String userID, double balance, String type) {
		super();
		this.accID = accID;
		this.userID = userID;
		this.balance = balance;
		this.type = type;
	}

	public String getaccID() {
		return accID;
	}

	public void setaccID(String accID) {
		this.accID = accID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accID == null) ? 0 : accID.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
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
		Account other = (Account) obj;
		if (accID == null) {
			if (other.accID != null)
				return false;
		} else if (!accID.equals(other.accID))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accID=" + accID + ", userID=" + userID + ", balance=" + balance + ", type=" + type + "]";
	}

}
