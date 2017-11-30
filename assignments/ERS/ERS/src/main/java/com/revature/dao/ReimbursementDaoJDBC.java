package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.revature.beans.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoJDBC implements ReimbursementDao {

	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public List<Reimbursement> getUserReimbursements(int userId) {

		return null;
	}

	@Override
	public List<Reimbursement> getAllReimbursements() {
		List<Reimbursement> temp = new ArrayList<>();
		try (Connection conn = conUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM reimbursement");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbursementId(rs.getInt("reimb_id"));
				r.setReimbursementAmount(rs.getDouble("reimb_amount"));
				r.setSubmittedDate(rs.getDate("reimb_submitted"));
				r.setResolvedDate(rs.getDate("reimb_resolved"));
				r.setDescription(rs.getString("reimb_description"));
				r.setAuthorId(rs.getInt("reimb_author"));
				r.setResolverId(rs.getInt("reimb_resolver"));
				r.setStatusId(rs.getInt("reimb_status_id"));
				r.setTypeId(rs.getInt("reimb_type_id"));
				temp.add(r);
			}
			// else return null;

			return temp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void addReimbursement(Reimbursement reimb) {
		Random ran =  new Random();
		int id = ran.nextInt(1000000);
		
		try (Connection conn = conUtil.getConnection()) {
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO reimbursement (reimb_id, reimb_amount, reimb_description, reimb_author, reimb_status_id, reimb_type_id) VALUES (?, ?, ?, ?, 1, ?)");
			ps.setInt(1, id);
			ps.setDouble(2, reimb.getReimbursementAmount());
			ps.setString(3, reimb.getDescription());
			ps.setInt(4, reimb.getAuthorId());
			ps.setInt(5,  reimb.getTypeId());

			ps.executeQuery();
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	public void updReimbursement(Reimbursement reimb) {
		
		try (Connection conn = conUtil.getConnection()) {
			PreparedStatement ps = conn
					.prepareStatement("UPDATE reimbursement SET reimb_status_id = ? WHERE ? = reimb_id");
			ps.setInt(1, reimb.getStatusId());
			ps.setInt(2, reimb.getReimbursementId());

			ps.executeQuery();
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

}
