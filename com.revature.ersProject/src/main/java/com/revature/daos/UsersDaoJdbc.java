package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.connectionutil.ConnectionUtil;

public class UsersDaoJdbc  implements UsersDao{
	
	private Logger log = Logger.getLogger(UsersDaoJdbc.class);
	private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	
	public User signIn(String username, String password) {
	
		try (Connection conn = cu.getConnection()) {
	         PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers_users WHERE ers_username = ? AND ers_password = ?");
	         ps.setString(1, username);
	         ps.setString(2, password); 
	         System.out.println("Hello world");
	         ResultSet rs = ps.executeQuery();
	
	         if (rs.next()) {
	             User u = new User();
	             u.setUser_id(rs.getInt("ers_users_id"));
	             u.setUsername(username);
	             u.setPassword(password);
	             u.setfirstname(rs.getString("user_first_name"));
	             u.setlastname(rs.getString("user_last_name"));
	             u.setEmail(rs.getString("user_email"));
	             u.setRole_id(rs.getInt("user_role_id"));
	             return u;
	         }
	         log.info("Invalid username or password.");
		 } 
		 catch (SQLException e) {
	     // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
		return null;
     }
}
