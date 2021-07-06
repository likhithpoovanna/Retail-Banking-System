package com.cognizant.transactionservice.controller;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cognizant.transactionservice.exception.GlobalExceptionHandler;
import com.cognizant.transactionservice.exception.MinimumBalanceException;
import com.cognizant.transactionservice.models.TransactionStatus;
import com.cognizant.transactionservice.service.TransactionServiceImpl;
import com.cognizant.transactionservice.util.AccountInfo;
import com.cognizant.transactionservice.util.TransactionInput;

/**
 * 
 * @author Ajay
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class TransactionRestControllerTests {

	@Mock
	TransactionServiceImpl transactionService;

	@InjectMocks
	TransactionRestController transactionController;

	@InjectMocks
	TransactionStatus tran;

	/**
	 * 
	 * Test Minimum balance
	 *
	 */
	@Test
	public void minimumBal() throws MinimumBalanceException, Exception {
		MinimumBalanceException minimumBalanceException = new MinimumBalanceException();
		MinimumBalanceException minimumBalanceException2 = new MinimumBalanceException("Hi");
		assertNotEquals(minimumBalanceException, minimumBalanceException2);
		GlobalExceptionHandler handler = new GlobalExceptionHandler();

	}

	/**
	 * 
	 * Test Deposit
	 *
	 */
	@Test
	public void depositTest() {
		AccountInfo accInfo = new AccountInfo(1L, 1000);
		when(transactionService.makeDeposit("token", accInfo)).thenReturn(new TransactionStatus("Deposited.", 0, 0));
		assertEquals("Deposited.", transactionController.makeDeposit("token", accInfo).getBody().getMessage());
	}

	/**
	 * 
	 * Test Withdraw
	 *
	 */
	@Test
	public void withdrawTest() {
		AccountInfo accInfo = new AccountInfo(1L, 1000);
		when(transactionService.makeWithdraw("token", accInfo)).thenReturn(new TransactionStatus("Withdrawed.", 0, 0));
		assertEquals("Withdrawed.", transactionController.makeWithdraw("token", accInfo).getBody().getMessage());
	}

	/**
	 * 
	 * Test Transfer
	 *
	 */
	@Test
	public void transferTest() {
		TransactionInput tranInput = new TransactionInput(1L, 2L, 1000, "Transfer.");
		when(transactionService.makeTransfer("token", tranInput))
				.thenReturn(new TransactionStatus("Transfered.", 0, 0));
		assertEquals("Transfered.", transactionController.makeTransfer("token", tranInput).getBody().getMessage());
	}

	/**
	 * 
	 * Test Service Charge Deduction
	 *
	 */
	@Test
	public void deductTest() {
		AccountInfo accInfo = new AccountInfo(1L, 1000);
		when(transactionService.makeServiceCharges("token", accInfo))
				.thenReturn(new TransactionStatus("Service Charge.", 0, 0));
		assertEquals("Service Charge.",
				((TransactionStatus) transactionController.deduct("token", accInfo).getBody()).getMessage());
	}

}