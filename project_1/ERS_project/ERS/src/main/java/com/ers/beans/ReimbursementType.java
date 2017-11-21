package com.ers.beans;

public class ReimbursementType {
	private int r_type_id;
	private String r_type;
	
	public ReimbursementType() {
		super();
	}

	public ReimbursementType(int r_type_id, String r_type) {
		this.r_type_id = r_type_id;
		this.r_type = r_type;
	}

	public int getR_type_id() {
		return r_type_id;
	}

	public void setR_type_id(int r_type_id) {
		this.r_type_id = r_type_id;
	}

	public String getR_type() {
		return r_type;
	}

	public void setR_type(String r_type) {
		this.r_type = r_type;
	}

	@Override
	public String toString() {
		return "Type ID:\t" + r_type_id + "\nType:\t\t" + r_type + "\n";
	}
	
	
}
