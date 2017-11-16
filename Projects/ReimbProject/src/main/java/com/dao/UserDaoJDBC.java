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
		user.setUserId(rs.getInt("ers_users_id"));
		user.setUsername(rs.getString("ers_username"));
		user.setPassword(rs.getString("ers_password"));
		user.setfName(rs.getString("user_first_name"));
		user.setlName(rs.getString("user_last_name"));
		user.setEmail(rs.getString("user_email"));
		user.setRoleId(rs.getInt("user_role_id"));

		return user;
	}

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

		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
