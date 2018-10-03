package com.devi.bank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devi.bank.exceptions.AccountIdNotFoundException;
import com.devi.bank.model.Customer;
import com.devi.bank.service.BankAccountService;
import com.devi.bank.service.CustomerService;

@Controller
public class BankController {

	
	@Autowired
	BankAccountService bankAccountService;
	@RequestMapping("balanceEnquiry.do")
	public String getBalanceEnquiryPage()
	{
		return "balanceEnquiry";
	}
	
	@RequestMapping("fundTransfer")
	public String getfundTransferPage ()
	{
		return "fundTransfer";
	}
	
	@RequestMapping("fundTransfer.do")
	public String fundTransfer (HttpSession session,HttpServletRequest request, @RequestParam long payeeAccountNumber,@RequestParam double amount) throws AccountIdNotFoundException
	{
		session = request.getSession();
		Customer customer= (Customer) session.getAttribute("customer");
		
		bankAccountService.fundTransfer(customer.getBankAccount().getAccountId(), payeeAccountNumber, amount);
		
		return "transferSuccess";
	}
	
}
