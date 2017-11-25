package com.revature.dao;

import java.sql.*;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoJdbc implements ReimbursementDao {

	private Logger log = Logger.getRootLogger();
	private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	public List<Reimbursement> findReimbursement(int reimbId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Reimbursement> allReimbursements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int newReimbursement(Reimbursement newReimb) {
		log.debug("Attempting to open addd new Reimbursement ticket to DB");
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO reimbursement (reimb_id,amount,submitted,description,author,status_id,type_id) VALUES (?,?,?,?,?,?,?)");
			ps.setInt(1, newReimb.getReimbId());
			ps.setFloat(2, newReimb.getAmount());
			ps.setDate(3, newReimb.getSubmitted());
			ps.setString(4, newReimb.getDescip());
			ps.setInt(5, newReimb.getAuthorId());
			ps.setInt(6, newReimb.getStatusId());
			ps.setInt(7, newReimb.getTypeId());
			ps.executeQuery();
			log.debug("Reimbursement added successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Failed to add reimbursement");

		}
		return 0;
	}

}
