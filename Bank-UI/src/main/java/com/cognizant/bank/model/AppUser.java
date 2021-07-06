package com.cognizant.bank.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
	
	@NotBlank(message = "User ID is required.")
	private String userid;
	
	private String username;

	@NotBlank(message = "Password is required.")
	private String password;
	
	private String authToken;
	
	private String role;
}