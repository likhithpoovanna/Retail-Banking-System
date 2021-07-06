package com.cognizant.transactionservice.exception;

/**
 * 
 * @author Ajay
 *
 *         Insufficient Balance Exception Class
 *
 */

public class InsufficientBalanceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InsufficientBalanceException() {
		super();
	}

	public InsufficientBalanceException(String message) {
		super(message);
	}

}
