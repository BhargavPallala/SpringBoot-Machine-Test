package com.nissan.model;


public class UpdateAccountDTO
{
	private String accountNo;
	private String mobileNumber;
	private String emailAddress;
	
	
	//Default Constructor
	public UpdateAccountDTO() {
		super();
	}

	
	//Parameterized Constructor
	public UpdateAccountDTO(String accountNo, String mobileNumber, String emailAddress) {
		super();
		this.accountNo = accountNo;
		this.mobileNumber = mobileNumber;
		this.emailAddress = emailAddress;
	}


	//Getters & Setters
	public String getAccountNo() {
		return accountNo;
	}


	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
}
