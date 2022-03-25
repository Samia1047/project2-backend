package com.project2springbootrestspringdataers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="merged_reimbursment")
public class MergedReimbursmentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="reimbursement_id")
	private int reimbursementId;
	
	@Column(name="requesting_employee_id")
	private int requestingEmployeeId;
	
	@Column(name="reimbursement_amount")
	private double reimbursementAmount;
	
	@Column(name="request_approved")
	private Boolean requestApproved;
	
	@Column(name="date_of_request")
	private String dateOfRequest;
	
	@Column(name="date_resolved")
    private String dateResolved;
    
    
	public MergedReimbursmentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
//pending without date
public MergedReimbursmentEntity(int reimbursementId, int requestingEmployeeId, double reimbursementAmount) {
		super();
		this.reimbursementId = reimbursementId;
		this.requestingEmployeeId = requestingEmployeeId;
		this.reimbursementAmount = reimbursementAmount;
	}

	//Pending
	public MergedReimbursmentEntity(int reimbursementId, int requestingEmployeeId, double reimbursementAmount,
			String dateOfRequest) {
		super();
		this.reimbursementId = reimbursementId;
		this.requestingEmployeeId = requestingEmployeeId;
		this.reimbursementAmount = reimbursementAmount;
		this.dateOfRequest = dateOfRequest;
	}

	//resolved constructor for approved/deny funtionality
	public MergedReimbursmentEntity(int requestingEmployeeId, double reimbursementAmount, Boolean requestApproved) {
		super();
		this.requestingEmployeeId = requestingEmployeeId;
		this.reimbursementAmount = reimbursementAmount;
		this.requestApproved = requestApproved;
	}
//resolved
	public MergedReimbursmentEntity(int reimbursementId, int requestingEmployeeId, double reimbursementAmount,
			Boolean requestApproved, String dateResolved) {
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

	public Boolean getRequestApproved() {
		return requestApproved;
	}

	public void setRequestApproved(Boolean requestApproved) {
		this.requestApproved = requestApproved;
	}

	public String getDateOfRequest() {
		return dateOfRequest;
	}

	public void setDateOfRequest(String dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}

	public String getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(String dateResolved) {
		this.dateResolved = dateResolved;
	}
	@Override
	public String toString() {
		return "MergedReimbursmentEntity [reimbursementId=" + reimbursementId + ", requestingEmployeeId="
				+ requestingEmployeeId + ", reimbursementAmount=" + reimbursementAmount + ", requestApproved="
				+ requestApproved + ", dateOfRequest=" + dateOfRequest + ", dateResolved=" + dateResolved + "]";
	}
	

	

	
    
    
    
}


