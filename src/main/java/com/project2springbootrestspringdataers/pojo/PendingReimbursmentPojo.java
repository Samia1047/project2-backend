package com.project2springbootrestspringdataers.pojo;


import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class PendingReimbursmentPojo {
	
	private int reimbursementId;
	private int requestingEmployeeId;	
	private double reimbursementAmount;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfRequest;
	
	public PendingReimbursmentPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PendingReimbursmentPojo(int reimbursementId, int requestingEmployeeId, double reimbursementAmount,
			Date dateOfRequest) {
		super();
		this.reimbursementId = reimbursementId;
		this.requestingEmployeeId = requestingEmployeeId;
		this.reimbursementAmount = reimbursementAmount;
		this.dateOfRequest = dateOfRequest;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public int getRequestingEmployeeId() {
		return requestingEmployeeId;
	}

	public void setRequestingEmployeeId(int requestingEmployeeId) {
		this.requestingEmployeeId = requestingEmployeeId;
	}

	public double getReimbursementAmount() {
		return reimbursementAmount;
	}

	public void setReimbursementAmount(double reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}

	public Date getDateOfRequest() {
		return dateOfRequest;
	}

	public void setDateOfRequest(Date dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}

	@Override
	public String toString() {
		return "PendingReimbursmentPojo [reimbursementId=" + reimbursementId + ", requestingEmployeeId="
				+ requestingEmployeeId + ", reimbursementAmount=" + reimbursementAmount + ", dateOfRequest="
				+ dateOfRequest + "]";
	}


	

}
