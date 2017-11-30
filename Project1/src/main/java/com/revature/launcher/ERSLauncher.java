package com.revature.launcher;

import com.revature.beans.Users;
import com.revature.daos.ReimbursementDAO;
import com.revature.daos.ReimbursementDAOJdbc;
import com.revature.daos.UsersDAO;
import com.revature.daos.UsersDAOJdbc;

public class ERSLauncher {
	
	public static void main(String[] args) {
		ReimbursementDAO rdj = new ReimbursementDAOJdbc();
		UsersDAO udj = new UsersDAOJdbc();
		
		//System.out.println(rdj.findById(1)); worked
		//System.out.println(rdj.findAll()); worked
		//System.out.println(rdj.findPending()); worked
		//System.out.println(rdj.findPastTickets()); worked
		//System.out.println(udj.findAll()); worked
		//System.out.println(udj.findById(2));worked
		//rdj.addReimbursement(udj.findById(5), 450, "!!!!!", 2); worked
		Users u = udj.signIn("chiron", "atr"); 
		//rdj.approveOrDeny(u, 3, 3); worked
		System.out.println(rdj.findUserPastTickets(u));
		System.out.println("pending");
		System.out.println(rdj.findUserPending(u));
	}

}
