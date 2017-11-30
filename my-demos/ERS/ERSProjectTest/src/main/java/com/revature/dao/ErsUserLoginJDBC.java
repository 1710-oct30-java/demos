package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.ErsUser;
import com.revature.util.ConnectionUtil;

public class ErsUserLoginJDBC implements ErsUserLoginDAO {
	private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	@Override
	public ErsUser findByUsernameAndPassword(String username, String password) {
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers_users WHERE ers_username = ? AND ers_password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ErsUser u = new ErsUser();
				u.setErsUsername(username);
				u.setErsPassword(password);
				u.setErsUserId(rs.getInt("ers_user_id"));
				return u;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
