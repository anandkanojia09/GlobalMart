package com.globalmart.app.services;

import java.util.List;
import java.util.Optional;

import com.globalmart.app.dto.Customer;
import com.globalmart.app.exception.GlobalMartException;

public interface CustomerServices {

	public Optional<Customer> getCustomerById(Integer id) throws GlobalMartException;

	public Customer addCustomer(Customer customer) throws GlobalMartException;

	public boolean deleteCustomerById(Integer id) throws GlobalMartException;

	public Customer updateCustomer(Customer customer) throws GlobalMartException;

	public List<Customer> getAllCustomers() throws GlobalMartException;

	public List<Customer> getCustomerByNameAndPassword(String name, String password) throws GlobalMartException;

}
