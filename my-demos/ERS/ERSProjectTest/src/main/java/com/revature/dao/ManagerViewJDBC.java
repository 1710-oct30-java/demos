package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.ErsReimbursement;
import com.revature.util.ConnectionUtil;

public class ManagerViewJDBC implements ManagerViewDAO {
	
	private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	@Override
	public List<ErsReimbursement> getAllRequests() {
		try(Connection connection= cu.getConnection()) {
			List<ErsReimbursement> empPastReimbursements = new ArrayList<>();
			String getAllReimbs = "SELECT * FROM ers_reimbursement";
			
			PreparedStatement ps = connection.prepareStatement(getAllReimbs);
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ErsReimbursement reimbursement = new ErsReimbursement();
				reimbursement.setReimbId(rs.getInt("REIMB_ID"));
				reimbursement.setReimbAmount(rs.getFloat("REIMB_AMOUNT"));
				reimbursement.setReimbSubmitted(rs.getTimestamp("REIMB_SUBMITTED").toLocalDateTime());
				reimbursement.setReimbAuthor(rs.getInt("REIMB_AUTHOR"));
				reimbursement.setReimbStatusId(rs.getInt("REIMB_STATUS_ID"));
				reimbursement.setReimbTypeId(rs.getInt("REIMB_TYPE_ID"));
				empPastReimbursements.add(reimbursement);
			}
			
			return empPastReimbursements;
			
			
		} catch(SQLException e) {
            e.printStackTrace();
        }
		return null;
	}

	public List<ErsReimbursement> getRequestsByStatusId(int reimbStatusId) {
		try(Connection connection= cu.getConnection()) {
			List<ErsReimbursement> empPastReimbursements = new ArrayList<>();
			String getAllReimbsByStatus = "SELECT ers_reimbursement.reimb_id, ers_reimbursement.reimb_amount, ers_reimbursement.reimb_submitted, ers_reimbursement.reimb_author,\r\n" + 
					"ers_reimbursement.reimb_status_id, ers_reimbursement.reimb_type_id\r\n" + 
					"FROM ers_reimbursement WHERE ers_reimbursement.reimb_status_id = ?";
			
			PreparedStatement ps = connection.prepareStatement(getAllReimbsByStatus);
			ps.setInt(1, reimbStatusId);
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ErsReimbursement reimbursement = new ErsReimbursement();
				reimbursement.setReimbId(rs.getInt("REIMB_ID"));
				reimbursement.setReimbAmount(rs.getFloat("REIMB_AMOUNT"));
				reimbursement.setReimbSubmitted(rs.getTimestamp("REIMB_SUBMITTED").toLocalDateTime());
				reimbursement.setReimbAuthor(rs.getInt("REIMB_AUTHOR"));
				reimbursement.setReimbStatusId(rs.getInt("REIMB_STATUS_ID"));
				reimbursement.setReimbTypeId(rs.getInt("REIMB_TYPE_ID"));
				empPastReimbursements.add(reimbursement);
			}
			
			return empPastReimbursements;
			
			
		} catch(SQLException e) {
            e.printStackTrace();
        }
		return null;
	}

}
