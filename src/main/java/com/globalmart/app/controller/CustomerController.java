package com.globalmart.app.controller;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.globalmart.app.dao.CustomerRepo;
import com.globalmart.app.dto.CustomerDetails;
import com.globalmart.app.exception.CategoryException;
import com.globalmart.app.service.CustomerDetailsServices;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private CustomerDetailsServices customerDetailsServices;

	@PostMapping("customer")
	public CustomerDetails addCustomer(@RequestBody CustomerDetails customer) throws CategoryException {
		
		if(customer==null) {
			throw new CategoryException("CustomerDetails could not added please provide essiential details");
		}
		    Optional<CustomerDetails> customerDetails = customerRepo.findById(customer.getId());
		    if(customerDetails.isPresent()) {
		    	throw new CategoryException("Already Exist");
		    	
		    }
		    else {
		return customerRepo.save(customer);
		    }
	}

	@GetMapping("customer/{id}")
	public Optional<CustomerDetails> getCustomer(@PathVariable("id") Integer id) throws CategoryException{
		
		//return customerRepo.findById(id);
		
		Optional<CustomerDetails> customer=null;
	       
			customer = customerDetailsServices.getCustomer(id);
	
	       return customer;
	}

	@PostMapping("customer/update")
	public CustomerDetails updateCustomer(@RequestBody CustomerDetails customer) {
		return customerRepo.save(customer);
	}

	@DeleteMapping("customer/delete/{id}")
	public void deleteCustomer(@PathVariable("id") Integer id) throws CategoryException {
		//customerRepo.deleteById(id);
		customerDetailsServices.deleteCustomer(id);
	}

//	@DeleteMapping("customer/delete")
//	public void deleteCustomer(@PathVariable CustomerDetails customer) {
//		customerRepo.delete(customer);
//	}
	
	@GetMapping("customers/all")
	public List<CustomerDetails> getAllCustomersDetails(){
		return customerDetailsServices.getAllCustomerDetals();
		
	}
	

}
