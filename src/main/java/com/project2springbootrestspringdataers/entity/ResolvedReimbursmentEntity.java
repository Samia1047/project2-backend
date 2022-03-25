package com.project2springbootrestspringdataers.entity;

import java.sql.Timestamp;
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
@Table(name="resolved_reimbursment")
public class ResolvedReimbursmentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="reimbursement_id")
	private int reimbursementId;
	
	@Column(name="requesting_employee_id")
	private int requestingEmployeeId;
	
	@Column(name="reimbursement_amount")
	private double reimbursementAmount;
	
	@Column(name="request_approved")
	private boolean requestApproved;
	
	
	 @Temporal(TemporalType.TIMESTAMP)
	 @Column(name = "date_resolved", nullable=false)
	  private Date dateResolved;
	 
	 @PrePersist
	 protected void onCreate() {
		 dateResolved = new Date();
	 }
	
	public ResolvedReimbursmentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResolvedReimbursmentEntity(int reimbursementId, int requestingEmployeeId, double reimbursementAmount,
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
