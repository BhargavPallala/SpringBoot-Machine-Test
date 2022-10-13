package com.nissan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nissan.service.AccountServiceImpl;

@Entity
@Table(name = "Account")
public class Account
{	
	//Data Fields
	@Id
	@Column(nullable = false, unique = true)
	private String accountNo;			// AutoGenerate 9 Digits
	
	@Column(nullable = false)
	private String customerName;

	@Column(nullable = false, unique = true)
	private String mobileNumber;
	
	@Column(nullable = false, unique = true)
	private String emailAddress;
	
	private boolean isSaving;		//	(Savings/Current)
	private double balance;
	private int pin;				//	AutoGenerate 4 Digits pin;
	private String panNumber;
	private boolean isActive;
	
	// Static Variable(s)
	private static double minBalance = 1000.0; // Hard Coded values

	
	//Default Constructor
	public Account()
	{
		//Setting the PIN for the Account
		this.pin = generatePin();	
	}

	//Parameterized Constructor
	public Account(String accountNo, String customerName, boolean isSaving, double balance, String mobileNumber,
			String emailAddress, int pin, String panNumber, boolean isActive)
	{
		super();
		this.accountNo = accountNo;
		this.customerName = customerName;
		this.isSaving = isSaving;
		this.balance = balance;
		this.mobileNumber = mobileNumber;
		this.emailAddress = emailAddress;
		this.pin = pin;
		this.panNumber = panNumber;
		this.isActive = isActive;
	}

	

	//Getters & Setters
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public static double getMinBalance() {
		return minBalance;
	}

	public static void setMinBalance(double minBalance) {
		Account.minBalance = minBalance;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	//Overriding toString()
	@Override
	public String toString() {
		return String.format(
				"Account [accountNo=%s, customerName=%s, mobileNumber=%s, emailAddress=%s, isSaving=%s, balance=%s, pin=%s, panNumber=%s, isActive=%s]",
				accountNo, customerName, mobileNumber, emailAddress, isSaving, balance, pin, panNumber, isActive);
	}

	
 
	// Custom method to Generate Account No.
	public static String generateAccountNo()
	{

		// 9 Digit Account No. only Digits allowed
		StringBuilder randomAccountNo = new StringBuilder("");

		// Keeping 1st digit from 1-9
		int digit = (int) (Math.random() * 9 + 1);
		randomAccountNo.append(digit);

		// Keeping 2nd digit onwards as 0-9
		for (int i = 0; i < 8; i++)
		{
			digit = (int) (Math.random() * 9);
			randomAccountNo.append(digit);
		}
		
		return randomAccountNo.toString();
	}
	
	

	// Custom Method to Generate PIN
	private static int generatePin()
	{
		// Keeping 1st digit from 1-9
		int randomPin = (int) (Math.random() * 9 + 1);

		// Keeping 2nd digit onwards as 0-9
		for (int i = 0; i < 3; i++)
		{
			randomPin = randomPin * 10 + (int) (Math.random() * 9);
		}

		return randomPin;
	}

	
	

}
