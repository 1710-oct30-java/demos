package com.revature.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.beans.ErsReimbursement;
import com.revature.dao.ErsReimbursementDao;
import com.revature.dao.ErsReimbursementDaoJDBC;

public class ErsReimbursementService {
	private ErsReimbursementDao rd = new ErsReimbursementDaoJDBC();

	public List<ErsReimbursement> getAllReim() {
		return rd.findAll();
	}

	public void getByUserId(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("begining getByUserId");
		System.out.println(request);
		List<ErsReimbursement> reimbursements = new ArrayList<ErsReimbursement>();
		reimbursements = rd.findByUserId(Integer.parseInt(request.getParameter("userId")));

		ObjectMapper om = new ObjectMapper();
		ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
		String json;
		try {
			json = ow.writeValueAsString(reimbursements);
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void create(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("request to create new ticket received");

		try {
			String json;
			// read the body of the request into a single string
			json = request.getReader() // get buffered reader for reading the request body
					.lines() // stream the reader
					.reduce((acc, cur) -> acc + cur) // reduce the stream to a single string
					.get(); // get that single string
			ObjectMapper om = new ObjectMapper();
			ErsReimbursement reim = om.readValue(json, ErsReimbursement.class);
			rd.newReimbursement(reim);
		} catch (IOException | SQLException e) {
			response.setStatus(401);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getNotMine(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("begining getNotMine");
		System.out.println(request);
		List<ErsReimbursement> reimbursements = new ArrayList<ErsReimbursement>();
		reimbursements = rd.findByNotUserId(Integer.parseInt(request.getParameter("userId")));

		ObjectMapper om = new ObjectMapper();
		ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
		String json;
		try {
			json = ow.writeValueAsString(reimbursements);
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public void approve(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("request to approve ticket received");

		try {
			String json;
			// read the body of the request into a single string
			json = request.getReader() // get buffered reader for reading the request body
					.lines() // stream the reader
					.reduce((acc, cur) -> acc + cur) // reduce the stream to a single string
					.get(); // get that single string
			ObjectMapper om = new ObjectMapper();
			ErsReimbursement reim = om.readValue(json, ErsReimbursement.class);
			rd.approve(reim);
		} catch (IOException | SQLException e) {
			response.setStatus(401);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void deny(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("request to deny ticket received");

		try {
			String json;
			// read the body of the request into a single string
			json = request.getReader() // get buffered reader for reading the request body
					.lines() // stream the reader
					.reduce((acc, cur) -> acc + cur) // reduce the stream to a single string
					.get(); // get that single string
			ObjectMapper om = new ObjectMapper();
			ErsReimbursement reim = om.readValue(json, ErsReimbursement.class);
			rd.deny(reim);
		} catch (IOException | SQLException e) {
			response.setStatus(401);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
