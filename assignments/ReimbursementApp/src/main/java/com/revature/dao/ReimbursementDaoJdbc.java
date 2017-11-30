package com.revature.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Reimbursement;
import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoJdbc implements ReimbursementDao {

	private Logger log = Logger.getRootLogger();
	private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	private Reimbursement extractReimbursement(ResultSet rs) throws SQLException {
		Reimbursement r = new Reimbursement();
		r.setReimbId(rs.getInt("reimb_id"));
		r.setAuthorId(rs.getInt("author"));
		r.setTypeId(rs.getInt("type_id"));
		r.setAmount(rs.getFloat("amount"));
		r.setDescip(rs.getString("description"));
		r.setStatusId(rs.getInt("status_id"));
		r.setSubmitted(rs.getDate("submitted"));
		r.setResolved(rs.getString("resolved"));
		r.setResolver(rs.getInt("REIMB_RESOLVER"));

		return r;
	}

	public List<Reimbursement> findReimbursement(int userId) {
		List<Reimbursement> rl = new ArrayList<>();
		log.debug("Attempting to get Reimbursement tickets for User");
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM reimbursement WHERE author=? ORDER BY reimb_id");
			ps.setInt(1, userId);
			ps.executeQuery();
			log.debug("Reimbursement retrieved");
			ResultSet rs = ps.executeQuery();
			log.trace("Extracting Reimbursements");
			while (rs.next()) {
				rl.add(extractReimbursement(rs));
			}
			return rl;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Failed to get Reimbursements");

		}
		return rl;
	}

	public List<Reimbursement> allReimbursements() {
		List<Reimbursement> rl = new ArrayList<>();
		log.debug("Attempting to get Reimbursement tickets for User");
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM reimbursement ORDER BY reimb_id");
			ps.executeQuery();
			log.debug("Reimbursement retrieved");
			ResultSet rs = ps.executeQuery();
			log.trace("Extracting Reimbursements");
			while (rs.next()) {
				rl.add(extractReimbursement(rs));
			}
			return rl;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Failed to get Reimbursements");

		}
		return rl;
	}

	@Override
	public int newReimbursement(Reimbursement newReimb) {
		log.debug("Attempting to open add new Reimbursement ticket to DB");
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO reimbursement (amount,submitted,description,author,status_id,type_id,resolved) VALUES (?,?,?,?,?,?,?)");
			ps.setFloat(1, newReimb.getAmount());
			ps.setDate(2, newReimb.getSubmitted());
			ps.setString(3, newReimb.getDescip());
			ps.setInt(4, newReimb.getAuthorId());
			ps.setInt(5, newReimb.getStatusId());
			ps.setInt(6, newReimb.getTypeId());
			ps.setString(7, null);
			ps.executeQuery();
			log.debug("Reimbursement added successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Failed to add reimbursement");

		}
		return 0;
	}

	@Override
	public int approved(int reimbursement) {
		log.debug("Attempting to approve into DB " + reimbursement);
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn
					.prepareStatement("UPDATE reimbursement SET status_id = ?, resolved = CURRENT_TIMESTAMP, reimb_resolver = ?  WHERE reimb_id = ?");
			ps.setInt(1, 1);
			ps.setInt(2, 1);
			ps.setInt(3, reimbursement);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Failed to approve reimbursement");

		}
		return 0;
	}

	@Override
	public int denied(int reimbursement) {
		log.debug("Attempting to deny into DB " + reimbursement);
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn
					.prepareStatement("UPDATE reimbursement SET status_id = ?, resolved = CURRENT_TIMESTAMP, reimb_resolver = ?  WHERE reimb_id = ?");
			ps.setInt(1, 2);
			ps.setInt(2, 1);
			ps.setInt(3, reimbursement);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Failed to deny reimbursement");

		}
		return 0;
	}

}
