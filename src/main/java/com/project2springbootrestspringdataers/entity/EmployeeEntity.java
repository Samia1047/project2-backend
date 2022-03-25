package com.project2springbootrestspringdataers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="employee_id")
	private int employeeId;
	
	@Column(name="employee_password")
	private String employeePassword;
	
	@Column(name="employee_first_name")
	private String employeeFirstName;
	
	@Column(name="employee_last_name")
	private String employeeLastName;
	
	@Column(name="employee_contact")
	private String employeeContact;
	
	@Column(name="employee_address")
	private String employeeAddress;
	
	@Column(name="employee_image_url")
	private String employeeImageUrl;
	
	public EmployeeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeEntity(int employeeId, String employeePassword, String employeeFirstName, String employeeLastName,
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
		return "EmployeeEntity [employeeId=" + employeeId + ", employeePassword=" + employeePassword
				+ ", employeeFirstName=" + employeeFirstName + ", employeeLastName=" + employeeLastName
				+ ", employeeContact=" + employeeContact + ", employeeAddress=" + employeeAddress
				+ ", employeeImageUrl=" + employeeImageUrl + "]";
	}

	
}
