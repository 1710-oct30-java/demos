package com.revature.launcher;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.model.User;
import com.revature.utilities.ConnectionUtil;
import com.revature.utilities.DAOUtilities;

public class Launcher {

	public static void main(String[] args) {
		
		UserDAO dao = ConnectionUtil.getUserDAO();
		List<User> users = new ArrayList<User>();
		users = dao.getAllUsers();
		
		for (User u : users) {
			System.out.println(u.toString());
		}
		
	}

}
