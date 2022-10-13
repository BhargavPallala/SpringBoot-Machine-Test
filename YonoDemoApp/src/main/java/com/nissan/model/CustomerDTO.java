package com.nissan.model;


public class CustomerDTO
{
	//Data Fields	
	private String customerName;
	private String mobileNumber;
	private String emailAddress;
	private boolean isSaving;
	private double balance;
	
	
	//Parameterized Constructor
	public CustomerDTO(String customerName, String mobileNumber, String emailAddress, boolean isSaving,
			double balance)
	{
		super();
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.emailAddress = emailAddress;
		this.isSaving = isSaving;
		this.balance = balance;
	}
	
	//Getters & Setters
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	public boolean isSaving() {
		return isSaving;
	}
	public void setSaving(boolean isSaving) {
		this.isSaving = isSaving;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
}
