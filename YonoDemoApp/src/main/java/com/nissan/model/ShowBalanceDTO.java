package com.nissan.model;

public class ShowBalanceDTO
{
	//Data Fields
	private String accountNo;
	private int pin;
	
	//Default Constructor
	public ShowBalanceDTO() {
		super();
	}

	//Parameterized Constructor
	public ShowBalanceDTO(String accountNo, int pin) {
		super();
		this.accountNo = accountNo;
		this.pin = pin;
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
	
	
	
	
}
