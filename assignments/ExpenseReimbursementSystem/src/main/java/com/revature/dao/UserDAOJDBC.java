package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class UserDAOJDBC implements UserDAO {
	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	private Logger log = Logger.getRootLogger();

	@Override
	public List<User> findAll() {

		List<User> users = new ArrayList<>();
		log.debug("attempting to retreive all users");

		try (Connection conn = conUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_USERS");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ERS_USERS_ID");
				String username = rs.getString("ERS_USERNAME");
				String password = rs.getString("ERS_PASSWORD");
				String fName = rs.getString("USER_FIRST_NAME");
				String lName = rs.getString("USER_LAST_NAME");
				String email = rs.getString("USER_EMAIL");
				int roleId = rs.getInt("USER_ROLE_ID");
				users.add(new User(id, username, password, fName, lName, email, roleId));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn("failed to retreive");
		}

		return users;
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		try (Connection conn = conUtil.getConnection()) {
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERNAME = ? AND ERS_PASSWORD = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				User u = new User();
				u.setUsername(username);
				u.setPassword(password);
				u.setId(rs.getInt("ERS_USERS_ID"));
				u.setRole(rs.getInt("USER_ROLE_ID"));
				return u;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
