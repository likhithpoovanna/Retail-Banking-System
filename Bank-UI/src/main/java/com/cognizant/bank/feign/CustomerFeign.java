package com.cognizant.bank.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cognizant.bank.model.AccountCreationStatus;
import com.cognizant.bank.model.CustomerEntity;


@FeignClient(name = "customer-ms", url = "${feign.url.customer-ms}")
public interface CustomerFeign {
	
	@GetMapping("/getCustomerDetails/{customerId}")
	public ResponseEntity<CustomerEntity> getCustomerDetails(@RequestHeader("Authorization") String token,@PathVariable String customerId);
	
	@PostMapping("/createCustomer")
	public ResponseEntity<AccountCreationStatus> createCustomer(@RequestHeader("Authorization") String token, @RequestBody CustomerEntity customer);
	
	@DeleteMapping("/deleteCustomer/{customerId}")
	@ResponseStatus(code=HttpStatus.OK)
	public ResponseEntity<String> deleteCustomer(@RequestHeader("Authorization") String token, @PathVariable String customerId);

	@GetMapping("/deductServiceCharges")
	public int deductServiceCharges(@RequestHeader("Authorization") String token);
	
}
