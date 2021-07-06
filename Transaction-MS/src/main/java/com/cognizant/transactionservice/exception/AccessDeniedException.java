package com.cognizant.transactionservice.exception;

/**
 * 
 * @author Ajay
 *
 *         Access Denied Exception Class
 *
 */

public class AccessDeniedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AccessDeniedException() {
		super();
	}

	public AccessDeniedException(String message) {
		super(message);
	}

}
