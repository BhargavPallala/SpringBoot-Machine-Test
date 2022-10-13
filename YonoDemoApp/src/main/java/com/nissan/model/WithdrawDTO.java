package com.nissan.model;

public class WithdrawDTO
{
	//Deposit DTO Data Fields
	private String accountNo;
	private int pin;
	private double withdrawAmount;
	private String panNumber;
	
	
	//Default Constructor
	public WithdrawDTO() {
		super();
	}


	//Parameterized Constructor
	public WithdrawDTO(String accountNo, int pin, double withdrawAmount,String panNumber) {
		super();
		this.accountNo = accountNo;
		this.pin = pin;
		this.withdrawAmount = withdrawAmount;
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


	public double getWithdrawAmount() {
		return withdrawAmount;
	}


	public void setWithdrawAmount(double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}


	public String getPanNumber() {
		return panNumber;
	}


	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	
	
	
	
}
