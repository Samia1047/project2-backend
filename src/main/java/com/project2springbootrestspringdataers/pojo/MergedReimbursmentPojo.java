package com.project2springbootrestspringdataers.pojo;


public class MergedReimbursmentPojo {
	private int reimbursementId;
	private int requestingEmployeeId;
	private double reimbursementAmount;
	private Boolean requestApproved;
	private String dateOfRequest;
    private String dateResolved;
    
    
	public MergedReimbursmentPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
//pending without date
public MergedReimbursmentPojo(int reimbursementId, int requestingEmployeeId, double reimbursementAmount) {
		super();
		this.reimbursementId = reimbursementId;
		this.requestingEmployeeId = requestingEmployeeId;
		this.reimbursementAmount = reimbursementAmount;
	}

	//Pending
	public MergedReimbursmentPojo(int reimbursementId, int requestingEmployeeId, double reimbursementAmount,
			String dateOfRequest) {
		super();
		this.reimbursementId = reimbursementId;
		this.requestingEmployeeId = requestingEmployeeId;
		this.reimbursementAmount = reimbursementAmount;
		this.dateOfRequest = dateOfRequest;
	}

	//resolved constructor for approved/deny funtionality
	public MergedReimbursmentPojo(int requestingEmployeeId, double reimbursementAmount, Boolean requestApproved) {
		super();
		this.requestingEmployeeId = requestingEmployeeId;
		this.reimbursementAmount = reimbursementAmount;
		this.requestApproved = requestApproved;
	}
//resolved
	public MergedReimbursmentPojo(int reimbursementId, int requestingEmployeeId, double reimbursementAmount,
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
		return "MergedReimbursmentPojo [reimbursementId=" + reimbursementId + ", requestingEmployeeId="
				+ requestingEmployeeId + ", reimbursementAmount=" + reimbursementAmount + ", requestApproved="
				+ requestApproved + ", dateOfRequest=" + dateOfRequest + ", dateResolved=" + dateResolved + "]";
	}
	

	

	
    
    
    
}


