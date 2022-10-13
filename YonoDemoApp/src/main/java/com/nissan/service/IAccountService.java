package com.nissan.service;

import java.util.List;

import com.nissan.model.Account;
import com.nissan.model.CustomerDTO;
import com.nissan.model.DepositDTO;
import com.nissan.model.ShowBalanceDTO;
import com.nissan.model.TransferDTO;
import com.nissan.model.UpdateAccountDTO;
import com.nissan.model.WithdrawDTO;

public interface IAccountService
{
	//Administrator Service 
	//-----------------------
	//1. Add a new Customer
	Account addAccount(CustomerDTO customerDTO);
	
	//2. Update a Customer Details
	Account updateAccount(UpdateAccountDTO updateAccountDTO);
	
	//3. Delete a Customer
	Account deleteAccount(String accountNo);
	
	//4. Display the list of all Customers in the Bank
	List<Account> findAllAccounts();
	
	//5. Display Customer Details of a Specific Customer
	Account findByAccountNo(String accNo);
	
	
	
	//Customer Service
	//-----------------------------------
	//1. Deposit Money into Customer Account
	Account depositMoney(DepositDTO depositDTO);
	
	//2. Withdraw Money from Customer Account
	Account withdrawMoney(WithdrawDTO withdrawDTO);
	
	//3. Show Balance of a Customer
	Account showBalance(ShowBalanceDTO showBalanceDTO);
	
	//4. Transferring Money from One Account to Another Account
	Account transferMoney(TransferDTO transferDTO);
	
}
