package com.cognizant.bank.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
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
import com.cognizant.bank.model.AccountInfo;
import com.cognizant.bank.model.AppUser;
import com.cognizant.bank.model.Transaction;
import com.cognizant.bank.model.TransactionInput;
import com.cognizant.bank.model.TransactionStatus;
import com.cognizant.bank.service.CustomerService;


@Controller

@SessionAttributes({"custToken","userid"})

public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	
	@PostMapping("/authenticateCustomer")
	public String authCustomer(@Valid @ModelAttribute("user") AppUser user, BindingResult result, Model model) {
		
		if(result.hasErrors())
		{
			model.addAttribute("role","Customer");
			return "login";
		}
		try {

			if(!(user.getUserid().toUpperCase().startsWith("CUST"))) {
				throw new Exception();
			}
			
		String custToken = customerService.authenticate(user).getBody().getAuthToken();
		
		model.addAttribute("custToken", custToken);
		model.addAttribute("userid",user.getUserid());
		

 		Object customer = customerService.getCustomerDetails((String)model.getAttribute("custToken"), user.getUserid()).getBody();
		model.addAttribute("customer",customer);
		return "customerdashboard";
		}
		catch (Exception e) {
			model.addAttribute("role","Customer");
			model.addAttribute("message","Invalid Credentials.");
			return "login";
		}
	}
	
	
	@GetMapping("/show-customerdashboard")
	public String showCustomerDashboard(Model model) {
		try {
			customerService.hasPermission((String)model.getAttribute("custToken"));
		}
		catch (Exception ex) {

			AppUser user = new AppUser();
			model.addAttribute("user",user);
			model.addAttribute("role","Customer");
			return "login";
		}
		Object customer = customerService.getCustomerDetails((String)model.getAttribute("custToken"), (String)model.getAttribute("userid")).getBody();
		model.addAttribute("customer",customer);
		return "customerdashboard";
	}
	
	@GetMapping("/show-accounts")
	public String showAccounts(Model model) {
		try {
			customerService.hasPermission((String)model.getAttribute("custToken"));
		}
		catch (Exception ex) {
			AppUser user = new AppUser();
			model.addAttribute("user",user);
			model.addAttribute("role","Customer");
			return "login";
		}
		List<Account> accList = customerService.getCustomerAccounts((String)model.getAttribute("custToken"), (String)model.getAttribute("userid"));
		model.addAttribute("accList",accList);
		return "customeraccounts";
	}
	
    @GetMapping("/show-deposit")
	public String showDeposit(Model model) {
    	try {
    		customerService.hasPermission((String)model.getAttribute("custToken"));
    	}
		catch (Exception ex) {
			AppUser user = new AppUser();
			model.addAttribute("user",user);
			model.addAttribute("role","Customer");
			return "login";
		}
		model.addAttribute("accountInfo", new AccountInfo());
		return "deposit";
	}
    
    @PostMapping("/deposit")
    public String deposit(@Valid @ModelAttribute AccountInfo accountInfo, BindingResult result, Model model) {
    	if(result.hasErrors())
		{
			return "deposit";
		}
    	if(customerService.checkAccount((String) model.getAttribute("custToken"), (String) model.getAttribute("userid"), accountInfo.getAccountId())) {
    		TransactionStatus status = customerService.makeDeposit((String) model.getAttribute("custToken"), accountInfo);
    		try {
    		model.addAttribute("message","Deposit of "+accountInfo.getBalance()+" to Account with Id "+accountInfo.getAccountId()+" is successful.");
    	}
    	catch (Exception ex) {
    		model.addAttribute("message","Transfer Unsuccessful.");
    	}
    		return "deposit";
    	}
    	else {
    		model.addAttribute("message","Account doesn't belong to you.");
    		return "deposit";
    	}
    }
    
    @GetMapping("/show-withdraw")
	public String showWithdraw(Model model) {
    	try {
    		customerService.hasPermission((String)model.getAttribute("custToken"));
    	}
		catch (Exception ex) {
			AppUser user = new AppUser();
			model.addAttribute("user",user);
			model.addAttribute("role","Customer");
			return "login";
		}
		model.addAttribute("accountInfo", new AccountInfo());
		return "withdraw";
	}
    
    @PostMapping("/withdraw")
    public String withdraw(@Valid @ModelAttribute AccountInfo accountInfo, BindingResult result, Model model) {
    	if(result.hasErrors())
		{
			return "withdraw";
		}
    	if(customerService.checkAccount((String) model.getAttribute("custToken"), (String) model.getAttribute("userid"), accountInfo.getAccountId())) {
    		try {
    		ResponseEntity<?> status = (ResponseEntity<?>) customerService.makeWithdrawal((String) model.getAttribute("custToken"), accountInfo);
    		model.addAttribute("message","Withdrawal of "+accountInfo.getBalance()+" from Account with Id "+accountInfo.getAccountId()+" is successful.");
    	}
    	catch (Exception ex) {
    		model.addAttribute("message","Transfer Unsuccessful.");
    	}
    		return "withdraw";
    	}
    	else {
    		model.addAttribute("message","Account doesn't belong to you.");
    		return "withdraw";
    	}
    }
    
    @GetMapping("/show-transfer")
	public String showTransfer(Model model) {
    	try {
    		customerService.hasPermission((String)model.getAttribute("custToken"));
    	}
		catch (Exception ex) {
			AppUser user = new AppUser();
			model.addAttribute("user",user);
			model.addAttribute("role","Customer");
			return "login";
		}
		model.addAttribute("tranInput", new TransactionInput());
		return "transfer";
	}
    
    @PostMapping("/transfer")
    public String transfer(@Valid @ModelAttribute("tranInput") TransactionInput tranInput, BindingResult result, Model model) {
    	if(result.hasErrors())
		{
			return "transfer";
		}
    	if(customerService.checkAccount((String) model.getAttribute("custToken"), (String) model.getAttribute("userid"), tranInput.getSourceAccount())) {
	    		
	    	customerService.hasPermission((String)model.getAttribute("custToken"));
	    	try {
	    		Object status = customerService.makeTransfer((String) model.getAttribute("custToken"), tranInput).getBody();
				model.addAttribute("message","Transfer of "+tranInput.getAmount()+" from Account with Id "+tranInput.getSourceAccount()+" to Account with Id "+tranInput.getTargetAccount()+" is successful.");
	    	}
	    	catch (Exception ex) {
	    		model.addAttribute("message","Transfer Unsuccessful.");
	    	}
			return "transfer";
    	}
    	else {
    		model.addAttribute("message","Account doesn't belong to you.");
    		return "transfer";
    	}
    }
    
    @GetMapping("/show-transactionaldetails")
	public String showTransactionalDetails(@ModelAttribute TransactionInput tranInput, Model model) {
    	try {
    		customerService.hasPermission((String)model.getAttribute("custToken"));
    	}
		catch (Exception ex) {
			AppUser user = new AppUser();
			model.addAttribute("user",user);
			model.addAttribute("role","Customer");
			return "login";
		}
		return "transactionaldetails";
	}
    
    @GetMapping("/transactiondetails")
    public String transactionDetails(@RequestParam("accountId") long accountId, @RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate, Model model) {
    	
    	if(customerService.checkAccount((String) model.getAttribute("custToken"), (String) model.getAttribute("userid"), accountId)) {
    		LocalDate from_Date;
    		LocalDate to_Date;
    		if(fromDate.equals("") || toDate.equals("")) {
    			from_Date = null;
    			to_Date = null;
	    	}
	    	else {
	    		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    		from_Date = LocalDate.parse(fromDate,format);
	    		to_Date = LocalDate.parse(toDate,format);
	    	}
	    	List<Transaction> tranList = customerService.getTransactions((String) model.getAttribute("custToken"), accountId, from_Date, to_Date);
	    	if(tranList.size()>0) {
	    		model.addAttribute("tranList", tranList);
		    	model.addAttribute("show",true);
		    	return "transactionaldetails";
	    	}
	    	else {
	    		model.addAttribute("message","No transactions between the specified dates.");
	    		return "transactionaldetails";
	    	}
	    	
    	}
    	else {
    		model.addAttribute("message","Account doesn't belong to you.");
    		return "transactionaldetails";
    	}
    }
    
    
    

}
