package com.ers.servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ers.util.ConnectionUtil;

public class LoginHelper {

	private static Logger log = Logger.getLogger(LoginHelper.class);
	private static ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

	// Check the users credentials
	public static boolean checkCredentials(String username, String password) {
		
		log.debug("Checking user credentials...");
		
		try (Connection conn = connUtil.getConnection()) {
			
			String query = "SELECT username, email, password FROM USERS "
						+ "WHERE username = ? AND password = STANDARD_HASH(?, 'SHA256')";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			// Move ResultSet cursor to first row
			//rs.next();
			
			
				return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
