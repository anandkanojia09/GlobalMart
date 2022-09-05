package com.globalmart.app.services;

import java.util.List;
import java.util.Optional;

import com.globalmart.app.dto.Customer;
import com.globalmart.app.exception.GlobalMartException;

/************************************************************************************
 *         @author          Anand Kumar Kanojia
 *         Description      It is a customer service interface that provides abstraction to the business logic and repository.
 *         Version          1.1
 *         Created Date     08-AUG-2022
 ************************************************************************************/
public interface CustomerServices {

	public Optional<Customer> getCustomerById(Integer id) throws GlobalMartException;
	
	public List<Customer> getCustomerByUserName(String userName) throws GlobalMartException; 

	public Customer addCustomer(Customer customer) throws GlobalMartException;

	public boolean deleteCustomerById(Integer id) throws GlobalMartException;

	public Customer updateCustomer(Customer customer) throws GlobalMartException;

	public List<Customer> getAllCustomers() throws GlobalMartException;

	public List<Customer> getCustomerByUserNameAndUserPassword(String name, String password) throws GlobalMartException;

}
