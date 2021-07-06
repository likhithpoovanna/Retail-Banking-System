package com.cognizant.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cognizant.bank.feign.AccountFeign;
import com.cognizant.bank.feign.AuthFeign;
import com.cognizant.bank.feign.CustomerFeign;
import com.cognizant.bank.model.Account;
import com.cognizant.bank.model.AccountCreationStatus;
import com.cognizant.bank.model.AppUser;
import com.cognizant.bank.model.AuthenticationResponse;
import com.cognizant.bank.model.CustomerEntity;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class EmployeeService {
	
	@Autowired
	AuthFeign authFeign;
	
	@Autowired
	CustomerFeign custFeign;
	
	@Autowired
	AccountFeign accountFeign;
	
	
	public ResponseEntity<AppUser> authenticate(AppUser user){
		return authFeign.login(user);
	}
	
	public AuthenticationResponse hasPermission(String token) {
		return authFeign.getValidity(token);
	}
	
	public ResponseEntity<CustomerEntity> getCustomerDetails(String token, String id) {
		return custFeign.getCustomerDetails(token, id);
	}
	
	public ResponseEntity<AccountCreationStatus> createCustomer(String token, CustomerEntity customer) {
		return custFeign.createCustomer(token, customer);
	}
	
	public AccountCreationStatus createAccount(String token, String customerId, Account account) {
		return accountFeign.createAccount(token, customerId, account);
	}
	
	public ResponseEntity<String> deleteCustomer(String token, String customerId){
		return custFeign.deleteCustomer(token, customerId);
	}
	
	public int deductServiceCharge(String token) {
		return custFeign.deductServiceCharges(token);
	}
	
}
