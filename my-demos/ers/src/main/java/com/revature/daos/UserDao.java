package com.revature.daos;

import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.beans.User;

public interface UserDao {
	User findByUsernameAndPassword(String username, String password);
	
	
}
