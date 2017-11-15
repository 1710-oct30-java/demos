package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class UserDaoJDBC implements UserDao {
	private Logger log = Logger.getRootLogger();
	private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	private FlashCardDao fcd = new FlashCardDaoJDBC();
	
	
	private User extractUser(ResultSet rs) throws SQLException {
		User u = new User();
		u.setUserId(rs.getInt("user_id"));
		u.setUsername(rs.getString("username"));
		u.setPassword(rs.getString("password"));
		return u;
	}
	

	public List<User> findAll() {
		log.debug("attempting to retreive all users from the database");
		List<User> users = new ArrayList<>();
		try(Connection conn = cu.getConnection()) {
			ResultSet rs = conn.prepareStatement("SELECT * FROM app_user").executeQuery();
			
			log.trace("extracting users from the result set");
			while(rs.next()) {
				User u = extractUser(rs);
				u.setFlashCards(fcd.findByUserId(u.getUserId()));
				users.add(u);
			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn("failed to retreive all users from the database");
		}
		return null;
	}

}
