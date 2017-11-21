package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoJDBC implements ReimbursementDAO{

	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
	private Reimbursement getReimbursementFromResultSet(ResultSet rs) throws SQLException {
		
		int id = rs.getInt("reimb_id");
		int amount = rs.getInt("reimb_amount");
		Timestamp submitted = rs.getTimestamp("reimb_submitted");
		Timestamp resolved = rs.getTimestamp("reimb_resolved");
		String description = rs.getString("reimb_description");
		int author = rs.getInt("reimb_author");
		int resolver = rs.getInt("reimb_resolver");
		int statusId = rs.getInt("reimb_status_id");
		int typeId = rs.getInt("reimb_type_id");
		
		return new Reimbursement(id, amount, submitted, resolved, description, author, resolver, statusId, typeId);
	}
	
	@Override
	public Reimbursement getReimbursementByID(int id) {
		
		try(Connection conn = conUtil.getConnection()){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers_reimbursement WHERE reimb_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return getReimbursementFromResultSet(rs);
			}	
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimbursement> retrieveAllReimbursements() {
		
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		try(Connection conn = conUtil.getConnection()){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers_reimbursement");
			ResultSet rs = ps.executeQuery();
			
			System.out.println("connected to database, retrieving data...");
			
			while(rs.next()) {
				int id = rs.getInt("reimb_id");
				int amount = rs.getInt("reimb_amount");
				Timestamp submitted = rs.getTimestamp("reimb_submitted");
				Timestamp resolved = rs.getTimestamp("reimb_resolved");
				String description = rs.getString("reimb_description");
				int authorId = rs.getInt("reimb_author");
				int resolverId = rs.getInt("reimb_resolver");
				int status = rs.getInt("reimb_status_id");
				int type = rs.getInt("reimb_type_id");
				
				reimbursements.add(new Reimbursement(id, amount, submitted, resolved, description, authorId, resolverId, status, type));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public int addReimbursement(Reimbursement rb) {
		
		try(Connection conn = conUtil.getConnection()){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description,reimb_author,reimb_resolver,reimb_status_id,reimb_type_id) VALUES (?,?,?,?,?,?,?,?)");
			ps.setInt(1, rb.getAmount());
			ps.setTimestamp(2, rb.getSubmitted());
			ps.setTimestamp(3, rb.getResolved());
			ps.setString(4, rb.getDescription());
			ps.setInt(5, rb.getAuthorId());
			ps.setInt(6, rb.getResolverId());
			ps.setInt(7, rb.getStatus());
			ps.setInt(8, rb.getType());
			
			ps.executeQuery();
			
			ResultSet keys = ps.getGeneratedKeys();
			if(keys.next()) {
				System.out.println("successfully added the reimbursement");
				return keys.getInt(1);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void approveDeny(String choice) {
		
		try(Connection conn = conUtil.getConnection()) {
			
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
