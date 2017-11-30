package com.revature.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Reimbursement;
import com.revature.beans.User;
import com.revature.connectionutil.ConnectionUtil;

public class ReimbursementDaoJdbc implements ReimbursementDao {

	private Logger log = Logger.getLogger(ReimbursementDaoJdbc.class);
	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
	
	public List<Reimbursement> getReimbursements() {
		
		List<Reimbursement> list = new ArrayList<>();
		
		try (Connection conn = conUtil.getConnection()) {
			
			Reimbursement reimb;

			String query = "SELECT * FROM ers_reimbursement";
			PreparedStatement ps = conn.prepareStatement(query);
			

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				reimb = new Reimbursement();
				reimb.setId(rs.getInt("reimb_id"));
				reimb.setAmount(rs.getInt("reimb_amount"));
				reimb.setSubmitted(rs.getTimestamp("reimb_submitted"));
				reimb.setResolved(rs.getTimestamp("reimb_resolved"));
				reimb.setDescription(rs.getString("reimb_description"));
				reimb.setAuthorId(rs.getInt("reimb_author"));
				reimb.setResolverId(rs.getInt("reimb_resolver"));
				reimb.setStatus(rs.getInt("reimb_status_id"));
				reimb.setType(rs.getInt("reimb_type_id"));
				list.add(reimb);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			log.debug("Failed to retrieve requests!\n");
		}
		return list;
	}
	
	
	
	public Reimbursement getReimbursementById(int r_id) {
		
		Reimbursement reimb = new Reimbursement();
		log.debug("Retrieving reimbursement #" + r_id + "...");
		
		try (Connection conn = conUtil.getConnection()) {
			
			String query = "SELECT * FROM REIMBURSEMENT WHERE r_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, r_id);

			ResultSet rs = ps.executeQuery();

			int row = 0;
			while (rs.next()) {
				reimb = new Reimbursement();
				reimb.setId(rs.getInt("r_id"));
				reimb.setAmount(rs.getInt("r_amount"));
				reimb.setSubmitted(rs.getTimestamp("r_submitted"));
				reimb.setResolved(rs.getTimestamp("r_resolved"));
				reimb.setDescription(rs.getString("r_description"));
				reimb.setAuthorId(rs.getInt("r_author"));
				reimb.setResolverId(rs.getInt("r_resolver"));
				reimb.setStatus(rs.getInt("r_status_id"));
				reimb.setType(rs.getInt("r_type_id"));
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

		// Validate Status Code (1-3)
		if (r_status_id > 0 && r_status_id < 4) {

			try (Connection conn = conUtil.getConnection()) {

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
					reimb.setId(rs.getInt("r_id"));
					reimb.setAmount(rs.getInt("r_amount"));
					reimb.setSubmitted(rs.getTimestamp("r_submitted"));
					reimb.setResolved(rs.getTimestamp("r_resolved"));
					reimb.setDescription(rs.getString("r_description"));
					reimb.setAuthorId(rs.getInt("r_author"));
					reimb.setResolverId(rs.getInt("r_resolver"));
					reimb.setStatus(rs.getInt("r_status_id"));
					reimb.setType(rs.getInt("r_type_id"));
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
	
	
	
	public boolean addReimbursement(Reimbursement r) {
		
		log.debug("Connecting to database to add reimbursement...");

		try (Connection conn = conUtil.getConnection()) {
			String query = "INSERT INTO ERS_REIMBURSEMENT(reimb_amount, reimb_submitted, reimb_description, reimb_resolved,"
					+ "reimb_author, reimb_status_id, reimb_type_id)" + 
							"VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, r.getAmount());
			ps.setTimestamp(2, r.getSubmitted());
			ps.setString(3, r.getDescription());
			ps.setTime(4, r.getResolved());
			ps.setInt(5, r.getAuthorId());
			ps.setInt(6,  r.getStatus());
			ps.setInt(7, r.getType());

			log.debug("Adding reimbursement to database...");
			ps.executeQuery();
			log.debug("Reimbursement was added to database!\n");
            return true;
            
            		
            
		} catch (SQLException e) {
			e.printStackTrace();
			log.debug("Failed to add the reimbursement!\n");
		}
		return false; 
	}
	
	public boolean approveReimbursement(Reimbursement r, int resolver) {
		
		log.debug("Now connecting to database for the update of reimbursement...");

		try (Connection conn = conUtil.getConnection()) {
			
			String query = "UPDATE ERS_REIMBURSEMENT SET reimb_resolved=?, reimb_status_id=?, reimb_resolver=? WHERE reimb_id = ?";
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(2, 2);
			ps.setTimestamp(1, timestamp);
			ps.setInt(3, resolver);
			ps.setInt(4, r.getId());
			ps.executeQuery();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			log.debug("Failed to update reimbursement!\n");
		}
		return false;
	}



	public List<Reimbursement> getReimbursementsByUserId(int id) {

		List<Reimbursement> list = new ArrayList<>();
		
		
		try (Connection conn = conUtil.getConnection()) {
			log.debug("connected to db");
			String query = "SELECT * FROM ers_reimbursement WHERE reimb_author = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reimbursement reimb = new Reimbursement();
				reimb.setId(rs.getInt("reimb_id"));
				reimb.setAmount(rs.getInt("reimb_amount"));
				reimb.setSubmitted(rs.getTimestamp("reimb_submitted"));
				reimb.setResolved(rs.getTimestamp("reimb_resolved"));
				reimb.setDescription(rs.getString("reimb_description"));
				reimb.setAuthorId(rs.getInt("reimb_author"));
				reimb.setResolverId(rs.getInt("reimb_resolver"));
				reimb.setStatus(rs.getInt("reimb_status_id"));
				reimb.setType(rs.getInt("reimb_type_id"));
				list.add(reimb);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			log.debug("Failed to retrieve requests!\n");
		}
		log.debug("returning user reimbs");
		return list;
	}
}
