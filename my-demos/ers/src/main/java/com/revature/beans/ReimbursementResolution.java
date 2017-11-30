package com.revature.beans;

public class ReimbursementResolution {
	private int status;
	
	public ReimbursementResolution(){
		super();
	}
	
	public ReimbursementResolution(int x){
		status = x;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
