package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.beans.Reimbursement;
import com.revature.beans.Users;
import com.revature.util.ConnectionUtil;

public class UsersDAOJdbc implements UsersDAO{

	private Logger log = Logger.getRootLogger();
	private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	private ReimbursementDAO reimb = new ReimbursementDAOJdbc();
	
	
	private Users extractUser(ResultSet rs) throws SQLException {
		Users u = new Users();
		u.setUsers_id(rs.getInt("users_id"));
		u.setUsername(rs.getString("username"));
		u.setPassword(rs.getString("password"));
		u.setFirst_name(rs.getString("firstname"));
		u.setLast_name(rs.getString("lastname"));
		u.setEmail(rs.getString("email"));
		u.setUser_role_id(rs.getInt("user_role_id"));
		return u;
	}
	
	public int psUserSave(Users u) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Users> findAll() {
		log.debug("attempting to retreive all users from the database");
		List<Users> users = new ArrayList<>();
		try(Connection conn = cu.getConnection()) {
			ResultSet rs = conn.prepareStatement("SELECT * FROM users").executeQuery();
			
			log.trace("extracting users from the result set");
			while(rs.next()) {
				int id = rs.getInt("users_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				int userRoleId = rs.getInt("user_role_id");
				users.add(new Users(id, username, password, firstname, lastname, email, userRoleId));
			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn("failed to retreive all users from the database");
		}
		return null;
	}

	public Users findById(int id) {
		
		Users u = new Users();
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE users_id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				u = extractUser(rs);
				//users.add(u);
			}

			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public Users signIn(String username, String password) {
		
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Users u = new Users();
				u.setUsers_id(rs.getInt("users_id"));
				u.setUsername(username);
				u.setPassword(password);
				u.setFirst_name(rs.getString("firstname"));
				u.setLast_name(rs.getString("lastname"));
				u.setEmail(rs.getString("email"));
				u.setUser_role_id(rs.getInt("user_role_id"));
				return u;
			}
			log.info("Invalid username or password.");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
		return null;
}
}