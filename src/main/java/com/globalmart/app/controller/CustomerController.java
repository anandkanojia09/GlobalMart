package com.globalmart.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.globalmart.app.dto.Customer;
import com.globalmart.app.exception.GlobalMartException;
import com.globalmart.app.services.CustomerServices;


@RestController
public class CustomerController {


	@Autowired
	private CustomerServices customerService;


	@PostMapping("customer")
	public Customer addCustomer(@RequestBody Customer customer) throws GlobalMartException {
		return customerService.addCustomer(customer);
	}

	@GetMapping("customer/{id}")

	public Optional<Customer> getCustomer(@PathVariable("id") Integer id) throws GlobalMartException {
		return customerService.getCustomerById(id);
	}

	@PostMapping("customer/update")
	public Customer updateCustomer(@RequestBody Customer customer) throws GlobalMartException {
		return customerService.updateCustomerById(customer);
	}

	@DeleteMapping("customer/delete/{id}")
	public void deleteCustomerById(@PathVariable("id") Integer id) throws GlobalMartException {
		customerService.deleteCustomerById(id);
	}

	@GetMapping("customer/all")
	public List<Customer> getAllCustomers() throws GlobalMartException {
		return customerService.getAllCustomers();
	}

}
