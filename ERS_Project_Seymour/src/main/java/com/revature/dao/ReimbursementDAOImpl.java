package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Reimbursement;
import com.revature.utilities.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {
	
	Connection conn = null;
	PreparedStatement stmt = null;
	
	public List<Reimbursement> getAllReimbs() {
		List<Reimbursement> reimbList = new ArrayList<Reimbursement>();
		try {
			
			conn = ConnectionUtil.getConnection();
			String sql = "Select * from ers_reimbursement";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbId(rs.getInt("reimb_id"));
				r.setAmount(rs.getDouble("reimb_amount"));
				r.setTimeSubmitted(rs.getTimestamp("reimb_submitted"));
				r.setTimeResolved(rs.getTimestamp("reimb_resolved"));
				r.setDescription(rs.getString("reimb_description"));
				r.setReceipt(rs.getBlob("reimb_receipt"));
				r.setAuthor(rs.getInt("reimb_author"));
				r.setResolver(rs.getInt("reimb_resolver"));
				r.setStatusId(rs.getInt("reimb_status_id"));
				r.setTypeId(rs.getInt("reimb_type_id"));
				reimbList.add(r);
			}
			rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}		
		return reimbList;
	}

	@Override
	public List<Reimbursement> getReimbsById(int uid) {
		List<Reimbursement> reimbList = new ArrayList<Reimbursement>();
		try {
			System.out.println("Userid requested is "+uid);
			conn = ConnectionUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from ERS_REIMBURSEMENT where reimb_author=?");
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimbId(rs.getInt("reimb_id"));
				r.setAmount(rs.getDouble("reimb_amount"));
				r.setTimeSubmitted(rs.getTimestamp("reimb_submitted"));
				r.setTimeResolved(rs.getTimestamp("reimb_resolved"));
				r.setDescription(rs.getString("reimb_description"));
				r.setReceipt(rs.getBlob("reimb_receipt"));
				r.setAuthor(rs.getInt("reimb_author"));
				r.setResolver(rs.getInt("reimb_resolver"));
				r.setStatusId(rs.getInt("reimb_status_id"));
				r.setTypeId(rs.getInt("reimb_type_id"));
				reimbList.add(r);
			}
			rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}		
		return reimbList;
	}

	@Override
	public Boolean addReimbursement(Reimbursement r) {
		try {
			conn = ConnectionUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO ERS_REIMBURSEMENT (reimb_amount, "
					+ "reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, "
					+ "reimb_resolver, reimb_status_id, reimb_type_id) "
					+ "VALUES (?,?,?,?,?,?,?,?,?)");
			ps.setDouble(1, r.getAmount());
//			ps.setTimestamp(2, r.getTimeSubmitted());
//			ps.setTimestamp(3, r.getTimeResolved());
			ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			ps.setTimestamp(3, null);
			ps.setString(4, r.getDescription());
			ps.setBlob(5, r.getReceipt());
			ps.setInt(6, r.getAuthor());
			ps.setInt(7, r.getResolver());
			ps.setInt(8, r.getStatusId());
			ps.setInt(9, r.getTypeId());
			ResultSet rs = ps.executeQuery();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean approveRequests(int uid, List<Integer> reimbIdsToBeApproved) {
		try {
			conn = ConnectionUtil.getConnection();
			
			for (int i=0; i<reimbIdsToBeApproved.size(); i++) {
			PreparedStatement ps = conn.prepareStatement("UPDATE ERS_REIMBURSEMENT SET reimb_status_id=2, reimb_resolver=?, reimb_resolved=? WHERE reimb_id=?");
			System.out.println("reimb id to approve " +reimbIdsToBeApproved.get(i));
			ps.setInt(1, uid);
			ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			ps.setInt(3, reimbIdsToBeApproved.get(i));
			ps.executeQuery();
			}
			return true;
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean denyRequests(int uid, List<Integer> reimbIdsToBeDenied) {
		try {
			conn = ConnectionUtil.getConnection();
			
			for (int i=0; i<reimbIdsToBeDenied.size(); i++) {
			PreparedStatement ps = conn.prepareStatement("UPDATE ERS_REIMBURSEMENT SET reimb_status_id=3, reimb_resolver=?, reimb_resolved=? WHERE reimb_id=?");
			System.out.println("reimb id to deny " +reimbIdsToBeDenied.get(i));
			ps.setInt(1, uid);
			ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			ps.setInt(3, reimbIdsToBeDenied.get(i));
			ps.executeQuery();
			}
			return true;
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return false;
	}
}
