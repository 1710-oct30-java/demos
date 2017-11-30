package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.User;
import com.revature.utilities.ConnectionUtil;
import com.revature.utilities.DAOUtilities;

public class UserDAOImpl implements UserDAO {
	private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	Connection conn = null;
	PreparedStatement stmt = null;

	public List<User> getAllUsers() {

		List<User> users = new ArrayList<User>();

		try {
			conn = ConnectionUtil.getConnection();
			String sql = "Select * from ers_users";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				User u = new User();
				u.setUserId(rs.getInt("ers_users_id"));
				u.setUsername(rs.getString("ers_username"));
				u.setPassword(rs.getString("ers_password"));
				u.setFirstName(rs.getString("user_firstname"));
				u.setLastName(rs.getString("user_lastname"));
				u.setEmail(rs.getString("user_email"));
				u.setRoleId(rs.getInt("user_role_id"));

				users.add(u);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return users;
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM ers_users WHERE ers_username=? AND ers_password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				User u = new User();
				u.setUsername(username);
				u.setPassword(password);
				u.setUserId(rs.getInt("ers_users_id"));
				u.toString();
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
