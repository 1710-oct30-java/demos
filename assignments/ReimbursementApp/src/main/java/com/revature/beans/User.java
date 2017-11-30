package com.revature.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {

	private int userId;
	private int roleId;
	private String username;
	private String password;
	private List<Reimbursement> reimbursement;
	private String firstname;
	private String lastname;
	private String email;
	private List<Reimbursement> reimbursements;


	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, int roleId, String username, String password, List<Reimbursement> reimbursement,
			String firstname, String lastname, String email, List<Reimbursement> reimbursements) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.username = username;
		this.password = password;
		this.reimbursement = reimbursement;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.reimbursements = reimbursements;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((reimbursement == null) ? 0 : reimbursement.hashCode());
		result = prime * result + ((reimbursements == null) ? 0 : reimbursements.hashCode());
		result = prime * result + roleId;
		result = prime * result + userId;
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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (reimbursement == null) {
			if (other.reimbursement != null)
				return false;
		} else if (!reimbursement.equals(other.reimbursement))
			return false;
		if (reimbursements == null) {
			if (other.reimbursements != null)
				return false;
		} else if (!reimbursements.equals(other.reimbursements))
			return false;
		if (roleId != other.roleId)
			return false;
		if (userId != other.userId)
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
		return "User [userId=" + userId + ", roleId=" + roleId + ", username=" + username + ", password=" + password
				+ ", reimbursement=" + reimbursement + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", reimbursements=" + reimbursements + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Reimbursement> getReimbursements() {
		return reimbursement;
	}

	public void setReimbursements(List<Reimbursement> reimbursements) {
		this.reimbursement = reimbursements;
	}
	
	public List<Reimbursement> getReimbursement() {
		return reimbursement;
	}

	public void setReimbursement(List<Reimbursement> reimbursement) {
		this.reimbursement = reimbursement;
	}

}
