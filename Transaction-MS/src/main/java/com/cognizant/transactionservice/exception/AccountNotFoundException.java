package com.cognizant.transactionservice.exception;

/**
 * 
 * @author Ajay
 *
 *         Account Not Found Exception Class Implementation
 *
 */

public class AccountNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AccountNotFoundException() {
		super();
	}

	public AccountNotFoundException(String message) {
		super(message);
	}

}
