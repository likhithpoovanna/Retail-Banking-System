package com.cognizant.bank.model;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AccountInfo {
	
	@NotNull(message = "Account Id is required.")
	@Min(value = 1, message = "Account Id has to be a positive number.")
	private long accountId;
	
	@NotNull(message = "Amount is required.")
	@Min(value = 1, message = "Amount has to be a positive number.")
	private double balance;
	


}
