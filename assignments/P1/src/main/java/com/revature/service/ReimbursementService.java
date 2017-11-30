package com.revature.service;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbursement;
import com.revature.beans.User;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOjdbc;
import com.revature.dao.SimpleDAOs;
import com.revature.dao.SimpleDAOsjdbc;

public class ReimbursementService {
	private static ReimbursementService rs = new ReimbursementService();
	Logger log = Logger.getRootLogger();
	private static ReimbursementDAO rdao = ReimbursementDAOjdbc.getReimburesmentDAOjdbc();
	private static SimpleDAOs rsdao = new SimpleDAOsjdbc("reimbursement_status", "status_id", "status");

	private ReimbursementService() {
	}

	public static ReimbursementService getReimburesmentService() {
		return rs;
	}

	public List<Reimbursement> getAllReimbursements() {
		log.debug("Attempting to get all Reimburesments");
		return rdao.getReimbursements();
	}

	public List<Reimbursement> getReimbursement(int id) {
		log.debug("Attempting to get reimbursements");
		return rdao.getReimbursementsById(id);
	}

	public boolean postReimbursement(String json) {
		log.debug("Attempting to post reimbursement");
		Reimbursement r = extractReimbursement(json);
		return (rdao.addReimbursement(r) > 0 ? true : false);
	}

	public boolean putReimbursement(String json, User user) {
		log.debug("Attempting to put reimbursement");
		Reimbursement r = extractReimbursement(json);
		r.setResolver(user.getId());
		r.setResolved(Date.valueOf(LocalDate.now()));
		log.trace(r);
		return rdao.alterReimbursement(r.getId(), r);
	}

	public boolean deleteReimbursement(String json) {
		log.debug("Attempting to delete reimbursement");
		Reimbursement r = extractReimbursement(json);
		return rdao.removeReimbursementById(r.getId());
	}

	private Reimbursement extractReimbursement(String json) {
		log.debug("Attempting to extract Reimbursement from json");
		ObjectMapper om = new ObjectMapper();
		Reimbursement r = null;
		try {
			r = om.readValue(json, Reimbursement.class);
		} catch (IOException e) {
			log.warn("Failed to extract Reimbursement " + e);
		}

		return r;
	}

	public int newReimbursement(String json, int authorId) {
		ObjectMapper om = new ObjectMapper();
		Reimbursement r;
		try {
			r = om.readValue(json, Reimbursement.class);
			r.setAuthor(authorId);
			r.setResolver(authorId);
			r.setSubmitted(Date.valueOf(LocalDate.now()));
			r.setStatusId(rsdao.getIdByName("pending"));
			log.trace(r);
			return rdao.addReimbursement(r);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return 0;
	}
}
