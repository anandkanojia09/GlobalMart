package com.globalmart.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.globalmart.app.dao.CustomerRepo;
import com.globalmart.app.dto.CustomerDetails;
import com.globalmart.app.exception.OrderMartException;
/*
@RestController
public class CustomerController {

	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private CustomerServiceImplementation serviceImpl;

	@PostMapping("customer")
	public CustomerDetails addCustomer(@RequestBody CustomerDetails customer) {
		return serviceImpl.addCustomer(customer);
	}

	@GetMapping("customer/{id}")
	public Optional<CustomerDetails> getCustomer(@PathVariable("id") Integer id) throws OrderMartException {
//		return customerRepo.findById(id);
		return serviceImpl.getCustomerById(id);
	}

	@PostMapping("customer/update")
	public CustomerDetails updateCustomer(@RequestBody CustomerDetails customer) {
		return customerRepo.save(customer);
	}

	@DeleteMapping("customer/delete/{id}")
	public void deleteCustomerById(@PathVariable("id") Integer id) throws OrderMartException {
		serviceImpl.deleteCustomerById(id);
	}

}
*/
