package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class UserDaoJDBC implements UserDao{
	
	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();

	public List<User> getAllUsers() {
		List<User> temp = new ArrayList<>();
		try(Connection conn = conUtil.getConnection()){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User u = new User();
				u.setUserId(rs.getInt("users_id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setFirstName(rs.getString("first_name"));
				u.setLastName(rs.getString("last_name"));
				u.setUserRoleId(rs.getInt("user_role_id"));
				u.setEmail(rs.getString("email"));
				temp.add(u);
			}
			//else return null;
			
			return temp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public User getUserById(int id) {
		System.out.println("get user by id.");
		try (Connection conn = conUtil.getConnection()) {
			System.out.println("attempting query.");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE users_id = ?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				User u = new User();
				u.setUserId(rs.getInt("users_id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setFirstName(rs.getString("first_name"));
				u.setLastName(rs.getString("last_name"));
				u.setUserRoleId(rs.getInt("user_role_id"));
				u.setEmail(rs.getString("email"));
				System.out.println(u.toString());
				return u;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

}
