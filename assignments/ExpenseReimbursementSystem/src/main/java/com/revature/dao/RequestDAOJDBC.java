package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Request;
import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class RequestDAOJDBC implements RequestDAO {

	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	private Logger log = Logger.getRootLogger();

	@Override
	public List<Request> findAll() {
		List<Request> requests = new ArrayList<>();
		log.debug("attempting to retreive all reimbursement requests");

		try (Connection conn = conUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("REIMB_ID");
				double amount = rs.getDouble("REIMB_AMOUNT");
				Timestamp submit = rs.getTimestamp("REIMB_SUBMITTED");
				Timestamp resolved = rs.getTimestamp("REIMB_RESOLVED");
				String description = rs.getString("REIMB_DESCRIPTION");
				int author = rs.getInt("REIMB_AUTHOR");
				int resolver = rs.getInt("REIMB_RESOLVER");
				int statusid = rs.getInt("REIMB_STATUS_ID");
				int typeid = rs.getInt("REIMB_TYPE_ID");
				requests.add(
						new Request(id, amount, submit, resolved, description, author, resolver, statusid, typeid));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn("failed to retreive all reimbursement requests");
		}

		return requests;
	}

	@Override
	public List<Request> findPending() {
		List<Request> requests = new ArrayList<>();
		log.debug("attempting to retreive all pending reimbursement requests");

		try (Connection conn = conUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_STATUS_ID = ?");
			ps.setInt(1, 1);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("REIMB_ID");
				double amount = rs.getDouble("REIMB_AMOUNT");
				Timestamp submit = rs.getTimestamp("REIMB_SUBMITTED");
				Timestamp resolved = rs.getTimestamp("REIMB_RESOLVED");
				String description = rs.getString("REIMB_DESCRIPTION");
				int author = rs.getInt("REIMB_AUTHOR");
				int resolver = rs.getInt("REIMB_RESOLVER");
				int statusid = rs.getInt("REIMB_STATUS_ID");
				int typeid = rs.getInt("REIMB_TYPE_ID");
				requests.add(
						new Request(id, amount, submit, resolved, description, author, resolver, statusid, typeid));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn("failed to retreive all reimbursement requests");
		}

		return requests;
	}

	@Override
	public List<Request> findDenied() {
		List<Request> requests = new ArrayList<>();
		log.debug("attempting to retreive all pending reimbursement requests");

		try (Connection conn = conUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_STATUS_ID = ?");
			ps.setInt(1, 3);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("REIMB_ID");
				double amount = rs.getDouble("REIMB_AMOUNT");
				Timestamp submit = rs.getTimestamp("REIMB_SUBMITTED");
				Timestamp resolved = rs.getTimestamp("REIMB_RESOLVED");
				String description = rs.getString("REIMB_DESCRIPTION");
				int author = rs.getInt("REIMB_AUTHOR");
				int resolver = rs.getInt("REIMB_RESOLVER");
				int statusid = rs.getInt("REIMB_STATUS_ID");
				int typeid = rs.getInt("REIMB_TYPE_ID");
				requests.add(
						new Request(id, amount, submit, resolved, description, author, resolver, statusid, typeid));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn("failed to retreive all reimbursement requests");
		}

		return requests;
	}

	@Override
	public List<Request> findApproved() {
		List<Request> requests = new ArrayList<>();
		log.debug("attempting to retreive all pending reimbursement requests");

		try (Connection conn = conUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_STATUS_ID = ?");
			ps.setInt(1, 2);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("REIMB_ID");
				double amount = rs.getDouble("REIMB_AMOUNT");
				Timestamp submit = rs.getTimestamp("REIMB_SUBMITTED");
				Timestamp resolved = rs.getTimestamp("REIMB_RESOLVED");
				String description = rs.getString("REIMB_DESCRIPTION");
				int author = rs.getInt("REIMB_AUTHOR");
				int resolver = rs.getInt("REIMB_RESOLVER");
				int statusid = rs.getInt("REIMB_STATUS_ID");
				int typeid = rs.getInt("REIMB_TYPE_ID");
				requests.add(
						new Request(id, amount, submit, resolved, description, author, resolver, statusid, typeid));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn("failed to retreive all reimbursement requests");
		}

		return requests;
	}
public static void main(String[] args) {
	RequestDAOJDBC rd = new RequestDAOJDBC();
	rd.denyRequest(42, 1);
}
	@Override
	public Request approveRequest(int reimbId, int approvedBy) {
		log.trace("approving request with id: " + reimbId);
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		
		try (Connection conn = conUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVER = ?, REIMB_STATUS_ID = ?, REIMB_RESOLVED = ? WHERE REIMB_ID = ?");
			ps.setInt(1, approvedBy);
			ps.setInt(2, 2);
			ps.setTimestamp(3, ts);
			ps.setInt(4, reimbId);
			ResultSet rs = ps.executeQuery();
			log.debug("query executed");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Request denyRequest(int reimbId, int deniedBy) {

		Timestamp ts = new Timestamp(System.currentTimeMillis());
		
		try (Connection conn = conUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE ERS_REIMBURSEMENT SET REIMB_RESOLVER = ?, REIMB_STATUS_ID = ?, REIMB_RESOLVED = ? WHERE REIMB_ID = ?");
			ps.setInt(1, deniedBy);
			ps.setInt(2, 3);
			ps.setTimestamp(3, ts);
			ps.setInt(4, reimbId);
			ResultSet rs = ps.executeQuery();
			log.debug("query executed");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Request newRequest(Request r, int author) {

		try (Connection conn = conUtil.getConnection()) {

			Timestamp ts = new Timestamp(System.currentTimeMillis());
			PreparedStatement ps = conn.prepareStatement("INSERT INTO ERS_REIMBURSEMENT"
					+ "(REIMB_AMOUNT, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID, REIMB_SUBMITTED) VALUES"
					+ "(?,?,?,?,?,?)");
			ps.setDouble(1, r.getAmount());
			ps.setString(2, r.getDescription());
			ps.setInt(3, author);
			ps.setInt(4, 1);
			ps.setInt(5, r.getTypeId());
			ps.setTimestamp(6, ts);
			ResultSet rs = ps.executeQuery();
			log.debug("Create new reimbursement query executed");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Request> userAll(int author) {

		List<Request> requests = new ArrayList<>();
		log.debug("attempting to retreive all pending reimbursement requests");

		try (Connection conn = conUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = ?");
			ps.setInt(1, author);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("REIMB_ID");
				double amount = rs.getDouble("REIMB_AMOUNT");
				Timestamp submit = rs.getTimestamp("REIMB_SUBMITTED");
				Timestamp resolved = rs.getTimestamp("REIMB_RESOLVED");
				String description = rs.getString("REIMB_DESCRIPTION");
				int auth = rs.getInt("REIMB_AUTHOR");
				int resolver = rs.getInt("REIMB_RESOLVER");
				int statusid = rs.getInt("REIMB_STATUS_ID");
				int typeid = rs.getInt("REIMB_TYPE_ID");
				requests.add(new Request(id, amount, submit, resolved, description, auth, resolver, statusid, typeid));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn("failed to retreive all reimbursement requests");
		}

		return requests;

	}

	@Override
	public List<Request> userPending(int author) {

		List<Request> requests = new ArrayList<>();
		log.debug("attempting to retreive all pending reimbursement requests");

		try (Connection conn = conUtil.getConnection()) {
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = ? AND REIMB_STATUS_ID = ?");
			ps.setInt(1, author);
			ps.setInt(2, 1);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("REIMB_ID");
				double amount = rs.getDouble("REIMB_AMOUNT");
				Timestamp submit = rs.getTimestamp("REIMB_SUBMITTED");
				Timestamp resolved = rs.getTimestamp("REIMB_RESOLVED");
				String description = rs.getString("REIMB_DESCRIPTION");
				int auth = rs.getInt("REIMB_AUTHOR");
				int resolver = rs.getInt("REIMB_RESOLVER");
				int statusid = rs.getInt("REIMB_STATUS_ID");
				int typeid = rs.getInt("REIMB_TYPE_ID");
				requests.add(new Request(id, amount, submit, resolved, description, auth, resolver, statusid, typeid));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn("failed to retreive all reimbursement requests");
		}

		return requests;
	}
}
