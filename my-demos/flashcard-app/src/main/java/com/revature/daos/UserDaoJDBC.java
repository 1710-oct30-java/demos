package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class UserDaoJDBC implements UserDao {
	Logger logger = Logger.getRootLogger();
	private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	
	@Override
	public User findByUsernameAndPassword(String username, String password) {
		logger.trace("attempting to get user with username and password " + username +" " + password);
		try(Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM app_user WHERE username = ? AND password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				User u = new User();
				u.setUsername(username);
				u.setPassword(password);
				u.setUserID(rs.getInt("user_id"));
				return u;
				
			}
		}
		catch(SQLException e) {
			
		}
		return null;
	}

}
