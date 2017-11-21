package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ers.beans.ReimbursementStatus;
import com.ers.util.ConnectionUtil;

public class RStatusDAO {
	
	private Logger log = Logger.getLogger(RStatusDAO.class);
	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
	private ReimbursementStatus status = new ReimbursementStatus();
	
	/**
	 * Access database and returns string of reimbursement status.
	 * @param r_type_id
	 * @return
	 */
	public String getReimbursementStatus(int r_status_id) {
		
		status.setStatus("Invalid");
		
		// Check that input is a valid status code (1-3)
		if (r_status_id > 0 && r_status_id < 5) {

			log.debug("Retreiving reimbursement status...");
			
			try (Connection conn = conUtil.getConnection()) {

				String query = "SELECT * FROM REIMBURSEMENT_STATUS WHERE r_status_id = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, r_status_id);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					status.setStatus(rs.getString("r_status"));
				}
				
				log.debug("Reimbursement status found! Status: " + status.getStatus());

			} catch (SQLException e) {
				e.printStackTrace();
				log.debug("Failed to retrieve reimbursement status!");
			}
		}

		// Else input is not a valid status code
		else {
			log.debug("'" + r_status_id + "'" + " is not a valid status code!");
			log.debug("Reimbursement Status Code: 1) Pending | 2) Approved | 3) Denied");
		}
		
		return status.getStatus();
	}
}
