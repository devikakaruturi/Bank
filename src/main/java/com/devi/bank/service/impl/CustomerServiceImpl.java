package com.devi.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.devi.bank.dao.CustomerDao;
import com.devi.bank.exceptions.InvalidDetailsException;
import com.devi.bank.exceptions.PasswordDetailsWrongException;
import com.devi.bank.exceptions.UserNotFoundException;
import com.devi.bank.model.Customer;
import com.devi.bank.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;

	@Override
	public Customer authenticate(Customer customer) throws UserNotFoundException{
		// TODO Auto-generated method stub
		try {
			return customerDao.authenticate(customer);
		}
		catch (DataAccessException ex) {
			UserNotFoundException uex = new UserNotFoundException("no user found");
			uex.initCause(ex);
			throw uex;
		}

	}

	@Override
	public Customer updateProfile(Customer customer) throws InvalidDetailsException{
		// TODO Auto-generated method stub
		try {
			return customerDao.updateProfile(customer);

		} catch (DataAccessException ex) {
			// TODO: handle exception
			InvalidDetailsException ix = new InvalidDetailsException("details invalid");
			ix.initCause(ex);
			throw ix;
			
		}
	}

	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword)throws PasswordDetailsWrongException {
		// TODO Auto-generated method stub
		try {
			return customerDao.updatePassword(customer, oldPassword, newPassword);
			
		} catch (DataAccessException dx) {
			// TODO: handle exception
			PasswordDetailsWrongException px = new PasswordDetailsWrongException("wrong credentials");
			px.initCause(dx);
			throw px;
		}
		
	}

}
