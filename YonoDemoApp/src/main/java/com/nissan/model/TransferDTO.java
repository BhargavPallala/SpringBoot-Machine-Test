package com.nissan.model;

public class TransferDTO
{
	//Data Fields
	private String accountNo;
	private int pin;
	private String transferToAccNo;
	private double transferAmount;
	
	//Default Constructor
	public TransferDTO() {
		super();
	}
	
	//Parameterized Constructor
	public TransferDTO(String accountNo, int pin, String transferToAccNo, double transferAmount) {
		super();
		this.accountNo = accountNo;
		this.pin = pin;
		this.transferToAccNo = transferToAccNo;
		this.transferAmount = transferAmount;
	}
	
	//Getters & Setters
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accounNo) {
		this.accountNo = accounNo;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getTransferToAccNo() {
		return transferToAccNo;
	}
	public void setTransferToAccNo(String transferToAccNo) {
		this.transferToAccNo = transferToAccNo;
	}
	public double getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}
	
	
}
