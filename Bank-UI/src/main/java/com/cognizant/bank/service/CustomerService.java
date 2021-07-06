package com.cognizant.bank.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.bank.feign.AccountFeign;
import com.cognizant.bank.feign.AuthFeign;
import com.cognizant.bank.feign.CustomerFeign;
import com.cognizant.bank.feign.TranFeign;
import com.cognizant.bank.model.Account;
import com.cognizant.bank.model.AccountCreationStatus;
import com.cognizant.bank.model.AccountInfo;
import com.cognizant.bank.model.AppUser;
import com.cognizant.bank.model.AuthenticationResponse;
import com.cognizant.bank.model.CustomerEntity;
import com.cognizant.bank.model.Transaction;
import com.cognizant.bank.model.TransactionInput;
import com.cognizant.bank.model.TransactionStatus;

import lombok.extern.slf4j.Slf4j;



@Service
public class CustomerService {
	
	@Autowired
	AuthFeign authFeign;
	
	@Autowired
	CustomerFeign custFeign;
	
	@Autowired
	AccountFeign accFeign;

	@Autowired
	TranFeign tranFeign;
	
	
	
	public ResponseEntity<AppUser> authenticate(AppUser user){
		return authFeign.login(user);
	}
	
	public AuthenticationResponse hasPermission(String token) {
		return authFeign.getValidity(token);
	}
	
	public ResponseEntity<?> getCustomerDetails(String token, String id) {
		return custFeign.getCustomerDetails(token, id);
	}
	public List<Account> getCustomerAccounts(String token, String customerId){
		return accFeign.getCustomerAccounts(token, customerId);
	}
	
	public ResponseEntity<?> createCustomer(String token, CustomerEntity customer) {
		return custFeign.createCustomer(token, customer);
	}
	
	public boolean checkAccount(String token, String customerId, long accountId) {
		List<Account> accList =  accFeign.getCustomerAccounts(token, customerId);
		for(Account acc : accList) {
			if(acc.getAccountId() == accountId) {
				return true;
			}
		}
		return false;
	}
	
	public TransactionStatus makeDeposit(String token, AccountInfo accountInfo) {
		return tranFeign.deposit(token, accountInfo);
	}
	
	public ResponseEntity<?> makeWithdrawal(String token, AccountInfo accountInfo) {
		return tranFeign.withdraw(token, accountInfo);
	}
	
	public ResponseEntity<TransactionStatus> makeTransfer(String token, TransactionInput input) {
		return tranFeign.makeTransfer(token, input);
	}
	
	public List<Transaction> getTransactions(String token, long accountId, LocalDate fromDate, LocalDate toDate){
		return accFeign.getAccountStatement(token, accountId, fromDate, toDate);
	}
	
}
