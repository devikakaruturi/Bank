package com.devi.bank.service;

import com.devi.bank.exceptions.InvalidDetailsException;
import com.devi.bank.exceptions.PasswordDetailsWrongException;
import com.devi.bank.exceptions.UserNotFoundException;
import com.devi.bank.model.Customer;

public interface CustomerService {
	public Customer authenticate(Customer customer) throws UserNotFoundException;
	public Customer updateProfile(Customer customer) throws InvalidDetailsException;
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) throws PasswordDetailsWrongException;

}
