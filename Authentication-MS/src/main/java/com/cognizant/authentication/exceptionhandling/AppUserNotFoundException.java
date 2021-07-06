package com.cognizant.authentication.exceptionhandling;

/**
 * Class for handling APPUSER is not found exception
 * 
 * @author Pod-4
 *
 */
public class AppUserNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public AppUserNotFoundException() {
		super();
		// Empty Constructor
	}

	public AppUserNotFoundException(final String message) {
		/**
		 * Constructor for AppUserNotFoundException
		 */
		super(message);
	}
}