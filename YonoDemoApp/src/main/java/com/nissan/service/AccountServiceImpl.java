package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.model.Account;
import com.nissan.model.CustomerDTO;
import com.nissan.model.DepositDTO;
import com.nissan.model.ShowBalanceDTO;
import com.nissan.model.TransferDTO;
import com.nissan.model.UpdateAccountDTO;
import com.nissan.model.WithdrawDTO;
import com.nissan.repo.IAccountRepository;

@Service
public class AccountServiceImpl implements IAccountService
{
	//Field Injection
	@Autowired
	IAccountRepository accRepo;
	
	
	//Administrator Service Implementation
	//-------------------------------------
	//Add a new Customer
	@Transactional
	@Override
	public Account addAccount(CustomerDTO customerDTO)
	{
		
		//Creating an Account Object from AccountDTO Object
		Account account = new Account();
		
		String tempAccountNo;		
		Account tempAccount;
		
		//Looping to generate Next Non Matching Auto Generated Account Number
		do
		{
			//Creating auto Generated Account Number
			tempAccountNo = account.generateAccountNo();
			System.out.println("AutoGenerated New Account Number");
			
			//Finding account with generated account No.
			tempAccount = findByAccountNo(tempAccountNo);
			
			
			//Validate with already existing Account Number
		}
		while(tempAccount != null);
		
		//Initializing the Account Object
		account.setAccountNo(tempAccountNo);
		account.setActive(true);
		account.setBalance(customerDTO.getBalance());
		account.setCustomerName(customerDTO.getCustomerName());
		account.setSaving(customerDTO.isSaving());
		account.setEmailAddress(customerDTO.getEmailAddress());
		account.setMobileNumber(customerDTO.getMobileNumber());
			
		return accRepo.save(account);
	}

	//Update Customer Details
	@Transactional
	@Override
	public Account updateAccount(UpdateAccountDTO updateAccountDTO)
	{
		//Finding the Account By Account No.
		Account account = findByAccountNo(updateAccountDTO.getAccountNo());
		
		if(account == null)
		{
			System.out.println("No Account Find with accountNo. = " + updateAccountDTO.getAccountNo());
			return null;
		}
		
		//Updating Account
		System.out.println("Updating Account");
		account.setEmailAddress(updateAccountDTO.getEmailAddress());
		account.setMobileNumber(updateAccountDTO.getMobileNumber());
		
		System.out.println("Updated Account Succesfully");
		return accRepo.save(account);
		
	}

	//Delete a Customer
	@Transactional
	@Override
	public Account deleteAccount(String accountNo)
	{
		//Finding the Account By Account No.
		Account account = findByAccountNo(accountNo);
		
		if(account == null)
		{
			System.out.println("No Account Find with accountNo. = " + accountNo);
			return null;
		}
		
		//Deleting the Account
		System.out.println("Deleting Account");
		account.setActive(false);
		
		System.out.println("Deleted Account Succesfully");
		return accRepo.save(account);
	}

	
	
	//Find all Customers in Bank
	@Override
	public List<Account> findAllAccounts()
	{
		return (List<Account>)accRepo.findAll();
	}

	
	//Find Customer By Account Number
	@Override
	public Account findByAccountNo(String accNo)
	{
		Account _account = accRepo.findByAccountNo(accNo);
		
		if(_account != null)
		{
			//Check Condition for Account
			if(accNo.equals(_account.getAccountNo()))
			{
				return _account;
			}
		}
		return null;
	}
	
	
	
	
	//Customer Services Implementation
	//--------------------------------
	
	//Deposit Money
	@Transactional
	@Override
	public Account depositMoney(DepositDTO depositDTO)
	{
		if(depositDTO.getDepositAmount() < 0)
		{
			System.out.println("Please provide +ve value for amount");
			return null;
		}
		
		Account account =  accRepo.findByAccountNo(depositDTO.getAccountNo());
		
		//Checking for existence
		if(account == null)
		{
			System.out.println("Account number "+depositDTO.getAccountNo() +" doesn't exist");
			return null;
		}
		
		//Check for Correct PIN
		if(account.getPin() != depositDTO.getPin())
		{
			System.out.println("---Wrong PIN---");
			return null;
		}
		
		//Check for above 50K amount
		if( (depositDTO.getDepositAmount() > 50000) && (depositDTO.getPanNumber() == null) )
		{
			System.out.println("Provide PAN Number as amount is above 50K");
			return null;
		}
		
		account.setBalance(account.getBalance() + depositDTO.getDepositAmount());
		
		return accRepo.save(account);
	}

