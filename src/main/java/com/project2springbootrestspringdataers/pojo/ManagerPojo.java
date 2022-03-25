package com.project2springbootrestspringdataers.pojo;

public class ManagerPojo {

	private int managerId;
	private String managerPassword;
	private String managerFirstName;
	private String managerLastName;
	private String managerContact;
	private String managerAddress;
	private String managerImageUrl;



	public ManagerPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ManagerPojo(int managerId, String managerPassword, String managerFirstName, String managerLastName,
			String managerContact, String managerAddress, String managerImageUrl) {
		super();
		this.managerId = managerId;
		this.managerPassword = managerPassword;
		this.managerFirstName = managerFirstName;
		this.managerLastName = managerLastName;
		this.managerContact = managerContact;
		this.managerAddress = managerAddress;
		this.managerImageUrl = managerImageUrl;
	}



	public int getManagerId() {
		return managerId;
	}



	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}





	public String getManagerPassword() {
		return managerPassword;
	}



	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}


	public String getManagerFirstName() {
		return managerFirstName;
	}


	public void setManagerFirstName(String managerFirstName) {
		this.managerFirstName = managerFirstName;
	}



	public String getManagerLastName() {
		return managerLastName;
	}



	public void setManagerLastName(String managerLastName) {
		this.managerLastName = managerLastName;
	}



	public String getManagerContact() {
		return managerContact;
	}



	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}


	public String getManagerAddress() {
		return managerAddress;
	}


	public void setManagerAddress(String managerAddress) {
		this.managerAddress = managerAddress;
	}


	public String getManagerImageUrl() {
		return managerImageUrl;
	}



	public void setManagerImageUrl(String managerImageUrl) {
		this.managerImageUrl = managerImageUrl;
	}

	
	

	@Override
	public String toString() {
		return "ManagerPojo [managerId=" + managerId + ", managerPassword=" + managerPassword + ", managerFirstName="
				+ managerFirstName + ", managerLastName=" + managerLastName + ", managerContact=" + managerContact
				+ ", managerAddress=" + managerAddress + ", managerImageUrl=" + managerImageUrl + "]";
	}


}
