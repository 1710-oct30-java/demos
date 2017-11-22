package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import beans.User;
import util.ConnectionUtil;

public class UserDaoJdbc implements UserDao {
	private Logger log = Logger.getRootLogger();
	private ConnectionUtil conUtil = ConnectionUtil.getconnectionUtil();
	Properties p = new Properties();
	private ReimbursementDao rd = new ReimbursementDaoJdbc();
	
	@Override
	public void saveUser(User u) throws SQLException {
		log.debug("attempt to insert user to database");
		Connection con = conUtil.getConnection();
		PreparedStatement insertUser = null;
		
		String insertStatement =
				"INSERT INTO Users" + 
				" (userID, username, password, firstName, lastName, email, roleID, activeState)" +
				" VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			con.setAutoCommit(false);
			
			insertUser = con.prepareStatement(insertStatement);
			insertUser.setInt(1, u.getUserID());
			insertUser.setString(2, u.getUsername());
			insertUser.setString(3,  u.getUsername());
			insertUser.setString(4, u.getPassword());
			insertUser.setString(5, u.getEmail());
			insertUser.setInt(6, u.getRoleID());
			insertUser.setInt(7, u.getActiveState());
			
			insertUser.executeUpdate();
			
			ResultSet keys = insertUser.getGeneratedKeys();
			if (keys.next()) {
				log.info("successfully added user");
			}
			
			con.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			if (con != null) {
				try {
					log.debug("failed to save user, roll back transaction");
					con.rollback();
				} catch(SQLException ex) {
					e.printStackTrace();
				}
			}
			
		} finally {
			if (insertUser != null) {
				insertUser.close();
			}
			con.setAutoCommit(true);
		}
	}
	
	@Override
	public void updateUser(User u) throws SQLException {
		log.debug("attempt to update existing user in database");
		Connection con = conUtil.getConnection();
		PreparedStatement updateUser = null;
		
		String updateStatement = 
				"UPDATE Users" + 
				" SET username = ?, password = ?, firstname = ?, lastname = ?, email = ?, roleID = ?"
				+ " WHERE userid = ?";
		
		try {
			con.setAutoCommit(false);
			
			updateUser = con.prepareStatement(updateStatement);
			updateUser.setString(1, u.getUsername());
			updateUser.setString(2, u.getPassword());
			updateUser.setString(3, u.getFirstName());
			updateUser.setString(4, u.getLastName());
			updateUser.setString(5, u.getEmail());
			updateUser.setInt(6,u.getRoleID());
			updateUser.setInt(7, u.getUserID());
			
			updateUser.executeUpdate();
			
			ResultSet keys = updateUser.getGeneratedKeys();
			if (keys.next()) {
				log.info("successfully updated user");
			}
			
			con.commit();
			
		} catch (SQLException e){
			e.printStackTrace();
			if (con != null) {
				try {
					log.debug("failed to save user, roll back transaction");
					con.rollback();
				} catch(SQLException ex) {
					e.printStackTrace();
				}
			}
			
		} finally {
			if (updateUser != null) {
				updateUser.close();
			}
			con.setAutoCommit(true);
		}
	}

	@Override
	public void deactivateUser(User u) throws SQLException {
		log.debug("attempt to deactivate existing user in database");
		Connection con = conUtil.getConnection();
		PreparedStatement deUser = null;
		
		String deStatement = 
				"UPDATE Users" + 
				" SET activeState = 0"
				+ "WHERE userid = ?";
		
		try {
			con.setAutoCommit(false);
			deUser = con.prepareStatement(deStatement);
			deUser.setInt(1,  u.getUserID());
			deUser.executeUpdate();
			
			ResultSet keys = deUser.getGeneratedKeys();
			if (keys.next()) {
				log.info("successfully updated user");
			}
			
			con.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			if (con != null) {
				try {
					log.debug("failed to save user, roll back transaction");
					con.rollback();
				} catch(SQLException ex) {
					e.printStackTrace();
				}
			}
			
		} finally {
			if (deUser != null) {
				deUser.close();
			}
			con.setAutoCommit(true);
		}
	}
	
	

	@Override
	public void activateUser(User u) throws SQLException {
		log.debug("attempt to deactivate existing user in database");
		Connection con = conUtil.getConnection();
		PreparedStatement actUser = null;
		
		String actStatement = 
				"UPDATE Users SET activeState = 1 WHERE userid = ?";
		
		try {
			con.setAutoCommit(false);
			actUser = con.prepareStatement(actStatement);
			actUser.setInt(1,  u.getUserID());
			
			actUser.executeUpdate();
			
			ResultSet keys = actUser.getGeneratedKeys();
			if (keys.next()) {
				log.info("successfully updated user");
			}
			
			con.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			if (con != null) {
				try {
					log.debug("failed to activate user, roll back transaction");
					con.rollback();
				} catch(SQLException ex) {
					e.printStackTrace();
				}
			}
			
		} finally {
			if (actUser != null) {
				actUser.close();
			}
			con.setAutoCommit(true);
		}	
	}
	
	private User extractUser(ResultSet rs) throws SQLException {
		User u = new User();
		u.setUsername(rs.getString("username"));
		u.setPassword(rs.getString("password"));
		u.setFirstName(rs.getString("firstname"));
		u.setLastName(rs.getString("lastname"));
		u.setEmail(rs.getString("email"));
		u.setRoleID(rs.getInt("roleID"));
		u.setActiveState(rs.getInt("activeState"));
		
		return u;
	}

	public List<User> findAll() throws SQLException {
		log.debug("attempt to retrieve all users in database");
		Connection con = conUtil.getConnection();
		List<User> users = new ArrayList<User>();
		
		PreparedStatement getUsers = null;
		String getUsersStatement = 
				"SELECT * FROM Users";
		
		try {
			getUsers = con.prepareStatement(getUsersStatement);
			ResultSet rs = getUsers.executeQuery();
			
			while (rs.next()) {
				User u = extractUser(rs);
				u.setReimbursements(rd.findUserReimbursements(u.getUserID()));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("failed to retrieve users");
		}
		return users;
	}

	public User findById(String username, String password) throws SQLException {
		Connection con = conUtil.getConnection();
		PreparedStatement findUser = null;
		
		String findUserStatement = 
				"SELECT * FROM Users WHERE username = ? AND password = ?";
		
		try {
			log.trace(findUserStatement);
			findUser = con.prepareStatement(findUserStatement);
			findUser.setString(1, username);
			findUser.setString(2, password);	
			ResultSet rs = findUser.executeQuery();
			
			while(rs.next()) {
				User u = new User();
				u.setUsername(username);
				u.setPassword(password);
				u.setUserID(rs.getInt("userID"));
				return u;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("failed to get user");
		}
		return null;
	}
}
