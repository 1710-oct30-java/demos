package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class UserDaoJDBC implements UserDAO{

	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
	private User getUserFromResultSet(ResultSet rs) throws SQLException{
		
		int id = rs.getInt("ers_users_id");
		String username = rs.getString("ers_username");
		String password = rs.getString("ers_password");
		String fname = rs.getString("user_first_name");
		String lname = rs.getString("user_last_name");
		String email = rs.getString("user_email");
		int roleId = rs.getInt("user_role_id");
	
		return new User(id,username,password,fname,lname,email,roleId);
	}
	
	@Override
	public User getUserbyId(int id) {
		
		try(Connection conn = conUtil.getConnection()){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers_users WHERE ers_users_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return getUserFromResultSet(rs);
			}	
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<User> retrieveAllUsers() {
		
		List<User> users = new ArrayList<>();
		
		try(Connection conn = conUtil.getConnection()){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers_users");
			ResultSet rs = ps.executeQuery();
			
			System.out.println("connected to database, retrieving data...");
			
			while(rs.next()) {
				int id = rs.getInt("ers_users_id");
				String username = rs.getString("ers_username");
				String password = rs.getString("ers_password");
				String fname = rs.getString("user_first_name");
				String lname = rs.getString("user_last_name");
				String email = rs.getString("user_email");
				int roleId = rs.getInt("user_role_id");
				
				users.add(new User(id,username,password,fname,lname,email,roleId));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public int addUser(User u) {
		
		try(Connection conn = conUtil.getConnection()){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO ers_users (ers_username,ers_password,user_first_name,user_last_name,user_email,user_role_id) VALUES (?,?,?,?,?,?)");
			
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setString(5, u.getEmail());
			ps.setInt(6, u.getRole());
			
			ps.executeQuery();
			
			ResultSet keys = ps.getGeneratedKeys();
			if(keys.next()) {
				System.out.println("successfully added the user");
				return keys.getInt(1);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}