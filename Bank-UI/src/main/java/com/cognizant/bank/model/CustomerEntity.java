package com.cognizant.bank.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {

	@NotBlank(message = "User ID is required.")
	private String userid;
	
	@NotBlank(message = "Username is required.")
	private String username;
	
	@NotBlank(message = "Password is required.")
	private String password;
	
	//@DateTimeFormat(pattern = "dd-MM-yyyy")
	@NotNull(message="Birth Date is required.")
	private Date dateOfBirth;
	
	@NotBlank(message = "Pan No is required.")
	@Size(min = 10, max = 10, message = "Pan No should be of 10 characters.")
	private String pan_no;
	
	@NotBlank(message = "Address is required.")
	private String address;
	
}
