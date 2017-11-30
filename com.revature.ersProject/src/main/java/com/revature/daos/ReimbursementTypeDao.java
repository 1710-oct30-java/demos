package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

import com.revature.beans.ReimbursementType;
import com.revature.connectionutil.ConnectionUtil;

public class ReimbursementTypeDao {
	
	private Logger log = Logger.getLogger(ReimbursementTypeDao.class);
	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
	private ReimbursementType type = new ReimbursementType();
	

	public String getReimbursementType(int r_type_id) {
		
		type.setR_type("Invalid");
		
		// Check that input is a valid status code (1-4) 
		if (r_type_id > 0 && r_type_id < 5) {

			log.debug("Retreiving the reimbursement...");
			
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
				log.debug("Failed to retrieve the reimbursement");
			}
		}

		// It will hit this if input is not a valid status code
		else {
			log.debug("'" + r_type_id + "'" + " is not a valid type code!");
			log.debug("Reimbursement Type Code: 1) Lodging | 2) Travel | 3) Food | 4) Other");
		}
		
		return type.getR_type();
	}
	
	
	
}
