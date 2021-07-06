package com.cognizant.bank.feign;


import java.time.LocalDate;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.bank.model.Account;
import com.cognizant.bank.model.AccountCreationStatus;
import com.cognizant.bank.model.AccountInfo;
import com.cognizant.bank.model.Transaction;
import com.cognizant.bank.model.TransactionStatus;


@FeignClient(name = "account-ms", url = "${feign.url.account-ms}")
public interface AccountFeign {
	
	@PostMapping("/createAccount/{customerId}")
	public AccountCreationStatus createAccount(@RequestHeader("Authorization") String token,
	@PathVariable("customerId") String customerId, @RequestBody Account account);
	
	@PostMapping("/deposit")
	public TransactionStatus deposit(@RequestHeader("Authorization") String token, @RequestBody AccountInfo accountInfo);
	
	@PostMapping("/withdraw")
	public TransactionStatus withdraw(@RequestHeader("Authorization") String token, @RequestBody AccountInfo accountInfo);
	
	@GetMapping("/getCustomerAccounts/{customerId}")
	public List<Account> getCustomerAccounts(@RequestHeader("Authorization") String token, @PathVariable String customerId);
	
	@GetMapping("/getAccountStatement/{accountId}")
	public List<Transaction> getAccountStatement(@RequestHeader("Authorization") String token, @PathVariable long accountId, 
			@RequestParam(defaultValue = "#{T(java.time.LocalDate).now().minusMonths(1)}") LocalDate from_date, @RequestParam(defaultValue = "#{T(java.time.LocalDate).now()}") LocalDate to_date);
	
}
