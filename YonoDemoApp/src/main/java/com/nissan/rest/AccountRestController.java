package com.nissan.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.model.Account;
import com.nissan.model.CustomerDTO;
import com.nissan.model.DepositDTO;
import com.nissan.model.ShowBalanceDTO;
import com.nissan.model.TransferDTO;
import com.nissan.model.UpdateAccountDTO;
import com.nissan.model.WithdrawDTO;
import com.nissan.service.IAccountService;

@CrossOrigin				//Helps to avoid CORS Error
@RestController
@RequestMapping({"api/"})
public class AccountRestController
{
	//Field Injection
	@Autowired
	IAccountService accService;
	
	@RequestMapping({"hello"})
	public String firstPage()
	{
		System.out.println("Success to World");
		return "Hello World";
	}
	
	//Administrator Controls
	//----------------------
	//List all Employee
	@GetMapping("admin/customers")
	public List<Account> findAllAccounts()
	{
		return accService.findAllAccounts();
	}
	
	
	//Get Account By Account Number
	@GetMapping("admin/customer/accountNo={accountNo}")
	public Account findByAccountNo(@PathVariable String accountNo)
	{
		System.out.println("Inside Controller - Finding By Account No.");
		return accService.findByAccountNo(accountNo);
	}
	
	
	//Add Account
	@PostMapping("admin/addCustomer")
	public ResponseEntity<Account> addAccount(@RequestBody CustomerDTO customerDTO)
	{
		System.out.println("Inserting a Record in Account Table");
		//Transferring AccountDTO Object
		return new ResponseEntity<Account>(accService.addAccount(customerDTO),HttpStatus.OK);
	}
	
	//Update Account
	@PutMapping("admin/updateCustomer")
	public Account editAccount(@RequestBody UpdateAccountDTO updateAccountDTO)
	{
		System.out.println("Updating a Record in Account Table");
		return accService.updateAccount(updateAccountDTO);
	}
	
	//Delete Account
	@GetMapping("admin/deleteCustomer/{accountNo}")
	public Account deleteAccount(@PathVariable String accountNo)
	{
		System.out.println("Deleting a Record from Account Table");
		return accService.deleteAccount(accountNo);
	}
	
	
	//Customer Controls
	//-----------------
	//Deposit Money
	@PutMapping("customer/deposit")
	public Account depositMoney(@RequestBody DepositDTO depositDTO)
	{
		return accService.depositMoney(depositDTO);
	}
	
	
	//Withdraw Money
	@PutMapping("customer/withdraw")
	public Account withdrawMoney(@RequestBody WithdrawDTO withdrawDTO)
	{
		return accService.withdrawMoney(withdrawDTO);
	}
	
	
	//Show Balance
	@PostMapping("customer/showBalance")
	public Account showBalance(@RequestBody ShowBalanceDTO showBalanceDTO)
	{
		return accService.showBalance(showBalanceDTO);
	}
	
	//Transfer Money
	@PutMapping("customer/transfer")
	public Account transferMoney(@RequestBody TransferDTO transferDTO)
	{
		return accService.transferMoney(transferDTO);
	}
}
