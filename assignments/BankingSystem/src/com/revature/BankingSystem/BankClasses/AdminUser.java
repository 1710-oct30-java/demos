package com.revature.BankingSystem.BankClasses;

public class AdminUser extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8391357534823744863L;
	
	public AdminUser(String userName, String firstName, String lastName, String password) {
		super(userName, firstName, lastName, password);
		
	}

	@Override
	public String toString() {
		return "ManagerUser [userId=" + userId + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}

}
