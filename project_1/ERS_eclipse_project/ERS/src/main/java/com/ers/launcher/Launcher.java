package com.ers.launcher;

import com.ers.dao.ReimbursementDAO;
import com.ers.dao.ReimbursementStatusDAO;
import com.ers.dao.ReimbursementTypeDAO;
import com.ers.dao.UserRolesDAO;
import com.ers.dao.UsersDAO;

public class Launcher {
	public static void main(String[] args) {
		//UsersDAO user = new UsersDAO(1, "batman", "password", "Bruce", "Wayne", "batman@gmail.com", 2);
		UsersDAO user = new UsersDAO();
		UserRolesDAO ur = new UserRolesDAO();
		ReimbursementTypeDAO type = new ReimbursementTypeDAO();
		ReimbursementStatusDAO status = new ReimbursementStatusDAO();
		ReimbursementDAO reimb = new ReimbursementDAO();
		
		System.out.println(reimb);
	}
}
