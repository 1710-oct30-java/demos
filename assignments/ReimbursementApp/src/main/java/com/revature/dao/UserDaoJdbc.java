package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class UserDaoJdbc implements UserDao {

	private Logger log = Logger.getRootLogger();
	private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	private ReimbursementDao rd = new ReimbursementDaoJdbc();

	private User extractUser(ResultSet rs) throws SQLException {
		User u = new User();
		u.setUsername(rs.getString("username"));
		u.setPassword(rs.getString("pword"));
		u.setUserId(rs.getInt("userid"));
		return u;
	}

	public User findUser(String username, String password) {
		log.debug("Attempting to retreive specified user");
		User user = new User();

		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * from users WHERE username = ? AND pword= ?");
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			log.trace("Extracting User");
			while (rs.next()) {
				User u = extractUser(rs);
				user = u;
			}
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
