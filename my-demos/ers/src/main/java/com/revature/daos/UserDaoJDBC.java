package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class UserDaoJDBC implements UserDao {
	private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	
	public User findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		try(Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from users where ers_username = ? and ers_password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				User u = new User();
				u.setUsername(username);
				u.setPassword(password);
				u.setUserID(rs.getInt("ers_users_id"));
				u.setFirstName(rs.getString("user_first_name"));
				u.setLastName(rs.getString("user_last_name"));
				u.setEmail(rs.getString("user_email"));
				u.setRoleID(rs.getInt("user_role_id"));
				return u;
			}
		}
		
		catch(SQLException e) {
			
		}
			
		return null;
	}

}
