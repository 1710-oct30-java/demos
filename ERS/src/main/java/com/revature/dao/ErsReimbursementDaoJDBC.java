package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.ErsReimbursement;
import com.revature.util.ConnectionUtil;

public class ErsReimbursementDaoJDBC implements ErsReimbursementDao {

	private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	private ErsReimbursement extractFlashCard(ResultSet rs) throws SQLException {
		ErsUserDaoJDBC erd = new ErsUserDaoJDBC();
		ErsReimbursement fc = new ErsReimbursement();
		fc.setReimbID(rs.getInt("REIMB_ID"));
		fc.setAmount(rs.getDouble("REIMB_AMOUNT"));
		fc.setSubmitted(rs.getTimestamp("REIMB_SUBMITTED"));
		fc.setResolved(rs.getTimestamp("REIMB_RESOLVED"));
		fc.setDescription(rs.getString("REIMB_DESCRIPTION"));
		fc.setReceipt(rs.getBlob("REIMB_RECEIPT"));
		fc.setAuthor(erd.findByUserId(rs.getInt("REIMB_AUTHOR")));
		fc.setResolver(erd.findByUserId(rs.getInt("REIMB_RESOLVER")));
		fc.setStatus(rs.getString("REIMB_STATUS"));
		fc.setType(rs.getString("REIMB_TYPE"));
		return fc;
	}

	public List<ErsReimbursement> findByUserId(int userId) {
		List<ErsReimbursement> reimbursements = new ArrayList<ErsReimbursement>();
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM (ERS_REIMBURSEMENT natural join ERS_REIMBURSEMENT_STATUS natural join ERS_REIMBURSEMENT_TYPE) WHERE REIMB_AUTHOR =? ORDER BY REIMB_ID");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ErsReimbursement fc = extractFlashCard(rs);
				reimbursements.add(fc);
			}

			return reimbursements;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<ErsReimbursement> findAll() {
		List<ErsReimbursement> reimbursements = new ArrayList<ErsReimbursement>();
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM (ERS_REIMBURSEMENT natural join ERS_REIMBURSEMENT_STATUS natural join ERS_REIMBURSEMENT_TYPE)");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ErsReimbursement fc = extractFlashCard(rs);
				reimbursements.add(fc);
			}

			return reimbursements;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<ErsReimbursement> filter(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	public void newReimbursement(ErsReimbursement reim) throws SQLException {
		Connection conn = cu.getConnection();
		PreparedStatement ps = conn.prepareStatement(
				"INSERT INTO ERS_REIMBURSEMENT (REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_DESCRIPTION, REIMB_RECEIPT, REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID) VALUES (?, CURRENT_TIMESTAMP, ?, ?, ?, 1, ?)");
		ps.setDouble(1, reim.getAmount());
		ps.setString(2, reim.getDescription());

		ps.setBlob(3, reim.getReceipt());

		ps.setInt(4, reim.getAuthor().getUserID());
		ps.setString(5, reim.getType());

		ps.executeUpdate();
	}

	public void approve(ErsReimbursement reim) throws SQLException {
		Connection conn = cu.getConnection();
		PreparedStatement ps = conn.prepareStatement(
				"UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVED=CURRENT_TIMESTAMP, REIMB_RESOLVER=?, REIMB_STATUS_ID=2 WHERE REIMB_ID = ?");
		ps.setInt(1, reim.getResolver().getUserID());
		ps.setInt(2, reim.getReimbID());

		ps.executeUpdate();

	}

	public void deny(ErsReimbursement reim) throws SQLException {
		Connection conn = cu.getConnection();
		PreparedStatement ps = conn.prepareStatement(
				"UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVED=CURRENT_TIMESTAMP, REIMB_RESOLVER=?, REIMB_STATUS_ID=3 WHERE REIMB_ID = ?");
		ps.setInt(1, reim.getResolver().getUserID());
		ps.setInt(2, reim.getReimbID());
		
		ps.executeUpdate();

	}

	@Override
	public int getTypeId(String type) {
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn
					.prepareStatement("SELECT REIMB_STATUS_ID FROM ERS_REIMBURSEMENT_STATUS WHERE REIMB_STATUS = ?");
			ps.setString(1, type);
			System.out.println(type);
			ResultSet rs = ps.executeQuery();

			rs.next();
			return rs.getInt("REIMB_STATUS_ID");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int getStatusId(String status) {
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn
					.prepareStatement("SELECT REIMB_TYPE_ID FROM ERS_REIMBURSEMENT_TYPE WHERE REIMB_TYPE = ?");
			ps.setString(1, status);
			ResultSet rs = ps.executeQuery();

			rs.next();
			return rs.getInt("REIMB_TYPE_ID");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<ErsReimbursement> findByNotUserId(int userId) {
		List<ErsReimbursement> reimbursements = new ArrayList<ErsReimbursement>();
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM (ERS_REIMBURSEMENT natural join ERS_REIMBURSEMENT_STATUS natural join ERS_REIMBURSEMENT_TYPE) WHERE REIMB_AUTHOR !=? ORDER BY REIMB_ID");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ErsReimbursement fc = extractFlashCard(rs);
				reimbursements.add(fc);
			}

			return reimbursements;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
