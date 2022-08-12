package com.globalmart.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalmart.app.dao.CustomerRepo;
import com.globalmart.app.dto.CustomerDetails;
import com.globalmart.app.exception.CategoryException;

@Service
public class CustomerDetailsServicesImpl implements CustomerDetailsServices {
	
	@Autowired
	private CustomerRepo customerRepo;
    

	

	@Override
	public CustomerDetails addCustomer(CustomerDetails customer) {
		
		return this.customerRepo.save(customer);
	}




	@Override
	public Optional<CustomerDetails> getCustomer(Integer id) throws CategoryException {
		
		Optional<CustomerDetails> customer = customerRepo.findById(id);
		if(customer.isEmpty()) {
			throw new CategoryException("customer with customer id " + id + " does not exist");
		}
		return customer;
		
	}




	@Override
	public Boolean deleteCustomer(Integer id) throws CategoryException {
		 
		Boolean isdeleted=false;
		Optional<CustomerDetails> customer = getCustomer(id);
		if(customer!=null) {
			isdeleted=true;
			customerRepo.deleteById(id);
			
		}
		else {
			throw new CategoryException("Connot be deleteable");
		}
		
		return isdeleted;
		
	}




	@Override
	public CustomerDetails updateCustomer(CustomerDetails customer) throws CategoryException {
	
		Integer x = customer.getId();
		Optional<CustomerDetails> customer1  = getCustomer(x);
		if(customer1.isEmpty()) {
			throw new CategoryException("update not possible");
		}
		else {
			customerRepo.save(customer);
		}
		return customer;
	}




	@Override
	public List<CustomerDetails> getAllCustomerDetals() {
		List<CustomerDetails> allCustomers = customerRepo.findAll();
		
	      return allCustomers;
	}




	

}
