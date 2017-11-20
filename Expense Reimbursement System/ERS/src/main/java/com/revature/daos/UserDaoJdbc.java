package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class UserDaoJdbc implements UserDao
{
	private Logger			log		= Logger.getRootLogger();
	private ConnectionUtil	conUtil	= ConnectionUtil.getConnectionUtil();
	
	public User getReimbFromResultSet(ResultSet rs) throws SQLException
	{
		int id = rs.getInt("ers_users_id");
		String username = rs.getString("ers_username");
		String password = rs.getString("ers_password");
		String firstName = rs.getString("user_first_name");
		String lastName = rs.getString("user_last_name");
		String email = rs.getString("user_email");
		int roleId = rs.getInt("user_role_id");
		
		return new User(id, username, password, firstName, lastName, email, roleId);
	}
	
	@Override
	public int save(User u)
	{
		log.debug("Trying to save a user");
		System.out.println("Trying to save a user");
		
		try (Connection con = conUtil.getConnection())
		{
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES (?, ?, ?, ?, ?, ?)");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setString(5, u.getEmail());
			ps.setInt(6, u.getRoleId());
			ps.executeQuery();
			
			// get columns actually saved in the database
			ResultSet keys = ps.getGeneratedKeys();
			
			if (keys.next())
			{
				log.trace("Row inserted has id: " + keys.getInt(1) + "\nand username: "
						+ keys.getString(2));
				log.info("Successfully added user");
				return keys.getInt(1);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			log.debug("Failed to save user");
		}
		
		return 0;
	}
	
	@Override
	public List<User> findAll()
	{
		List<User> users = new ArrayList<>();
		log.debug("Trying to retreive all users");
		
		try (Connection con = conUtil.getConnection())
		{
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ers_users");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				int id = rs.getInt("ers_users_id");
				String username = rs.getString("ers_username");
				String password = rs.getString("ers_password");
				String firstName = rs.getString("user_first_name");
				String lastName = rs.getString("user_last_name");
				String email = rs.getString("user_email");
				int roleId = rs.getInt("user_role_id");
				
				users.add(new User(id, username, password, firstName, lastName, email, roleId));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			log.warn("Failed to retreive all users");
		}
		
		return users;
	}
	
	@Override
	public User findById(int id)
	{
		log.debug("Trying to retreive users with id: " + id);
		try (Connection con = conUtil.getConnection())
		{
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM ers_users WHERE ers_users_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
			{
				return getReimbFromResultSet(rs);
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			log.warn("Failed to retreive reimbursement");
		}
		return null;
	}
}