package com.revature.daos;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.User;

public interface UsersDao {
	public User signIn (String username, String password);
	
}