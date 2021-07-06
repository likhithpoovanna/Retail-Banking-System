package com.cognizant.bank.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Account {

	private long accountId;

	@NotBlank(message = "Customer ID is required.")
	private String customerId;
	
	@NotNull(message = "Initial Balance is required. Enter 0 if null.")
	private double balance;
	
	@NotBlank(message = "Account Type is required.")
	private String accountType;
	
	@NotBlank(message = "Owner Name is required.")
	private String ownerName;


}
