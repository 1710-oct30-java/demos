package com.ers.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ers.beans.Reimbursement;
import com.ers.beans.User;
import com.ers.util.ConnectionUtil;

public class ReimbursementDAOJdbc implements ReimbursementDAO {

	private Logger log = Logger.getLogger(ReimbursementDAOJdbc.class);
	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
	
	public List<Reimbursement> getReimbursementsByUser(User user) {
		
		List<Reimbursement> list = new ArrayList<Reimbursement>();
		
		int user_id = user.getUser_id();
		log.debug("Retrieving requests for '" + user.getUsername() + "'...");
		
		try (Connection conn = conUtil.getConnection()) {
			
			Reimbursement reimb;

			String query = "SELECT * FROM REIMBURSEMENT WHERE r_author = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, user_id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				reimb = new Reimbursement();
				reimb.setR_id(rs.getInt("r_id"));
				reimb.setR_amount(rs.getInt("r_amount"));
				reimb.setR_submitted(rs.getString("r_submitted"));
				reimb.setR_resolved(rs.getString("r_resolved"));
				reimb.setR_description(rs.getString("r_description"));
				// reimb.setR_receipt(rs.getString("r_receipt"));
				reimb.setR_author(rs.getInt("r_author"));
				reimb.setR_resolver(rs.getInt("r_resolver"));
				reimb.setR_status_id(rs.getInt("r_status_id"));
				reimb.setR_type_id(rs.getInt("r_type_id"));
				list.add(reimb);
			}

			// Check if any pending requests are found
			if (!list.isEmpty()) {
				log.debug("Requests loaded!\n");
			}

			// Else no pending request found
			else {
				log.debug("No requests found!\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			log.debug("Failed to retrieve requests!\n");
		}
		
		return list;
	}
	
	
	
	public Reimbursement getReimbursementById(int r_id) {
		
		Reimbursement reimb = new Reimbursement(0, 0, "", "", "", "", 0, 0, 0, 0);
		log.debug("Retrieving reimbursement #" + r_id + "...");
		
		try (Connection conn = conUtil.getConnection()) {
			
			String query = "SELECT * FROM REIMBURSEMENT WHERE r_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, r_id);

			ResultSet rs = ps.executeQuery();

			int row = 0;
			while (rs.next()) {
				reimb = new Reimbursement();
				reimb.setR_id(rs.getInt("r_id"));
				reimb.setR_amount(rs.getInt("r_amount"));
				reimb.setR_submitted(rs.getString("r_submitted"));
				reimb.setR_resolved(rs.getString("r_resolved"));
				reimb.setR_description(rs.getString("r_description"));
				// reimb.setR_receipt(rs.getString("r_receipt"));
				reimb.setR_author(rs.getInt("r_author"));
				reimb.setR_resolver(rs.getInt("r_resolver"));
				reimb.setR_status_id(rs.getInt("r_status_id"));
				reimb.setR_type_id(rs.getInt("r_type_id"));
				row++;
			}
			
			if(row > 0) {
				log.debug("Reimbursement loaded!\n");
			}
			
			else {
				log.debug("Reimbursement #" + r_id + " not found!\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			log.debug("Failed to retrieve reimbursement!\n");
		}
		
		return reimb;
	}
	
	
	
	public List<Reimbursement> getReimbursementsByStatusID(int r_status_id) {

		List<Reimbursement> list = new ArrayList<Reimbursement>();

		// Check that input is a valid status code (1-3)
		if (r_status_id > 0 && r_status_id < 4) {

			try (Connection conn = conUtil.getConnection()) {

				// Set status name based on database structure
				// This way avoids another connection to the database
				String status = "";
				switch (r_status_id) {

				case 1:
					status = "Pending";
					break;

				case 2:
					status = "Approved";
					break;

				case 3:
					status = "Denied";
					break;
				}

				// Get reimbursement requests
				log.debug("Retrieving " + status.toLowerCase() + " requests...");
				Reimbursement reimb;

				String query = "SELECT * FROM REIMBURSEMENT WHERE r_status_id = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, r_status_id);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					reimb = new Reimbursement();
					reimb.setR_id(rs.getInt("r_id"));
					reimb.setR_amount(rs.getInt("r_amount"));
					reimb.setR_submitted(rs.getString("r_submitted"));
					reimb.setR_resolved(rs.getString("r_resolved"));
					reimb.setR_description(rs.getString("r_description"));
					// reimb.setR_receipt(rs.getString("r_receipt"));
					reimb.setR_author(rs.getInt("r_author"));
					reimb.setR_resolver(rs.getInt("r_resolver"));
					reimb.setR_status_id(rs.getInt("r_status_id"));
					reimb.setR_type_id(rs.getInt("r_type_id"));
					list.add(reimb);
				}

				// Check if any pending requests are found
				if (!list.isEmpty()) {
					log.debug(status + " requests loaded!\n");
				}

				// Else no pending request found
				else {
					log.debug("No requests found!\n");
				}

			} catch (SQLException e) {
				e.printStackTrace();
				log.debug("Failed to retrieve requests!");
			}
		}

		// Else input is not a valid status code
		else {
			log.debug("'" + r_status_id + "'" + " is not a valid status code!");
			log.debug("Reimbursement Status Code: 1) Pending | 2) Approved | 3) Denied\n");
		}

		return list;
	}
	
	
	
	public void addReimbursement(User user, Reimbursement reimb) {
		
		log.debug("Connecting to database to add reimbursement...");

		try (Connection conn = conUtil.getConnection()) {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String query = "INSERT INTO REIMBURSEMENT(r_amount, r_submitted, r_description, r_author, r_status_id, r_type_id)" + 
							"VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, reimb.getR_amount());
			ps.setTimestamp(2, timestamp);
			ps.setString(3, reimb.getR_description());
			ps.setInt(4, user.getUser_id());
			ps.setInt(5, 1);
			ps.setInt(6, reimb.getR_type_id());

			log.debug("Adding reimbursement to database...");
			ps.addBatch();
			ps.executeBatch();

			log.debug("Reimbursement added to database!\n");

		} catch (SQLException e) {
			e.printStackTrace();
			log.debug("Failed to add reimbursement!\n");
		}
	}
	
	
	
	public void updateReimbursement(User user, Reimbursement reimb, int r_status_id) {
		
		log.debug("Connecting to database to update reimbursement...");

		try (Connection conn = conUtil.getConnection()) {

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			
			CallableStatement cs = conn.prepareCall("CALL updateReimbursement(?, ?, ?, ?)");
			cs.setInt(1, reimb.getR_id());
			cs.setTimestamp(2, timestamp);
			cs.setInt(3, user.getUser_id());
			cs.setInt(4, r_status_id);

			log.debug("Updating reimbursement...");
			cs.execute();

			log.debug("Reimbursement '" + reimb.getR_id() + "' updated!\n");

		} catch (SQLException e) {
			e.printStackTrace();
			log.debug("Failed to update reimbursement!\n");
		}
	}



	@Override
	public List<Reimbursement> getReimbursementsAllReimbursements() {
		
		List<Reimbursement> list = new ArrayList<Reimbursement>();
		
		log.debug("Retrieving requests for all reimbursements...");
		
		try (Connection conn = conUtil.getConnection()) {
			
			Reimbursement reimb;

			String query = "SELECT * FROM REIMBURSEMENT";
			PreparedStatement ps = conn.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				reimb = new Reimbursement();
				reimb.setR_id(rs.getInt("r_id"));
				reimb.setR_amount(rs.getInt("r_amount"));
				reimb.setR_submitted(rs.getString("r_submitted"));
				reimb.setR_resolved(rs.getString("r_resolved"));
				reimb.setR_description(rs.getString("r_description"));
				// reimb.setR_receipt(rs.getString("r_receipt"));
				reimb.setR_author(rs.getInt("r_author"));
				reimb.setR_resolver(rs.getInt("r_resolver"));
				reimb.setR_status_id(rs.getInt("r_status_id"));
				reimb.setR_type_id(rs.getInt("r_type_id"));
				list.add(reimb);
			}

			// Check if any pending requests are found
			if (!list.isEmpty()) {
				log.debug("Requests loaded!\n");
			}

			// Else no pending request found
			else {
				log.debug("No requests found!\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			log.debug("Failed to retrieve requests!\n");
		}
		
		return list;
	}



	@Override
	public List<Reimbursement> getReimbursementsByUserID(int r_author) {
		List<Reimbursement> list = new ArrayList<Reimbursement>();

		try (Connection conn = conUtil.getConnection()) {

			// Get reimbursement requests
			log.debug("Retrieving requests for user #" + r_author);
			Reimbursement reimb;

			String query = "SELECT * FROM REIMBURSEMENT WHERE r_author = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, r_author);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				reimb = new Reimbursement();
				reimb.setR_id(rs.getInt("r_id"));
				reimb.setR_amount(rs.getInt("r_amount"));
				reimb.setR_submitted(rs.getString("r_submitted"));
				reimb.setR_resolved(rs.getString("r_resolved"));
				reimb.setR_description(rs.getString("r_description"));
				// reimb.setR_receipt(rs.getString("r_receipt"));
				reimb.setR_author(rs.getInt("r_author"));
				reimb.setR_resolver(rs.getInt("r_resolver"));
				reimb.setR_status_id(rs.getInt("r_status_id"));
				reimb.setR_type_id(rs.getInt("r_type_id"));
				list.add(reimb);
			}

			// Check if any pending requests are found
			if (!list.isEmpty()) {
				log.debug("Requests loaded!\n");
			}

			// Else no pending request found
			else {
				log.debug("No requests found!\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			log.debug("Failed to retrieve requests!");
		}
		return list;
	}
	
	
	public int getIdOfLastReimbusement() {
		
		log.debug("Retrieving ID last reimbursement added...");
		int id = 0;
		
		try (Connection conn = conUtil.getConnection()) {
			
			String query = "SELECT MAX(r_id) FROM REIMBURSEMENT";
			PreparedStatement ps = conn.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			int row = 0;
			while (rs.next()) {
				id = rs.getInt(1);
				row++;
			}
			
			if(row > 0) {
				log.debug("ID #'" + id + "' found!\n");
			}
			
			else {
				log.debug("ID not found!\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			log.debug("Failed to retrieve ID!\n");
		}
		
		return id;
	}
	
}
