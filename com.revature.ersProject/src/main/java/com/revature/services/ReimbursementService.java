package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.ReimbursementStatus;
import com.revature.beans.ReimbursementType;
import com.revature.beans.Reimbursement;
import com.revature.beans.User;
import com.revature.daos.ReimbursementDao;
import com.revature.daos.ReimbursementDaoJdbc;
public class ReimbursementService {
   private ReimbursementDaoJdbc rd = new ReimbursementDaoJdbc();
  
	public List <Reimbursement> getAllReimbursement () {
		System.out.println("in reimb service");
		 return rd.getReimbursements();	
	}	
    public boolean add(Reimbursement r) {
    	return rd.addReimbursement (r);
    }
    
    public List <Reimbursement> getReimbursementsByUser (int id) {
    		System.out.println("in reimb service");
    		 return rd.getReimbursementsByUserId (id);
    	
    }
		public boolean approveReimb(Reimbursement r, int resolver) {
			
			return rd.approveReimbursement(r, resolver);
		
		}

}
