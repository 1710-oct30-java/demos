package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Reimbursement;
import com.revature.beans.User;
import com.revature.beans.UserRoles;
import com.revature.util.ConnectionUtil;

public class UserDaoJDBC implements UsersDAO {

	private Logger log = Logger.getRootLogger();
	private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	@Override
	public int addUser(User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> findAllUsers() {
		log.debug("Attempting to retrieve all users from the the database");
		List<User> users = new ArrayList<>();
		try (Connection con = cu.getConnection()) {
			ResultSet rs = con.prepareStatement("SELECT * FROM ers_users").executeQuery();

			while (rs.next()) {
				User user = getUserFromDB(rs);
				users.add(user);
			}
			log.debug(users);
			return users;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn("failed to retrieve all users from the database");
		}
		return null;
	}

	private User getUserFromDB(ResultSet rs) throws SQLException {
		User u = new User();
		u.setUsersId(rs.getInt("ers_users_id"));
		u.setUsername(rs.getString("ers_username"));
		u.setPassword(rs.getString("ers_password"));
		u.setFirstName(rs.getString("user_first_name"));
		u.setLastName(rs.getString("user_lastName"));
		u.setEmail(rs.getString("user_email"));
		int roleId = rs.getInt("user_role_id");
		u.setRoleId(new UserRoles(roleId));
		return u;
	}

	@Override
	public User findUserById(int id) {
		log.debug("Attempting to retrieve user by id");
		try (Connection con = cu.getConnection()) {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ers_users WHERE ers_users_id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			User user = getUserFromDB(rs);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		log.debug("Atempting to retrieve using username and password");
		try(Connection con = cu.getConnection()){
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ers_users WHERE ers_username=? "
					+ "AND ers_password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				User u = new User();
				u.setUsername(username);
				u.setPassword(password);
				u.setUsersId(rs.getInt("ers_users_id"));
				u.setEmail(rs.getString("user_email"));
				u.setFirstName(rs.getString("user_first_name"));
				u.setLastName(rs.getString("user_last_name"));
				u.setRoleId(new UserRoles(rs.getInt("user_role_id")));
				//u.setReimbList(new ArrayList<Reimbursement>());
				return u;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
