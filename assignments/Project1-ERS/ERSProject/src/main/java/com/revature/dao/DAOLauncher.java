package com.revature.dao;

import java.sql.Timestamp;
import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.beans.User;
import com.revature.dao.ReimbursementDaoJDBC;
import com.revature.dao.UserDaoJDBC;

public class DAOLauncher {

	public static void main(String[] args) {
		
		//ReimbursementDaoJDBC rTest = new ReimbursementDaoJDBC();
		UserDaoJDBC uTest = new UserDaoJDBC();
		
		//List<User> users = uTest.retrieveAllUsers();
		
		//System.out.println(users);
		
		User testUser = new User("blakek","pass","Blake", "K", "blake@email.com", 2);
		
		uTest.addUser(testUser);
		
		//System.out.println(uTest.getUserbyId(2));
		
		//List<Reimbursement> reimbursement = rTest.retrieveAllReimbursements();	
		
		//System.out.println(reimbursement);
		
		//Reimbursement tester = new Reimbursement(45, new Timestamp(System.currentTimeMillis()), null, "description", 1, 1, 1, 1);
		
		//rTest.addReimbursement(tester);
		
		//System.out.println(rTest.getReimbursementByID(1));
		
	}
}
