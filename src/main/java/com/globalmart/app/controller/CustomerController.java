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

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepo customerRepo;

	@PostMapping("customer")
	public CustomerDetails addCustomer(@RequestBody CustomerDetails customer) {
		return customerRepo.save(customer);
	}

	@GetMapping("customer/{id}")
	public Optional<CustomerDetails> getCustomer(@PathVariable("id") Integer id) {
		return customerRepo.findById(id);
	}

	@PostMapping("customer/update")
	public CustomerDetails updateCustomer(@RequestBody CustomerDetails customer) {
		return customerRepo.save(customer);
	}

	@DeleteMapping("customer/delete/{id}")
	public void deleteCustomer(@PathVariable("id") Integer id) {
		customerRepo.deleteById(id);
	}

	@DeleteMapping("customer/delete")
	public void deleteCustomer(@PathVariable CustomerDetails customer) {
		customerRepo.delete(customer);
	}

}
