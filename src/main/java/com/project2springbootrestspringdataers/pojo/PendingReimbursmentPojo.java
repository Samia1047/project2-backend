package com.project2springbootrestspringdataers.pojo;


import java.util.Date;
import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(dateOfRequest, reimbursementAmount, reimbursementId, requestingEmployeeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PendingReimbursmentPojo other = (PendingReimbursmentPojo) obj;
		return Objects.equals(dateOfRequest, other.dateOfRequest)
				&& Double.doubleToLongBits(reimbursementAmount) == Double.doubleToLongBits(other.reimbursementAmount)
				&& reimbursementId == other.reimbursementId && requestingEmployeeId == other.requestingEmployeeId;
	}


	

}
