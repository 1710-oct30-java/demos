package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ers.beans.Reimbursement;
import com.ers.beans.User;
import com.ers.beans.UserRoles;
import com.ers.util.ConnectionUtil;

public class UserRolesDAO {

	private Logger log = Logger.getLogger(UserRolesDAO.class);
	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();

	private UserRoles role = new UserRoles();

	/**
	 * Access database and returns string of user role by parameter input id.
	 * @param role_id
	 * @return
	 */
	public String getUserRoleById(int role_id) {

		role.setUser_role("Invalid");

		// Check that input is a valid status code (0-2)
		if (role_id >= 0 && role_id < 3) {

			log.debug("Retreiving user role...");

			try (Connection conn = conUtil.getConnection()) {

				String query = "SELECT * FROM USER_ROLES WHERE role_id = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, role_id);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					role.setUser_role(rs.getString("user_role"));
				}

				log.debug("User role found! Role: " + role.getUser_role());

			} catch (SQLException e) {
				e.printStackTrace();
				log.debug("Failed to retrieve user role!");
			}
		}

		// Else input is not a valid status code
		else {
			log.debug("'" + role_id + "'" + " is not a valid user role id!");
			log.debug("User Role ID: 0) Admin | 1) Manager | 2) Employee");
		}

		return role.getUser_role();
	}

}
