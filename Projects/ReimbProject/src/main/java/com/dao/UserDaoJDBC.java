package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.beans.User;
import com.util.ConnectionUtil;

public class UserDaoJDBC implements UserDao
{
	private Logger log = Logger.getRootLogger();
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

	public User extractUser(ResultSet rs) throws SQLException
	{
		User user = new User();
		user.setUserId(rs.getInt("users_id"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setfName(rs.getString("first_name"));
		user.setlName(rs.getString("last_name"));
		user.setEmail(rs.getString("email"));
		user.setRoleId(rs.getInt("role_id"));

		return user;
	}

	@Override
	public List<User> findAll()
	{
		List<User> users = new ArrayList<>();

		try (Connection conn = connUtil.getConnection())
		{
			log.debug("Retrieving all from USERS table");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users");
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				users.add(extractUser(rs));
			}

			return users;

		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<String> getPassword(String username)
	{
		List<String> pass = new ArrayList<>();
		try (Connection conn = connUtil.getConnection())
		{
			log.debug("Retrieving password for " + username);
			PreparedStatement ps = conn.prepareStatement("SELECT password FROM users WHERE " + "username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				pass.add(rs.getString("password"));
			}
			return pass;
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pass.add(null);
		return pass;
	}
}
