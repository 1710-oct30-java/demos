package com.ers.beans;

public class Reimbursement {
	private int r_id;
	private double r_amount;
	private String r_submitted;
	private String r_resolved;
	private String r_description;
	private String r_receipt;
	private int r_author;
	private int r_resolver;
	private int r_status_id;
	private int r_type_id;
		
	public Reimbursement() {
		super();
	}
	
	public Reimbursement(int r_id, double r_amount, String r_submitted, String r_resolved, String r_description,
			String r_receipt, int r_author, int r_resolver, int r_status_id, int r_type_id) {
		this.r_id = r_id;
		this.r_amount = r_amount;
		this.r_submitted = r_submitted;
		this.r_resolved = r_resolved;
		this.r_description = r_description;
		this.r_receipt = r_receipt;
		this.r_author = r_author;
		this.r_resolver = r_resolver;
		this.r_status_id = r_status_id;
		this.r_type_id = r_type_id;
	}


	public int getR_id() {
		return r_id;
	}


	public void setR_id(int r_id) {
		this.r_id = r_id;
	}


	public double getR_amount() {
		return r_amount;
	}


	public void setR_amount(double r_amount) {
		this.r_amount = r_amount;
	}


	public String getR_submitted() {
		return r_submitted;
	}


	public void setR_submitted(String r_submitted) {
		this.r_submitted = r_submitted;
	}


	public String getR_resolved() {
		return r_resolved;
	}


	public void setR_resolved(String r_resolved) {
		this.r_resolved = r_resolved;
	}


	public String getR_description() {
		return r_description;
	}


	public void setR_description(String r_description) {
		this.r_description = r_description;
	}


	public String getR_receipt() {
		return r_receipt;
	}


	public void setR_receipt(String r_receipt) {
		this.r_receipt = r_receipt;
	}


	public int getR_author() {
		return r_author;
	}


	public void setR_author(int r_author) {
		this.r_author = r_author;
	}


	public int getR_resolver() {
		return r_resolver;
	}


	public void setR_resolver(int r_resolver) {
		this.r_resolver = r_resolver;
	}


	public int getR_status_id() {
		return r_status_id;
	}


	public void setR_status_id(int r_status_id) {
		this.r_status_id = r_status_id;
	}


	public int getR_type_id() {
		return r_type_id;
	}


	public void setR_type_id(int r_type_id) {
		this.r_type_id = r_type_id;
	}
	

	@Override
	public String toString() {
		return "ID:\t\t" + r_id
				+ "\nAmount:\t\t$ " + r_amount
				+ "\nSubmitted:\t" + r_submitted
				+ "\nResolved:\t" + r_resolved
				+ "\nDescription:\t" + r_description
				+ "\nReceipt:\t" + r_receipt
				+ "\nAuthor:\t\t" + r_author
				+ "\nResolver:\t" + r_resolver
				+ "\nStatus ID:\t" + r_status_id
				+ "\nType ID:\t" + r_type_id + "\n";
	}
	
}
