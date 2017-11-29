package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class UserDaoJDBC implements UserDao {
private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	
	@Override
	public User findByUsernameAndPassword(String username, String password) {
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM User WHERE UserName = ? AND PassWord = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				User u = new User();
				u.setUsername(username);
				u.setPassword(password);
				u.setId(rs.getInt("userId"));
				return u;
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	return null;
	}
	
}
