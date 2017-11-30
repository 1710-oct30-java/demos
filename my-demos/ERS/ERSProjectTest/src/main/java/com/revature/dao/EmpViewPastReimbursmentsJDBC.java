package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.ErsReimbursement;
import com.revature.util.ConnectionUtil;

public class EmpViewPastReimbursmentsJDBC implements EmpViewPastReimbursements {
	private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	@Override
	public ArrayList<ErsReimbursement> empViewPastReimbursements(int ersUserId) {
		try(Connection connection= cu.getConnection()) {
			ArrayList<ErsReimbursement> empPastReimbursements = new ArrayList<>();
			String getPastReimbs = 
					"SELECT ers_reimbursement.reimb_id, ers_reimbursement.reimb_amount, ers_reimbursement.reimb_submitted, ers_reimbursement.reimb_author,\r\n" + 
					"ers_reimbursement.reimb_status_id, ers_reimbursement.reimb_type_id\r\n" + 
					"FROM ers_reimbursement\r\n" + 
					"    JOIN ers_users \r\n" + 
					"        ON ers_users.ers_user_id = ers_reimbursement.reimb_author\r\n" + 
					"    JOIN ers_reimbursement_status\r\n" + 
					"        ON ers_reimbursement_status.reimb_status_id = ers_reimbursement.reimb_status_id\r\n" + 
					"    JOIN ers_reimbursement_type\r\n" + 
					"        ON ers_reimbursement.reimb_type_id = ers_reimbursement_type.reimb_type_id\r\n" + 
					"    WHERE ers_reimbursement.reimb_author = ?";
			
			PreparedStatement ps = connection.prepareStatement(getPastReimbs);
			ps.setInt(1, ersUserId);
			
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

//when i create an actual user after logging in remember to assign them their user id
//SELECT ers_reimbursement.reimb_id, ers_reimbursement.reimb_amount, ers_reimbursement.reimb_submitted, 
//ers_reimbursement_type.reimb_type, ers_reimbursement_status.reimb_status, ers_reimbursement.reimb_resolved 
//FROM ers_reimbursement
//    JOIN ers_users 
//        ON ers_users.ers_user_id = ers_reimbursement.reimb_author
//    JOIN ers_reimbursement_status
//        ON ers_reimbursement_status.reimb_status_id = ers_reimbursement.reimb_status_id
//    JOIN ers_reimbursement_type
//        ON ers_reimbursement.reimb_type_id = ers_reimbursement_type.reimb_type_id
//    WHERE ers_reimbursement.reimb_author = ers_users.ers_user_id;
