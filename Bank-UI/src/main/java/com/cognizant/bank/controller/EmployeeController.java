package com.cognizant.bank.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cognizant.bank.model.Account;
import com.cognizant.bank.model.AccountCreationStatus;
import com.cognizant.bank.model.AppUser;
import com.cognizant.bank.model.CustomerEntity;
import com.cognizant.bank.service.EmployeeService;


@Controller
@SessionAttributes({"empToken","userid"})
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@PostMapping("/authenticateEmployee")
	public String authCustomer(@Valid @ModelAttribute("user") AppUser user, BindingResult result, Model model) {
		
		if(result.hasErrors())
		{
			model.addAttribute("role","Employee");
			return "login";
		}
		try {
			
			if(!(user.getUserid().toUpperCase().startsWith("EMP"))) {
				throw new Exception();
			}
			
			String empToken = empService.authenticate(user).getBody().getAuthToken();
			model.addAttribute("userid",user.getUserid());
			model.addAttribute("empToken", empToken);
			Object customer = empService.getCustomerDetails((String)model.getAttribute("empToken"), user.getUserid()).getBody();
			model.addAttribute("customer",customer);
			return "employeedashboard";
		}
		catch (Exception e) {
			model.addAttribute("role","Employee");
			model.addAttribute("message","Invalid Credentials.");
			return "login";
		}
		
	}
	
	@GetMapping("/show-employeedashboard")
	public String showEmployeeDashboard(Model model) {
		try {
			empService.hasPermission((String)model.getAttribute("empToken"));
		}
		catch (Exception ex) {

			AppUser user = new AppUser();
			model.addAttribute("user",user);
			model.addAttribute("role","Employee");
			return "login";
		}
		Object customer = empService.getCustomerDetails((String)model.getAttribute("empToken"), (String)model.getAttribute("userid")).getBody();
		model.addAttribute("customer",customer);
		return "employeedashboard";
	}
	
	@GetMapping("/show-createcustomer")
	public String showCreateCustomer(Model model) {
		try {
			empService.hasPermission((String)model.getAttribute("empToken"));
		}
		catch (Exception ex) {

			AppUser user = new AppUser();
			model.addAttribute("user",user);
			model.addAttribute("role","Employee");
			
			return "login";
		}
		model.addAttribute("customer",new CustomerEntity());
		return "createcustomer";
	}
	
	@PostMapping("/createCustomer")
	public String createCustomer(@Valid @ModelAttribute("customer") CustomerEntity customer, BindingResult result, Model model) {
		
		if(result.hasErrors())
		{
			return "createcustomer";
		}
		
		try {
			AccountCreationStatus status = empService.createCustomer((String) model.getAttribute("empToken"), customer).getBody(); 
			model.addAttribute("message","Customer with Id \""+customer.getUserid()+"\" successfully created. Account Id \""+status.getAccountId()+"\".");
			
		}
		catch (Exception e) {
			model.addAttribute("message","Customer Id already exists.");
		}
		return "createcustomer";
	}
	
	
	@GetMapping("/show-createaccountforcustomer")
	public String showCreateCustomerAccount(Model model) {
		try {
			empService.hasPermission((String)model.getAttribute("empToken"));
		}
		catch (Exception ex) {

			AppUser user = new AppUser();
			model.addAttribute("user",user);
			model.addAttribute("role","Employee");
			return "login";
		}
		model.addAttribute("account",new Account());
		return "createaccountforcustomer";
	}
	
	@PostMapping("/createAccount")
	public String createAccount(@Valid @ModelAttribute("account") Account account, BindingResult result, Model model) {
		if(result.hasErrors())
		{
			return "createaccountforcustomer";
		}
		try {
			CustomerEntity customer = empService.getCustomerDetails((String)model.getAttribute("empToken"), account.getCustomerId()).getBody();
			
			AccountCreationStatus accStatus = empService.createAccount((String)model.getAttribute("empToken"), ((Account)model.getAttribute("account")).getCustomerId(), account);
			model.addAttribute("message","Account for Customer with Id \""+account.getCustomerId()+"\" successfully created. Account Number: \""+accStatus.getAccountId()+"\".");
		}
		catch (Exception e) {
			model.addAttribute("message","Customer Id doesn't exist.");
		}
		return "createaccountforcustomer";
	}
	
	@GetMapping("/show-deletecustomer")
	public String showDeleteCustomer(Model model) {
		try {
			empService.hasPermission((String)model.getAttribute("empToken"));
		}
		catch (Exception ex) {

			AppUser user = new AppUser();
			model.addAttribute("user",user);
			model.addAttribute("role","Employee");
			return "login";
		}
//		model.addAttribute("customerId", "");
		return "deletecustomer";
	}
	
	@PostMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") String customerId, Model model) {
		try {
		String status = empService.deleteCustomer((String)model.getAttribute("empToken"), customerId).getStatusCode().toString();
		model.addAttribute("message","Customer with Id \""+customerId+"\" successfully deleted.");
		}
		catch (Exception e) {
			model.addAttribute("message","Customer Id doesn't exist.");
		}
		return "deletecustomer";
	}
	
	@GetMapping("/show-viewthecustomer")
	public String showViewTheCustomer(Model model) {
		try {
			empService.hasPermission((String)model.getAttribute("empToken"));
		}
		catch (Exception ex) {

			AppUser user = new AppUser();
			model.addAttribute("user",user);
			model.addAttribute("role","Employee");
			return "login";
		}
		return "viewthecustomer";
	}
	
	@GetMapping("/viewthecustomer")
	public String viewTheCustomer(@RequestParam("customerId") String customerId, Model model) {
		String custId = customerId;
		try {

			if(!(customerId.toUpperCase().startsWith("CUST"))) {
				throw new Exception();
			}
			
			Object customer = empService.getCustomerDetails((String)model.getAttribute("empToken"), custId).getBody();
			model.addAttribute("customer",customer);
			model.addAttribute("show",true);
		}
		catch (Exception e) {
			model.addAttribute("message","Customer Id doesn't exist.");
		}
		return "viewthecustomer";
	}
	
	@GetMapping("/show-servicechargededuction")
	public String showServiceChargeDeduction(Model model) {
		try {
			empService.hasPermission((String)model.getAttribute("empToken"));
		}
		catch (Exception ex) {

			AppUser user = new AppUser();
			model.addAttribute("user",user);
			model.addAttribute("role","Employee");
			return "login";
		}
		return "servicechargededuction";
	}
	
	@GetMapping("/deductServiceCharges")
	public String deductServiceCharge(Model model) {
		int count = empService.deductServiceCharge((String)model.getAttribute("empToken"));
		if(count==0) {
			model.addAttribute("message","All accounts are maintaining minimum balance.");
		}
		else {
			model.addAttribute("message","Service Charges are deducted from "+count+" accounts for not maintaining minimum balance.");
		}
		
		return "servicechargededuction";
	}

}
