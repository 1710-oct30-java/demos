package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.util.ConnectionUtil;
import com.revature.util.DAOcheck;

public class UsersDAOjdbc implements UsersDAO {
	private static UsersDAOjdbc udaojdbc = new UsersDAOjdbc();
	private Logger log = Logger.getRootLogger();
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();
	private String insert = "INSERT INTO users (users_id,username,password,first_name,last_name,email,role_id,flag) VALUES (?,?,?,?,?,?,?,?)";
	private String update = "UPDATE users SET ";
	private String end = " WHERE users_id = ?";
	private static DAOcheck daoc = DAOcheck.getDAOcheck();

	private UsersDAOjdbc() {
	}

	public static UsersDAOjdbc getUserDAOjdbc() {
		return udaojdbc;
	}

	@Override
	public boolean addUser(User user) {
		log.debug("Attempting to connect so we can add a user");
		try (Connection conn = connUtil.getConnection()) {
			log.debug("Attempting to add a new user");
			PreparedStatement ps = conn.prepareStatement(insert);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getFirstName());
			ps.setString(5, user.getLastName());
			ps.setString(6, user.getEmail());
			ps.setInt(7, user.getRoleId());
			ps.setString(8, user.getFlag());
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "Added User");
		} catch (SQLException e) {
			log.error("Issue when adding user to Database" + e);
			return false;
		} catch (IOException e) {
			log.warn("Unable to open properties file and open connection" + e);
			return false;
		}
	}

	@Override
	public boolean alterUserById(int oldId, User user) {
		try (Connection conn = connUtil.getConnection()) {
			log.debug("Attempting to completely alter a user");
			PreparedStatement ps = conn.prepareStatement(update
					+ "users_id = ?, username = ?, first_name = ?, last_name = ?, email = ?, role_id = ?,flag = ?"
					+ end);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getEmail());
			ps.setInt(6, user.getRoleId());
			ps.setString(7, user.getFlag());
			ps.setInt(8, oldId);
			
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "Altered User");
		} catch (SQLException e) {
			log.error("Issue when adding user to Database" + e);
			return false;
		} catch (IOException e) {
			log.warn("Unable to open properties file and open connection" + e);
			return false;
		}
	}

	@Override
	public boolean alterUserEmailById(int oldId, String newEmail) {
		try (Connection conn = connUtil.getConnection()) {
			log.debug("Attempting to alter user email");
			PreparedStatement ps = conn.prepareStatement(update + "email = ?" + end);
			ps.setString(1, newEmail);
			ps.setInt(2, oldId);
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "Altered User Email");

		} catch (SQLException e) {
			log.error("Issue when adding user to Database" + e);
			return false;
		} catch (IOException e) {
			log.warn("Unable to open properties file and open connection" + e);
			return false;
		}
	}

	@Override
	public boolean alterUserIdById(int oldId, int newId) {
		try (Connection conn = connUtil.getConnection()) {
			log.debug("Attempting to alter user id");
			PreparedStatement ps = conn.prepareStatement(update + "users_id = ?" + end);
			ps.setInt(1, newId);
			ps.setInt(2, oldId);
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "Altered User ID");
		} catch (SQLException e) {
			log.error("Issue when adding user to Database" + e);
			return false;
		} catch (IOException e) {
			log.warn("Unable to open properties file and open connection" + e);
			return false;
		}
	}

	@Override
	public boolean alterUserUserNameById(int oldId, String newUserName) {
		try (Connection conn = connUtil.getConnection()) {
			log.debug("Attempting to alter user username");
			PreparedStatement ps = conn.prepareStatement(update + "username = ?" + end);
			ps.setString(1, newUserName);
			ps.setInt(2, oldId);
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "Altered User Username");
		} catch (SQLException e) {
			log.error("Issue when adding user to Database" + e);
			return false;
		} catch (IOException e) {
			log.warn("Unable to open properties file and open connection" + e);
			return false;
		}
	}

	@Override
	public boolean alterUserPasswordById(int oldId, String password) {
		try (Connection conn = connUtil.getConnection()) {
			log.debug("Attempting to alter user password");
			PreparedStatement ps = conn.prepareStatement(update + "password = ?" + end);
			ps.setString(1, password);
			ps.setInt(2, oldId);
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "Altered User Password");
		} catch (SQLException e) {
			log.error("Issue when adding user to Database" + e);
			return false;
		} catch (IOException e) {
			log.warn("Unable to open properties file and open connection" + e);
			return false;
		}
	}

	@Override
	public boolean alterUserFirstNameById(int oldId, String newFirstName) {
		try (Connection conn = connUtil.getConnection()) {
			log.debug("Attempting to alter user first name");
			PreparedStatement ps = conn.prepareStatement(update + "first_name = ?" + end);
			ps.setString(1, newFirstName);
			ps.setInt(2, oldId);
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "Altered User FirstName");
		} catch (SQLException e) {
			log.error("Issue when adding user to Database" + e);
			return false;
		} catch (IOException e) {
			log.warn("Unable to open properties file and open connection" + e);
			return false;
		}
	}

	@Override
	public boolean alterUserLastNameById(int oldId, String newLastName) {
		try (Connection conn = connUtil.getConnection()) {
			log.debug("Attempting to alter user last name");
			PreparedStatement ps = conn.prepareStatement(update + "last_name = ?" + end);
			ps.setString(1, newLastName);
			ps.setInt(2, oldId);
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "Altered User LastName");
		} catch (SQLException e) {
			log.error("Issue when adding user to Database" + e);
			return false;
		} catch (IOException e) {
			log.warn("Unable to open properties file and open connection" + e);
			return false;
		}
	}

	@Override
	public boolean alterUserRoleIdById(int oldId, int newRoleId) {
		try (Connection conn = connUtil.getConnection()) {
			log.debug("Attempting to alter user role id");
			PreparedStatement ps = conn.prepareStatement(update + "role_id = ?" + end);
			ps.setInt(1, newRoleId);
			ps.setInt(2, oldId);
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "Altered User RoleId");
		} catch (SQLException e) {
			log.error("Issue when adding user to Database" + e);
			return false;
		} catch (IOException e) {
			log.warn("Unable to open properties file and open connection" + e);
			return false;
		}
	}

	@Override
	public boolean removeUserById(int oldId) {
		try (Connection conn = connUtil.getConnection()) {
			log.debug("Attempting to remove user by ID: " + oldId);
			PreparedStatement ps = conn.prepareStatement("DELETE FROM users WHERE users_id = ?");
			ps.setInt(1, oldId);
			int num = ps.executeUpdate();
			ps.close();
			return daoc.checkResult(num, "Removed User by ID");
		} catch (SQLException e) {
			log.error("Issue when removing user from Database " + e);
			return false;
		} catch (IOException e) {
			log.warn("Unable to open properties file and open connection " + e);
			return false;
		}
	}

	@Override
	public boolean clearUserTable() {
		try (Connection conn = connUtil.getConnection()) {
			log.debug("Attempting to clear user table");
			PreparedStatement ps = conn.prepareStatement("DELETE FROM users where 1=1");
			ps.execute();
			ps.close();
			log.info("Successfully wiped user table");
			ps = conn.prepareStatement("DROP SEQUENCE user_sequence");
			ps.execute();
			ps.close();
			ps = conn.prepareStatement("CREATE SEQUENCE user_sequence");
			ps.execute();
			ps.close();
			log.info("Sucessfully reset sequence user_sequence");
			return true;
		} catch (SQLException e) {
			log.error("Issue when adding user to Database" + e);
			return false;
		} catch (IOException e) {
			log.warn("Unable to open properties file and open connection" + e);
			return false;
		}
	}

	@Override
	public User getUserById(int id) {
		try (Connection conn = connUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE users_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				try {
					return extractUser(rs);
				} catch (SQLException e) {
					log.error("Problem when trying to extract user");
					return null;
				}
			}
		} catch (SQLException e) {
			log.error("Issue when adding user to Database" + e);
			return null;
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection" + e1);
			return null;
		}
		return null;
	}

	@Override
	public List<User> getUsers() {
		try (Connection conn = connUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users");
			ResultSet rs = ps.executeQuery();
			List<User> users = new LinkedList<>();
			while (rs.next()) {
				try {
					users.add(extractUser(rs));
				} catch (SQLException e) {
					log.error("Problem when trying to extract user");
				}
			}
			return users;
		} catch (SQLException e) {
			log.error("Issue when adding user to Database" + e);
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection" + e1);
		}
		return null;
	}

	private User extractUser(ResultSet rs) throws SQLException {
		log.debug("extracting user");
		int id = rs.getInt("users_id");
		String username = rs.getString("username");
		String password = rs.getString("password");
		String firstName = rs.getString("first_name");
		String lastName = rs.getString("last_name");
		String email = rs.getString("email");
		int roleId = rs.getInt("role_id");
		String flag = rs.getString("flag");
		log.debug("sending user");
		return new User(id, username, password, firstName, lastName, email, roleId,flag);
	}

	@Override
	public User exists(String username, String password) {
		log.trace("checking to see if exists username: " + username + " password: " + password);
		try (Connection conn = connUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				log.trace("User Exists");
				return extractUser(rs);
			}
		} catch (SQLException e) {
			log.error("Issue when getting user from Database" + e);
		} catch (IOException e1) {
			log.warn("Unable to open properties file and open connection" + e1);
		}
		log.trace("USER DNE");
		return null;
	}

}
