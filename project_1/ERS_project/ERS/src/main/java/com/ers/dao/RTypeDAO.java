package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ers.beans.Reimbursement;
import com.ers.beans.ReimbursementType;
import com.ers.util.ConnectionUtil;

public class RTypeDAO {
	
	private Logger log = Logger.getLogger(RTypeDAO.class);
	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
	private ReimbursementType type = new ReimbursementType();
	
	/**
	 * Access database and returns string of reimbursement type.
	 * @param r_type_id
	 * @return
	 */
	public String getReimbursementType(int r_type_id) {
		
		type.setR_type("Invalid");
		
		// Check that input is a valid status code (1-4) and avoid invalid connection to db
		if (r_type_id > 0 && r_type_id < 5) {

			log.debug("Retreiving reimbursement type...");
			
			try (Connection conn = conUtil.getConnection()) {

				String query = "SELECT * FROM REIMBURSEMENT_TYPE WHERE r_type_id = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, r_type_id);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					type.setR_type(rs.getString("r_type"));
				}
				
				log.debug("Reimbursement type found! Type: " + type.getR_type());

			} catch (SQLException e) {
				e.printStackTrace();
				log.debug("Failed to retrieve reimbursement type!");
			}
		}

		// Else input is not a valid status code
		else {
			log.debug("'" + r_type_id + "'" + " is not a valid type code!");
			log.debug("Reimbursement Type Code: 1) Lodging | 2) Travel | 3) Food | 4) Other");
		}
		
		return type.getR_type();
	}
	
	
	
}
