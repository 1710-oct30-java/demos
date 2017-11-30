package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Reimbursement;
import com.revature.beans.ReimbursementStatus;
import com.revature.beans.ReimbursementType;
import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class ReimbursementDAOJdbc implements ReimbursementDAO {

	private Logger log = Logger.getRootLogger();
	private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	public void addReimbursement(Reimbursement r) {
		log.debug("attempting to save a new reimbursement");

		// read the body of the request
		Reimbursement reimb = new Reimbursement();
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//update reimbursement
	public void updateReimbursement(int reimbId, int status, int resolverId) {
		log.debug(resolverId);
		log.debug("Updating reimbursement");
		try(Connection con = cu.getConnection()){
			PreparedStatement ps = con.prepareStatement("UPDATE ers_reimbursement SET reimb_status_id=?, reimb_resolver=? WHERE reimb_id=?");
			
			ps.setInt(1, status);
			ps.setInt(2, resolverId);
			ps.setInt(3, resolverId);
			ps.executeQuery();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Reimbursement> viewAllReimbursements() {
		log.debug("Attempting to retrieve all of the reimbursements");
		List<Reimbursement> allReimbursements = new ArrayList<>();
		try (Connection conn = cu.getConnection()) {
			// PreparedStatement ps = conn.prepareStatement("SELECT reimb_id, reimb_amount,
			// reimb_submitted, reimb_author, reimb_status_id,"
			// + "reimb_type_id FROM ers_reimbursement");
			PreparedStatement ps = conn.prepareStatement("SELECT reimb_id, reimb_amount, reimb_submitted, "
					+ "reimb_resolved,reimb_resolver, reimb_description, reimb_status_id, reimb_type_id, "
					+ "user_first_name, user_last_name FROM ers_reimbursement INNER JOIN ers_users ON "
					+ "ers_reimbursement.reimb_author = ers_users.ers_users_id");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reimbursement r = financeExtractReimbursement(rs);
				allReimbursements.add(r);
			}
			return allReimbursements;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private Reimbursement extractReimbursement(ResultSet rs) throws SQLException {
		Reimbursement r = new Reimbursement();
		r.setReimbId(rs.getInt("reimb_id"));
		r.setReimbAmount(rs.getInt("reimb_amount"));
		r.setReimbSubmitted(rs.getString("reimb_submitted"));
		r.setReimbStatusId(new ReimbursementStatus(rs.getInt("reimb_status_id")));
		r.setReimbTypeId(new ReimbursementType(rs.getInt("reimb_type_id")));
		r.setReimbDescription("reimb_description");
		return r;
	}

	private Reimbursement financeExtractReimbursement(ResultSet rs) throws SQLException {

		Reimbursement r = new Reimbursement();
		User uA = new User();
		uA.setFirstName(rs.getString("user_first_name"));
		uA.setLastName(rs.getString("user_last_name"));
		User uR = new User();
		uR.setUsersId(rs.getInt("reimb_resolver"));
		r.setReimbId(rs.getInt("reimb_id"));
		r.setReimbAmount(rs.getInt("reimb_amount"));
		r.setReimbSubmitted(rs.getString("reimb_submitted"));
		r.setReimbResolved(rs.getString("reimb_resolved"));
		r.setReimbAuthor(uA);
		r.setReimbResolver(uR);
		r.setReimbStatusId(new ReimbursementStatus(rs.getInt("reimb_status_id")));
		r.setReimbTypeId(new ReimbursementType(rs.getInt("reimb_type_id")));
		r.setReimbDescription(rs.getString("reimb_description")); //
		return r;
	}

	/*
	 * Method to retrive all reimbursement by user id (non-Javadoc)
	 * 
	 * @see com.revature.dao.ReimbursementDAO#reimbursementsByUserId(int)
	 */
	@Override
	public List<Reimbursement> reimbursementsByUserId(int id) {
		log.debug("Attempting to retrieve the reimbursements from the user with user id");
		List<Reimbursement> allReimbursements = new ArrayList<>();
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn
					.prepareStatement("SELECT reimb_id, reimb_amount, reimb_submitted, reimb_status_id,"
							+ "reimb_type_id FROM ers_reimbursement WHERE reimb_author=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reimbursement r = extractReimbursement(rs);
				allReimbursements.add(r);
			}
			log.debug("reimbursements of user id: " + id + allReimbursements);
			return allReimbursements;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// get the reimbursements that the manager can resolve which are not his
	@Override
	public List<Reimbursement> approveOrDeny(int id) {
		log.debug("Attempting to retrieve all of the reimbursements that the manager can update"
				+ "and are do not belong to him/her");
		List<Reimbursement> allReimbursements = new ArrayList<>();
		try (Connection conn = cu.getConnection()) {
			// PreparedStatement ps = conn.prepareStatement("SELECT reimb_id, reimb_amount,
			// reimb_submitted, reimb_author, reimb_status_id,"
			// + "reimb_type_id FROM ers_reimbursement");
			PreparedStatement ps = conn.prepareStatement("SELECT reimb_id, reimb_amount, reimb_submitted, "
					+ "reimb_resolved,reimb_resolver, reimb_description, reimb_status_id, reimb_type_id, "
					+ "user_first_name, user_last_name FROM ers_reimbursement INNER JOIN ers_users ON "
					+ "ers_reimbursement.reimb_author = ers_users.ers_users_id WHERE ers_reimbursement.reimb_author !=?");
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reimbursement r = financeExtractReimbursement(rs);
				allReimbursements.add(r);
			}
				
			log.debug(allReimbursements);
			return allReimbursements;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
