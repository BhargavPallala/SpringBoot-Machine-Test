package com.nissan.model;

public class DepositDTO
{
	//Deposit DTO Data Fields
	private String accountNo;
	private int pin;
	private double depositAmount;
	private String panNumber;
	
	
	//Default Constructor
	public DepositDTO() {
		super();
	}


	//Parameterized Constructor
	public DepositDTO(String accountNo, int pin, double depositAmount, String panNumber) {
		super();
		this.accountNo = accountNo;
		this.pin = pin;
		this.depositAmount = depositAmount;
		this.panNumber = panNumber;
	}
	
	//Getters & Setters
	public String getAccountNo() {
		return accountNo;
	}


	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}


	public int getPin() {
		return pin;
	}


	public void setPin(int pin) {
		this.pin = pin;
	}


	public double getDepositAmount() {
		return depositAmount;
	}


	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}


	public String getPanNumber() {
		return panNumber;
	}


	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	
	
	
	
}