	//Withdraw Money
	@Transactional
	@Override
	public Account withdrawMoney(WithdrawDTO withdrawDTO)
	{
		if(withdrawDTO.getWithdrawAmount() < 0)
		{
			System.out.println("Please provide +ve value for amount");
			return null;
		}
		
		Account account =  accRepo.findByAccountNo(withdrawDTO.getAccountNo());
		
		//Checking for existence
		if(account == null)
		{
			System.out.println("Account number "+withdrawDTO.getAccountNo() +" doesn't exist");
			return null;
		}
		
		//Check for Correct PIN
		if(account.getPin() != withdrawDTO.getPin())
		{
			System.out.println("---Wrong PIN---");
			return null;
		}
		
		//Check for Minimum Balance Criteria
		double tempFinalBalance = account.getBalance() - withdrawDTO.getWithdrawAmount();
		
		if(tempFinalBalance <= account.getMinBalance())
		{
			System.out.println("Insufficient Amount in your Bank Account");
			return null;
		}
		
		//Check for above 50K amount
		if( (withdrawDTO.getWithdrawAmount() > 50000) && (withdrawDTO.getPanNumber() == null) )
		{
			System.out.println("Provide PAN Number as amount is above 50K");
			return null;
		}
		
		account.setBalance(account.getBalance() - withdrawDTO.getWithdrawAmount());
		System.out.println("Amount Withdrawn Successfull..");
		return accRepo.save(account);
	}

	//Show Balance
	@Override
	public Account showBalance(ShowBalanceDTO showBalanceDTo)
	{
		Account account =  accRepo.findByAccountNo(showBalanceDTo.getAccountNo());
		
		//Checking for existence
		if(account == null)
		{
			System.out.println("Account number "+showBalanceDTo.getAccountNo() +" doesn't exist");
			return null;
		}
		
		//Check for Correct PIN
		if(account.getPin() != showBalanceDTo.getPin())
		{
			System.out.println("---Wrong PIN---");
			return null;
		}
		
		return account;
	}

	//Transfer Money
	@Transactional
	@Override
	public Account transferMoney(TransferDTO transferDTO)
	{
		Account fromAccount =  accRepo.findByAccountNo(transferDTO.getAccountNo());
		
		//Checking for existence
		if(fromAccount == null)
		{
			System.out.println("Account number "+transferDTO.getAccountNo() +" doesn't exist");
			return null;
		}
		
		//Check for Correct PIN
		if(fromAccount.getPin() != transferDTO.getPin())
		{
			System.out.println("---Wrong PIN---");
			return null;
		}
		
		Account toAccount =  accRepo.findByAccountNo(transferDTO.getTransferToAccNo());
		
		//Checking for existence
		if(toAccount == null)
		{
			System.out.println("Target Account number "+transferDTO.getAccountNo() +" doesn't exist");
			return null;
		}
		
		//Transferring Amount
		if(transferDTO.getTransferAmount() < 0)
		{
			System.out.println("Please provide +ve value for amount");
			return null;
		}
		
		//Check for Minimum Balance Criteria
		double tempFinalBalance = fromAccount.getBalance() - transferDTO.getTransferAmount();
		
		if(tempFinalBalance <= fromAccount.getMinBalance())
		{
			System.out.println("Insufficient Amount to transfer from your Bank Account");
			return null;
		}
		
		//Debited for Sender
		fromAccount.setBalance(fromAccount.getBalance() - transferDTO.getTransferAmount());
		
		//Credited for Receiver
		toAccount.setBalance(toAccount.getBalance() + transferDTO.getTransferAmount());
		
		//Saving changes
		accRepo.save(toAccount);
		
		//Returning from Account Object for Acknowledging
		return accRepo.save(fromAccount);
	}

}
