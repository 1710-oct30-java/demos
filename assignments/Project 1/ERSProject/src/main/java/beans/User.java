package beans;

import java.util.List;

public class User {
	private int userID;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private int roleID;
	private int activeState;
	private List<Reimbursement> Reimbursements;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userID, String username, String password, String firstName, String lastName, String email,
			int roleID, int activeState, List<Reimbursement> reimbursements) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleID = roleID;
		this.activeState = activeState;
		Reimbursements = reimbursements;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public int getActiveState() {
		return activeState;
	}

	public void setActiveState(int activeState) {
		this.activeState = activeState;
	}

	public List<Reimbursement> getReimbursements() {
		return Reimbursements;
	}

	public void setReimbursements(List<Reimbursement> reimbursements) {
		Reimbursements = reimbursements;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Reimbursements == null) ? 0 : Reimbursements.hashCode());
		result = prime * result + activeState;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + roleID;
		result = prime * result + userID;
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
		if (Reimbursements == null) {
			if (other.Reimbursements != null)
				return false;
		} else if (!Reimbursements.equals(other.Reimbursements))
			return false;
		if (activeState != other.activeState)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (roleID != other.roleID)
			return false;
		if (userID != other.userID)
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
		return "User [userID=" + userID + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", roleID=" + roleID + ", activeState="
				+ activeState + ", Reimbursements=" + Reimbursements + "]";
	}

	

}
