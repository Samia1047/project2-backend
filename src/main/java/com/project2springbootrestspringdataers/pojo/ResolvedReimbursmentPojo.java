package com.project2springbootrestspringdataers.pojo;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ResolvedReimbursmentPojo {
	private int reimbursementId;
	private int requestingEmployeeId;	
	private double reimbursementAmount;
	private boolean requestApproved;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateResolved;
	
	public ResolvedReimbursmentPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResolvedReimbursmentPojo(int reimbursementId, int requestingEmployeeId, double reimbursementAmount,
			boolean requestApproved, Date dateResolved) {
		super();
		this.reimbursementId = reimbursementId;
		this.requestingEmployeeId = requestingEmployeeId;
		this.reimbursementAmount = reimbursementAmount;
		this.requestApproved = requestApproved;
		this.dateResolved = dateResolved;
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

	public boolean isRequestApproved() {
		return requestApproved;
	}

	public void setRequestApproved(boolean requestApproved) {
		this.requestApproved = requestApproved;
	}

	public Date getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(Date dateResolved) {
		this.dateResolved = dateResolved;
	}

	@Override
	public String toString() {
		return "ResolvedReimbursmentPojo [reimbursementId=" + reimbursementId + ", requestingEmployeeId="
				+ requestingEmployeeId + ", reimbursementAmount=" + reimbursementAmount + ", requestApproved="
				+ requestApproved + ", dateResolved=" + dateResolved + "]";
	}
	
	

}
