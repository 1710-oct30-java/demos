package com.revature.daos.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.ReimbRequest;
import com.revature.beans.User;
import com.revature.daos.RequestDAO;
import com.revature.daos.UserDAO;
import com.revature.util.ConnectionUtil;

public class UserJDBC implements UserDAO {

	private static Logger log = Logger.getRootLogger();
	private static ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();
	private static RequestDAO requestDAO = new RequestJDBC(); 
	
	private static User getUserFromResultSet(ResultSet result) throws SQLException
	{
		User resultUser = new User();
		resultUser.setUserId(result.getInt("ers_users_id"));
		resultUser.setUserName(result.getString("ers_username"));
		resultUser.setUserPassword(result.getString("ers_password"));
		resultUser.setFirstName(result.getString("user_first_name"));
		resultUser.setLastName(result.getString("user_last_name"));
		resultUser.setEmail(result.getString("user_email"));
		resultUser.setRoleID(result.getInt("user_role_id"));
		resultUser.setStatusID(result.getInt("user_status_id"));
		
		List<ReimbRequest> requestList = new ArrayList<ReimbRequest>();
		requestList = requestDAO.getRequestsByUserId(resultUser.getUserId());
		resultUser.setRequests(requestList);
		
		return resultUser;
	}
	
	@Override
	public User getUserByUsername(String username)
	{
		log.debug("Finding user with username " + username);
		User returnedUser = new User();
		
		try (Connection conn = connUtil.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ers_users WHERE ers_username = ?");
			stmt.setString(1, username);
			ResultSet results = stmt.executeQuery();
			
			if(results.next())
			{
				return getUserFromResultSet(results);
			}
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
			log.warn("Failed to aquire user from database.");
		}
		
		return returnedUser;
	}
	
	@Override
	public String getPasswordByUsername(String username)
	{
		log.debug("Finding password of user with username " + username);
		
		try (Connection conn = connUtil.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT ers_password FROM ers_users WHERE ers_username = ?");
			stmt.setString(1, username);
			ResultSet results = stmt.executeQuery();
			
			if(results.next())
			{
				return results.getString(1);
			}
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
			log.warn("Failed to aquire user from database.");
		}
		
		return null;
	}

	@Override
	public User getUserById(int id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createUser(String username, String password, String firstName, String lastName, int roleID, int statusID)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean userExists(String username, String email)
	{
		// TODO Auto-generated method stub
		return false;
	}
	
}
