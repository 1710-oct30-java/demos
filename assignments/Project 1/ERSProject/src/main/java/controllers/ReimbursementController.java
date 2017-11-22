package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Reimbursement;
import services.ReimbursementService;

public class ReimbursementController {
	private Logger log = Logger.getRootLogger();
	private ReimbursementService rs = new ReimbursementService();
	
	public void delegateGet(HttpServletRequest request, HttpServletResponse response) {
		log.debug("get request delegated to reimbursements controller");
		
	}
	
	public void delegatePost(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		log.debug("post request delegated to reimbursement  controller");
		String reimburseURL = request.getRequestURI().substring(request.getContextPath().length() + "/reimbursements".length());
		
		if("".equals(reimburseURL)) {
			try {
				String json = request.getReader().lines().reduce((acc, cur) -> acc+cur).get();
				log.trace("jason received = " + json);
				ObjectMapper om = new ObjectMapper();
				Reimbursement r = om.readValue(json, Reimbursement.class);
				log.trace("object created from json = " + r);
				
				rs.save(r);
			}  catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
