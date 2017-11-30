package com.revature.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.ErsReimbursement;
import com.revature.beans.ErsUser;
import com.revature.exceptions.InvalidCredentialException;
import com.revature.util.ConnectionUtil;

public class ErsUserDaoJDBC implements ErsUserDao {

	private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	private ErsUser extractUser(ResultSet rs) throws SQLException {
		ErsUser u = new ErsUser();
		u.setUserID(rs.getInt("ERS_USERS_ID"));
		u.setUsername(rs.getString("ERS_USERNAME"));
		u.setPassword(rs.getString("ERS_PASSWORD"));
		u.setEmail(rs.getString("USER_EMAIL"));
		u.setFirstName(rs.getString("USER_FIRST_NAME"));
		u.setLastName(rs.getString("USER_LAST_NAME"));
		u.setRole(rs.getString("USER_ROLE"));
		return u;
	}

	public List<ErsUser> findAll() {
		System.out.println("attempting to retreive all users from the database");
		List<ErsUser> users = new ArrayList<ErsUser>();
		try (Connection conn = cu.getConnection()) {
			ResultSet rs = conn.prepareStatement(
					"SELECT * FROM ERS_USERS join ERS_USER_ROLES on ERS_USERS.USER_ROLE_ID = ERS_USER_ROLES.ERS_USER_ROLE_ID;")
					.executeQuery();

			System.out.println("extracting users from the result set");
			while (rs.next()) {
				ErsUser u = extractUser(rs);
				users.add(u);
			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("failed to retreive all users from the database");
		}
		return null;
	}

	public ErsUser findByUserId(int userId) {
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM (ERS_USERS join ERS_USER_ROLES on ERS_USERS.USER_ROLE_ID = ERS_USER_ROLES.ERS_USER_ROLE_ID) WHERE ERS_USERS_ID =?");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			ErsUser user = new ErsUser();
			if (rs.next()) {
				user = extractUser(rs);
			}

			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void deleteUser(ErsUser user) {
		// TODO Auto-generated method stub

	}

	public void registerUser(ErsUser user) {
		// TODO Auto-generated method stub

	}

	@Override
	public ErsUser findByUsernameAndPassword(String username, String password) throws InvalidCredentialException {

		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM (ERS_USERS join ERS_USER_ROLES on ERS_USERS.USER_ROLE_ID = ERS_USER_ROLES.ERS_USER_ROLE_ID) WHERE ERS_USERNAME = ? AND ERS_PASSWORD = ?");
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			ErsUser user = new ErsUser();
			if (rs.next()) {
				user = extractUser(rs);
				return user;
			} else {

				throw new InvalidCredentialException(403);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void newUser(ErsUser user) throws SQLException {
		Connection conn = cu.getConnection();
		PreparedStatement ps = conn.prepareStatement(
				"INSERT INTO ERS_USERS (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID) VALUES (?, ?, ?, ?, ?, ?)");
		ps.setString(1, user.getUsername());

		// Turn the password into a hash
		String password = user.getPassword();
		java.security.MessageDigest md;
		try {
			md = java.security.MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}

			// Get complete hashed password in hex format
			password = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ps.setString(2, password);
		ps.setString(3, user.getFirstName());
		ps.setString(4, user.getLastName());
		ps.setString(5, user.getEmail());
		ps.setString(6, user.getRole());

		ps.executeUpdate();

	}

}
