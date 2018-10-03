package com.devi.bank.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devi.bank.exceptions.AccountBalanceException;
import com.devi.bank.exceptions.AccountIdNotFoundException;
import com.devi.bank.exceptions.InsufficientFundException;
import com.devi.bank.exceptions.InvalidDetailsException;
import com.devi.bank.exceptions.PasswordDetailsWrongException;
import com.devi.bank.exceptions.UserNotFoundException;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(value=AccountIdNotFoundException.class)
	public String handleAccountIdNotFoundException(HttpServletRequest request,AccountIdNotFoundException exception) {
		
		request.setAttribute("errorname", exception);
		request.setAttribute("cause", exception.getCause());
		exception.printStackTrace();
		return "err";
	}
	@ExceptionHandler(value=UserNotFoundException.class)
	public String UserNotFoundException(HttpServletRequest request,UserNotFoundException exception) {
		
		request.setAttribute("errorname", exception);
		request.setAttribute("cause", exception.getCause());
		exception.printStackTrace();
		return "err";
	}
	@ExceptionHandler(value=AccountBalanceException.class)
	public String handleAccountBalanceException(HttpServletRequest request,AccountBalanceException exception) {
		
		request.setAttribute("errorname", exception);
		request.setAttribute("cause", exception.getCause());
		exception.printStackTrace();
		return "err";
	}
	@ExceptionHandler(value=InsufficientFundException.class)
	public String handleInsufficientFundException(HttpServletRequest request,InsufficientFundException exception) {
		
		request.setAttribute("errorname", exception);
		request.setAttribute("cause", exception.getCause());
		exception.printStackTrace();
		return "err";
	}
	@ExceptionHandler(value=InvalidDetailsException.class)
	public String handleInvalidDetailsException(HttpServletRequest request,InvalidDetailsException exception) {
		
		request.setAttribute("errorname", exception);
		request.setAttribute("cause", exception.getCause());
		exception.printStackTrace();
		return "err";
	}
	@ExceptionHandler(value=PasswordDetailsWrongException.class)
	public String handlePasswordDetailsWrongException(HttpServletRequest request,PasswordDetailsWrongException exception) {
		
		request.setAttribute("errorname", exception);
		request.setAttribute("cause", exception.getCause());
		exception.printStackTrace();
		return "err";
	}

}
