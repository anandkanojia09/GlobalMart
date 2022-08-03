package com.globalmart.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalmart.app.dao.CustomerRepo;
import com.globalmart.app.dto.CustomerDetails;
import com.globalmart.app.exception.GlobalMartException;

@Service
public class CustomerServiceImpl implements CustomerServices {

	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Optional<CustomerDetails> getCustomerById(Integer id) throws GlobalMartException {
		Optional<CustomerDetails> customer = customerRepo.findById(id);
		if (customer.isEmpty()) {
			throw new GlobalMartException("User with user id " + id + " does not exist");
		}
		return customer;
	}

	@Override
	public CustomerDetails addCustomer(CustomerDetails customer) throws GlobalMartException {
		try {
			customerRepo.save(customer);
		} catch (Exception e) {
			throw new GlobalMartException(e.getMessage());
		}
		return customer;
	}

	@Override
	public CustomerDetails updateCustomerById(CustomerDetails customer) throws GlobalMartException {
		int x = customer.getId();
		if (customerRepo.existsById(x)) {
			customerRepo.save(customer);
		} else {
			throw new GlobalMartException("No customer with data exists to be updated!! ");
		}
		return customer;
	}

	@Override
	public void deleteCustomerById(Integer id) throws GlobalMartException {
		if (customerRepo.existsById(id)) {
			customerRepo.deleteById(id);
			if (customerRepo.existsById(id)) {
				throw new GlobalMartException("User not deleted");
			}
		} else {
			throw new GlobalMartException("No customer with id " + id + " exists to be deleted ");
		}
	}

	@Override
	public List<CustomerDetails> getAllCustomers() throws GlobalMartException {
		List<CustomerDetails> allCustomers = customerRepo.findAll();
		if (allCustomers.isEmpty()) {
			throw new GlobalMartException("No customers yet!!");
		}
		return allCustomers;
	}
}
