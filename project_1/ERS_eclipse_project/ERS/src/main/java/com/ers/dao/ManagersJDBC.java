package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ers.beans.Reimbursement;
import com.ers.util.ConnectionUtil;

/*
 * Reimbursement Status
 * 1) Pending
 * 2) Approved
 * 3) Denied
 */

public class ManagersJDBC implements ManagersDAO {

	private Logger log = Logger.getLogger(ManagersJDBC.class);
	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	private List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

	public void displayList() {
		for(Reimbursement reimb:reimbursements)
		{
			System.out.println(reimb);
		}
	}
	
	// View all pending requests
	public void viewPendingRequests() {

		log.info("Retrieving pending requests...");

		try (Connection conn = conUtil.getConnection()) {
			Reimbursement reimb;
			
			String query = "SELECT * FROM REIMBURSEMENT WHERE r_status_id = 1";
			PreparedStatement ps = conn.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				reimb = new Reimbursement();
				reimb.setR_id(rs.getInt("r_id"));
				reimb.setR_amount(rs.getInt("r_amount"));
				reimb.setR_submitted(rs.getString("r_submitted"));
				reimb.setR_resolved(rs.getString("r_resolved"));
				reimb.setR_description(rs.getString("r_description"));
				//reimb.setR_receipt(rs.getString("r_receipt"));
				reimb.setR_author(rs.getInt("r_author"));
				reimb.setR_resolver(rs.getInt("r_resolver"));
				reimb.setR_status_id(rs.getInt("r_status_id"));
				reimb.setR_type_id(rs.getInt("r_type_id"));
				reimbursements.add(reimb);
			}
			
			// Check if any pending requests are found
			if (!reimbursements.isEmpty()) {
				log.info("Pending requests loaded!");
				displayList();
			}

			// Else no pending request found
			else {
				log.info("No pending requests found!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			log.info("Failed to retrieve requests!");
		}

	}

	// View all approved requests
	public void viewApprovedRequests() {
		log.info("Retrieving approved requests...");

		try (Connection conn = conUtil.getConnection()) {
			Reimbursement reimb;
			
			String query = "SELECT * FROM REIMBURSEMENT WHERE r_status_id = 2";
			PreparedStatement ps = conn.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				reimb = new Reimbursement();
				reimb.setR_id(rs.getInt("r_id"));
				reimb.setR_amount(rs.getInt("r_amount"));
				reimb.setR_submitted(rs.getString("r_submitted"));
				reimb.setR_resolved(rs.getString("r_resolved"));
				reimb.setR_description(rs.getString("r_description"));
				//reimb.setR_receipt(rs.getString("r_receipt"));
				reimb.setR_author(rs.getInt("r_author"));
				reimb.setR_resolver(rs.getInt("r_resolver"));
				reimb.setR_status_id(rs.getInt("r_status_id"));
				reimb.setR_type_id(rs.getInt("r_type_id"));
				reimbursements.add(reimb);
			}
			
			// Check if any approved requests are found
			if (!reimbursements.isEmpty()) {
				log.info("Pending requests loaded!");
				displayList();
			}

			// Else no approved request found
			else {
				log.info("No pending requests found!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			log.info("Failed to retrieve requests!");
		}
	}

	// View all denied request
	public void viewDeniedRequests() {

	}

}
