package com.cognizant.bank.feign;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.bank.model.AccountInfo;
import com.cognizant.bank.model.TransactionInput;
import com.cognizant.bank.model.TransactionStatus;


@FeignClient(name = "transaction-ms", url = "${feign.url.transaction-ms}")
public interface TranFeign {
	
	@PostMapping("/deposit")
	public TransactionStatus deposit(@RequestHeader("Authorization") String token, @RequestBody AccountInfo accountInfo);
	
	@PostMapping("/withdraw")
	public ResponseEntity<?> withdraw(@RequestHeader("Authorization") String token, @RequestBody AccountInfo accountInfo);
	
	@PostMapping(value = "/transfer")
	public ResponseEntity<TransactionStatus> makeTransfer(@RequestHeader("Authorization") String token,
			@Valid @RequestBody TransactionInput transactionInput);
}
