package com.cognizant.transactionservice.controller;

import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.transactionservice.feign.AccountFeign;
import com.cognizant.transactionservice.feign.RulesFeign;
import com.cognizant.transactionservice.models.Transaction;
import com.cognizant.transactionservice.models.TransactionStatus;
import com.cognizant.transactionservice.service.TransactionService;
import com.cognizant.transactionservice.util.AccountInfo;
import com.cognizant.transactionservice.util.TransactionInput;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Ajay
 *
 */

@Slf4j
@RestController
public class TransactionRestController {

	public static final String METHOD_FOR_MAKETRANSFER = "AccountFallbackForTransfer";
	public static final String METHOD_FOR_MAKEWITHDRAW = "AccountFallbackForWithdraw";
	public static final String METHOD_FOR_MAKEDEPOSIT = "AccountFallbackForDeposit";

	@Autowired
	AccountFeign accountFeign;

	@Autowired
	RulesFeign rulesFeign;

	@Autowired
	TransactionService transactionService;

	/**
	 * Deposits the Amount
	 * 
	 * @param AccountID ------ Input ()
	 * @param amount    ------ Input ()
	 * @return Transaction Status and HttpStatus.OK ------ Output ()
	 */

	@PostMapping(value = "/deposit")
	public ResponseEntity<TransactionStatus> makeDeposit(@RequestHeader("Authorization") String token,
			@Valid @RequestBody AccountInfo accountInfo) {

		transactionService.hasPermission(token);

		TransactionStatus tranStatus = transactionService.makeDeposit(token, accountInfo);
		return new ResponseEntity<>(tranStatus, HttpStatus.OK);
	}

	/**
	 * Withdraw the Amount
	 * 
	 * @param AccountID ------ Input ()
	 * @param amount    ------ Input ()
	 * @return Transaction Status and HttpStatus.OK ------ Output ()
	 */

	@PostMapping(value = "/withdraw")
	public ResponseEntity<TransactionStatus> makeWithdraw(@RequestHeader("Authorization") String token,
			@Valid @RequestBody AccountInfo accountInfo) {

		transactionService.hasPermission(token);

		TransactionStatus tranStatus = transactionService.makeWithdraw(token, accountInfo);
		return new ResponseEntity<>(tranStatus, HttpStatus.OK);
	}

	/**
	 * Deduct the Amount For Service Charge
	 * 
	 * @param AccountID ------ Input ()
	 * @param amount    ------ Input ()
	 * @return Transaction Status and HttpStatus.OK ------ Output ()
	 */

	@PostMapping(value = "/deduct")
	public ResponseEntity<TransactionStatus> deduct(@RequestHeader("Authorization") String token,
			@Valid @RequestBody AccountInfo accountInfo) {

		transactionService.hasPermission(token);

		TransactionStatus tranStatus = transactionService.makeServiceCharges(token, accountInfo);
		return new ResponseEntity<>(tranStatus, HttpStatus.OK);
	}

	/**
	 * Transfer the Amount
	 * 
	 * @param Source_AccountID ------ Input ()
	 * @param Target_AccountID ------ Input ()
	 * @param amount           ------ Input ()
	 * @return Transaction Status and HttpStatus.OK ------ Output ()
	 */

	@PostMapping(value = "/transfer")
	public ResponseEntity<TransactionStatus> makeTransfer(@RequestHeader("Authorization") String token,
			@Valid @RequestBody TransactionInput transactionInput) {

		transactionService.hasPermission(token);

		log.info("inside transaction method");
		if (transactionInput != null) {
			TransactionStatus tranStatus = transactionService.makeTransfer(token, transactionInput);

			return new ResponseEntity<>(tranStatus, HttpStatus.OK);
		} else {
			return null;
		}
	}

	/**
	 * Get Account Statement (AccountFeign)
	 * 
	 * @param AccountID ------ Input ()
	 * @param from_date ------ Input ()
	 * @param to_date   ------ Input ()
	 * @return Transaction Statements ------ Output ()
	 */

	@GetMapping(value = "/getAllTransByAccIdAndDate/{accountId}")
	public List<Transaction> getTransactionsByAccIdAndDate(@RequestHeader("Authorization") String token,
			@PathVariable("accountId") long accId, @RequestParam LocalDate from_date, @RequestParam LocalDate to_date) {

		transactionService.hasPermission(token);

		List<Transaction> tranList = transactionService.getTransactionsByAccIdAndDate(accId, from_date, to_date);
		return tranList;
	}

}
