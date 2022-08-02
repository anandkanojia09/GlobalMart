package com.globalmart.app.services;

import java.util.List;
import java.util.Optional;

import com.globalmart.app.dto.CustomerDetails;
import com.globalmart.app.exception.GlobalMartException;

public interface ServicesInterface {

	public List<CustomerDetails> allCustomers() throws GlobalMartException;
	
	public Optional<CustomerDetails> getCustomerById(Integer id) throws GlobalMartException;
}
