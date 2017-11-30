package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.ErsReimbursement;
import com.revature.beans.ErsUser;
import com.revature.exceptions.InvalidCredentialException;

public interface ErsUserDao {
	
	List<ErsUser> findAll();
	ErsUser findByUserId(int userId);
	void deleteUser(ErsUser user);
	void registerUser(ErsUser user);
	ErsUser findByUsernameAndPassword(String username, String password) throws InvalidCredentialException;
	void newUser(ErsUser user) throws SQLException;
}
