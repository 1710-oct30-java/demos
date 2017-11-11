package com.ers.launcher;

import com.ers.beans.Reimbursement;
import com.ers.beans.ReimbursementStatus;
import com.ers.beans.ReimbursementType;
import com.ers.beans.UserRoles;
import com.ers.beans.Users;

public class Launcher {
	public static void main(String[] args) {
		//UsersDAO user = new UsersDAO(1, "batman", "password", "Bruce", "Wayne", "batman@gmail.com", 2);
		Users user = new Users();
		UserRoles ur = new UserRoles();
		ReimbursementType type = new ReimbursementType();
		ReimbursementStatus status = new ReimbursementStatus();
		Reimbursement reimb = new Reimbursement();
		
		System.out.println(reimb);
	}
}
