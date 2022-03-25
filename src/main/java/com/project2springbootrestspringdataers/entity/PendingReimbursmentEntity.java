package com.project2springbootrestspringdataers.entity;


import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="pending_reimbursment")
public class PendingReimbursmentEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="reimbursement_id")
	private int reimbursementId;
	
	@Column(name="requesting_employee_id")
	private int requestingEmployeeId;
	
	@Column(name="reimbursement_amount")
	private double reimbursementAmount;

	 @Temporal(TemporalType.TIMESTAMP)
	 @Column(name = "date_of_request", nullable=false)
	  private Date dateOfRequest;
	 
	 @PrePersist
	 protected void onCreate() {
		 dateOfRequest = new Date();
	 }
	 
	public PendingReimbursmentEntity() {
	
	}

	public PendingReimbursmentEntity(int reimbursementId, int requestingEmployeeId, double reimbursementAmount,
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
		return "PendingReimbursmentEntity [reimbursementId=" + reimbursementId + ", requestingEmployeeId="
				+ requestingEmployeeId + ", reimbursementAmount=" + reimbursementAmount + ", dateOfRequest="
				+ dateOfRequest + "]";
	}


}
