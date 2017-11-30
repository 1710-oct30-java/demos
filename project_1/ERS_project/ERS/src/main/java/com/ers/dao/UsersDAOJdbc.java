package com.ers.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ers.beans.Reimbursement;
import com.ers.beans.User;
import com.ers.util.ConnectionUtil;

public class UsersDAOJdbc implements UsersDAO {

	
	private Logger log = Logger.getLogger(UsersDAOJdbc.class);
	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
	
	
	public int getUserId(User user) {
		int user_id = 0;
		
		log.debug("Retreiving user id...");

		try (Connection conn = conUtil.getConnection()) {

			String query = "SELECT * FROM USERS WHERE LOWER(username) = LOWER(?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user.getUsername().toLowerCase());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user_id = rs.getInt("user_id");
			}
			
			log.debug("Retreived user id! ID: " + user_id);

		} catch (SQLException e) {
			e.printStackTrace();
			log.debug("Failed to retrieve user id!");
		}
		
		return user_id;
	}

	
	
	
	public User getUserInformation(User user) {

		log.debug("Retreiving user information...");

		try (Connection conn = conUtil.getConnection()) {

			String query = "SELECT * FROM USERS WHERE LOWER(username) = LOWER(?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user.getUsername().toLowerCase());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user.setUser_id(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setEmail(rs.getString("email"));
				user.setRole_id(rs.getInt("role_id"));
			}

			log.debug("User information loaded!\n");

		} catch (SQLException e) {
			e.printStackTrace();
			log.debug("Failed to retrieve user information!\n");
		}
		
		return user;
	}

	
	
	
	public boolean userExists(User user) {

		boolean userExist = false;

		log.debug("Checking if user exists...");

		try (Connection conn = conUtil.getConnection()) {

			String query = "SELECT * FROM USERS WHERE LOWER(username) = LOWER(?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user.getUsername().toLowerCase());

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				// If username exists, load data into user
				if (user.getUsername().toLowerCase().equals(rs.getString("username").toLowerCase())) {
					userExist = true;
				}
			}

			if (userExist) {
				log.debug("User exists!\n");
			}

			else {
				log.debug("User does not exist!\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			log.debug("Failed to retrieve user!\n");
		}

		return userExist;
	}

	
	
	
	public void addUser(User user) {

		log.debug("Connecting to database to add user...");

		try (Connection conn = conUtil.getConnection()) {

			String query = "INSERT INTO USERS(username, password, firstname, lastname, email, role_id) VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getEmail());
			ps.setInt(6, user.getRole_id());

			log.debug("Adding user to database...");
			ps.addBatch();
			ps.executeBatch();

			log.debug("User added to database!\n");

		} catch (SQLException e) {
			e.printStackTrace();
			log.debug("Failed to add user!\n");
		}
	}

	
	
	
	public void deleteUser(User user) {
	
		log.debug("Connecting to database to delete user...");

		try (Connection conn = conUtil.getConnection()) {

			String query = "DELETE FROM USERS WHERE LOWER(username) = LOWER(?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user.getUsername().toLowerCase());

			log.debug("Deleting user from database...");
			ps.addBatch();
			ps.executeBatch();

			log.debug("User deleted from database!\n");

		} catch (SQLException e) {
			e.printStackTrace();
			log.debug("Failed to delete user!\n");
		}
	}

	
	
	
	public void updateUser(User user) {
		
		log.debug("Connecting to database to update user...");

		try (Connection conn = conUtil.getConnection()) {

			CallableStatement cs = conn.prepareCall("CALL updateUser(?, ?, ?, ?, ?, ?, ?)");
			cs.setInt(1, getUserId(user));
			cs.setString(2, user.getUsername());
			cs.setString(3, user.getPassword());
			cs.setString(4, user.getFirstName());
			cs.setString(5, user.getLastName());
			cs.setString(6, user.getEmail());
			cs.setInt(7, user.getRole_id());

			log.debug("Updating user...");
			cs.execute();

			log.debug("User '" + user.getUsername() + "' updated!\n");

		} catch (SQLException e) {
			e.printStackTrace();
			log.debug("Failed to update user!\n");
		}
	}
	
	
	
	public boolean checkCredentials(User user) {

		log.debug("Checking user credentials...");

		try (Connection conn = conUtil.getConnection()) {

			String query = "SELECT * FROM USERS WHERE LOWER(username) = LOWER(?) AND password = STANDARD_HASH(?, 'SHA256')";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user.getUsername().toLowerCase());
			ps.setString(2, user.getPassword());

			ResultSet rs = ps.executeQuery();
			
			int row = 0;
			while(rs.next()) {
				row++;
			}
			
			// If row count is more than zero, credentials are valid
			if(row > 0) {
				log.debug("User credentials are valid!\n");
				return true;
			}
			
			else {
				log.debug("User credentials are invalid!\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			log.debug("Failed to retrieve user credentials!\n");
		}
		
		return false;
	}



	
	public User getUserFromCredentials(String username) {
		//User user = new User(username, password, firstName, lastName, email, role_id);
		User user = new User("", "", "", "", "", 2);
		user.setUsername(username);
		
		log.debug("Retreiving '" + username + "'...");
		
		if(userExists(user)) {
			user = getUserInformation(user);
			log.debug("User '" + username + "' found!");
		}
		
		else {
			log.debug("Unable to retrieve user '" + username + "'!");
		}
		
		return user;
	}




	@Override
	public List<User> getAllUsers() {
		List<User> list = new ArrayList<User>();

		try (Connection conn = conUtil.getConnection()) {
			
			log.debug("Retreiving user information...");
			User user;

			String query = "SELECT * FROM USERS";
			PreparedStatement ps = conn.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				//user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setEmail(rs.getString("email"));
				user.setRole_id(rs.getInt("role_id"));
				list.add(user);
			}

			// Check if any pending requests are found
			if (!list.isEmpty()) {
				log.debug("Users loaded!\n");
			}

			// Else no pending request found
			else {
				log.debug("No users found!\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			log.debug("Failed to retrieve user information!\n");
		}
		
		return list;
	}
	
}
