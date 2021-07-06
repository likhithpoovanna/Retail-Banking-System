package com.cognizant.bank.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionInput {

	@NotNull(message = "Source Account Id is required.")
	@Min(value = 1, message = "Account Id has to be a positive number.")
	private long sourceAccount;

	@NotNull(message = "Target Account Id is required.")
	@Min(value = 1, message = "Account Id has to be a positive number.")
	private long targetAccount;

	@Positive(message = "Transfer amount cannot be negative.")
	@Min(value = 1, message = "Amount must be greater than 1.")
	private double amount;

	private String typeOfTrasaction;

	
}