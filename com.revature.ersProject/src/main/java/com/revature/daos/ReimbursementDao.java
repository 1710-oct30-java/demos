package com.revature.daos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.beans.User;

public interface ReimbursementDao {
	

	public List<Reimbursement> getReimbursements();
	
	public Reimbursement getReimbursementById(int r_id);
	
	public List<Reimbursement> getReimbursementsByStatusID(int r_status_id);
	
	public boolean addReimbursement(Reimbursement r);
	
	public boolean approveReimbursement(Reimbursement r, int resolverId);
	
}