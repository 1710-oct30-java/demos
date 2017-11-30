package com.revature.dao;

/*
 * Class: ReimbursementDaoJDBC
 * Author: Kyle Settles
 * Description: Class implements the ReimbursementDAO and  
 */

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

	// get connection from the properties file
	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
	// method used to retrieve a reimbursement from the result set
	private Reimbursement getReimbursementFromResultSet(ResultSet rs) throws SQLException {
		
		// gets all fields from the table
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
	public List<Reimbursement> getReimbursementsByUser(int id){
		
		List<Reimbursement> userReimbursements = new ArrayList<>();
		
		try(Connection conn = conUtil.getConnection()){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers_reimbursement WHERE reimb_author = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int rId = rs.getInt("reimb_id");
				int amount = rs.getInt("reimb_amount");
				Timestamp submitted = rs.getTimestamp("reimb_submitted");
				Timestamp resolved = rs.getTimestamp("reimb_resolved");
				String description = rs.getString("reimb_description");
				int authorId = rs.getInt("reimb_author");
				int resolverId = rs.getInt("reimb_resolver");
				int status = rs.getInt("reimb_status_id");
				int type = rs.getInt("reimb_type_id");
				
				userReimbursements.add(new Reimbursement(rId, amount, submitted, resolved, description, authorId, resolverId, status, type));
			}	
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return userReimbursements;
	}
	
	// method used to retrieve a reimbursement by ID
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

	// method used to grab all of the reimbursements from the database
	@Override
	public List<Reimbursement> retrieveAllReimbursements() {
		
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		try(Connection conn = conUtil.getConnection()){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers_reimbursement");
			ResultSet rs = ps.executeQuery();
						
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

	// method used to add a reimbursement to the database
	@Override
	public int addReimbursement(Reimbursement rb) {
		
		try(Connection conn = conUtil.getConnection()){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description,reimb_author,reimb_status_id,reimb_type_id)"
					+ "VALUES (?,?,?,?,?,?,?)", new String[] {"reimb_id"});
			ps.setInt(1, rb.getAmount());
			ps.setTimestamp(2, rb.getSubmitted());
			ps.setTimestamp(3, rb.getResolved());
			ps.setString(4, rb.getDescription());
			ps.setInt(5, rb.getAuthorId());
			ps.setInt(6, rb.getStatus());
			ps.setInt(7, rb.getType());
			
			ps.executeQuery();
			
			// key used to return the new ID of the reimbursement after adding
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

	// method used to change the status of the reimbursement after approval or denial
	@Override
	public boolean approveDeny(String choice, int id, int resolverId) {
		
		try(Connection conn = conUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("UPDATE ers_reimbursement SET reimb_status_id = ?, reimb_resolved = ?, reimb_resolver = ? WHERE reimb_id = ? AND reimb_author != " + resolverId);
			ps.setInt(4, id);
			
			if(choice.equals("approve")) {
				ps.setInt(1, 2); 
				ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
				ps.setInt(3, resolverId);
			}
			else if(choice.equals("deny")) {
				ps.setInt(1, 3);
				ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
				ps.setInt(3, resolverId);
			}
			else {
				ps.setInt(1, 1);
			}
			ps.executeQuery();
			return true;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
