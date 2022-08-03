package com.globalmart.app.services;

import java.util.List;
import java.util.Optional;

import com.globalmart.app.dto.CustomerDetails;
import com.globalmart.app.exception.GlobalMartException;

public interface CustomerServices {

	public Optional<CustomerDetails> getCustomerById(Integer id) throws GlobalMartException;

	public CustomerDetails addCustomer(CustomerDetails customer) throws GlobalMartException;

	public void deleteCustomerById(Integer id) throws GlobalMartException;

	public CustomerDetails updateCustomerById(CustomerDetails customer) throws GlobalMartException;

	public List<CustomerDetails> getAllCustomers() throws GlobalMartException;
}
