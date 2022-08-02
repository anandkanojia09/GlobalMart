package com.globalmart.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalmart.app.dao.CustomerRepo;
import com.globalmart.app.dto.CustomerDetails;
import com.globalmart.app.exception.GlobalMartException;

@Service
public class ServiceImplementation implements ServicesInterface {

	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public List<CustomerDetails> allCustomers() throws GlobalMartException {
		List<CustomerDetails> custD = customerRepo.findAll();
		return custD;
	}

	@Override
	public Optional<CustomerDetails> getCustomerById(Integer id) throws GlobalMartException {
		Optional<CustomerDetails> customerD = customerRepo.findById(id);
		if(customerD.isEmpty()) {
			throw new GlobalMartException("User with user id "+id+" does not exist");
		}
		return customerD;
	}

}
