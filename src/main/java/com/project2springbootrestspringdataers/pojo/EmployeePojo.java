package com.project2springbootrestspringdataers.pojo;

public class EmployeePojo {

	private int employeeId;
	private String employeePassword;
	private String employeeFirstName;
	private String employeeLastName;
	private String employeeContact;
	private String employeeAddress;
	private String employeeImageUrl;
	//private MultipartFile file;
	//private byte[] image;
	
	public EmployeePojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeePojo(int employeeId, String employeePassword, String employeeFirstName, String employeeLastName,
			String employeeContact, String employeeAddress, String employeeImageUrl) {
		super();
		this.employeeId = employeeId;
		this.employeePassword = employeePassword;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.employeeContact = employeeContact;
		this.employeeAddress = employeeAddress;
		this.employeeImageUrl = employeeImageUrl;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public String getEmployeeContact() {
		return employeeContact;
	}

	public void setEmployeeContact(String employeeContact) {
		this.employeeContact = employeeContact;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeeImageUrl() {
		return employeeImageUrl;
	}

	public void setEmployeeImageUrl(String employeeImageUrl) {
		this.employeeImageUrl = employeeImageUrl;
	}


	@Override
	public String toString() {
		return "EmployeePojo [employeeId=" + employeeId + ", employeePassword=" + employeePassword
				+ ", employeeFirstName=" + employeeFirstName + ", employeeLastName=" + employeeLastName
				+ ", employeeContact=" + employeeContact + ", employeeAddress=" + employeeAddress
				+ ", employeeImageUrl=" + employeeImageUrl + "]";
	}
	
	

}
