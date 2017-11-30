package com.ers.launcher;

import org.apache.log4j.PropertyConfigurator;

import com.ers.beans.Personnel;
import com.ers.beans.Reimbursement;
import com.ers.beans.User;
import com.ers.dao.RStatusDAO;
import com.ers.dao.RTypeDAO;
import com.ers.dao.ReimbursementDAOJdbc;
import com.ers.dao.UserRolesDAO;
import com.ers.dao.UsersDAOJdbc;
import com.ers.services.ManagerService;
import com.ers.services.UserService;

public class Launcher {

	public static void main(String[] args) {
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		
		/*
		//ReimbursementDAO reimbDao = new ReimbursementDAO();
		UserService us = new UserService();
		ManagerService ms = new ManagerService();
		
		User user = new User("", "", "", "", "", 3);
		String username = "wbruce";
		String password = "batman";
		user.setUsername(username);
		user.setPassword(password);
		
		
		if(us.checkCredentials(user)) {
			user = us.getUserInformation(user);
			user.getReimbursements().addAll(us.getReimbursementsByUser(user));
		}
		
		Reimbursement reimb = new Reimbursement(0, 0, "", "", "", "", 0, 0, 0, 0);
		reimb = ms.getReimbursementById(1000024);
		
		ms.updateReimbursement(user, reimb, 3);
		*/
	}
}
