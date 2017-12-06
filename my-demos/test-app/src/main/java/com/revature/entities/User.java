package com.revature.entities;

public class User {
	private int id;
	private Credential cred;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, Credential cred) {
		super();
		this.id = id;
		this.cred = cred;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Credential getCred() {
		return cred;
	}

	public void setCred(Credential cred) {
		this.cred = cred;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", cred=" + cred + "]";
	}

}
