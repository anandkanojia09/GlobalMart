package com.globalmart.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalmart.app.dao.CustomerRepo;
import com.globalmart.app.dto.Customer;
import com.globalmart.app.exception.GlobalMartException;

@Service
public class CustomerServiceImpl implements CustomerServices {

	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Optional<Customer> getCustomerById(Integer id) throws GlobalMartException {
		Optional<Customer> customer = customerRepo.findById(id);
		if (customer.isEmpty()) {
			throw new GlobalMartException("User with user id " + id + " does not exist");
		}
		return customer;
	}

	@Override
	public Customer addCustomer(Customer customer) throws GlobalMartException {
		if (customer == null)
			throw new GlobalMartException("Feilds cannot be left empty. Please fill in the necesaary details.");
		customer = customerRepo.save(customer);
		if (customer == null) {
			throw new GlobalMartException("Customer could not be added!! Try again.");
		}
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws GlobalMartException {
		if (customer == null) {
			throw new GlobalMartException("Provide details to update");
		}
		int x = customer.getId();
		if (customerRepo.existsById(x)) {
			customer = customerRepo.save(customer);
			if (customer == null) {
				throw new GlobalMartException("Updation Failed!! Try again");
			}
		} else {
			throw new GlobalMartException("No customer with the provided data exists to be updated!! ");
		}
		return customer;
	}

	@Override
	public boolean deleteCustomerById(Integer id) throws GlobalMartException {
		boolean flag = true;
		if (customerRepo.existsById(id)) {
			customerRepo.deleteById(id);
			if (customerRepo.existsById(id)) {
				flag = false;
				throw new GlobalMartException("User not deleted");
			}
		} else {
			flag = false;
			throw new GlobalMartException("No customer with id " + id + " exists to be deleted ");
		}
		return flag;
	}

	@Override
	public List<Customer> getAllCustomers() throws GlobalMartException {
		List<Customer> allCustomers = customerRepo.findAll();
		if (allCustomers.isEmpty()) {
			throw new GlobalMartException("No customers yet!!");
		}
		return allCustomers;
	}

	@Override
	public List<Customer> getCustomerByNameAndPassword(String name, String password) throws GlobalMartException {
		List<Customer> customer = new ArrayList<>();
		if (name == null || password == null) {
			throw new GlobalMartException("Name and password are required!! ");
		}
		customer = customerRepo.findByCustomerNameAndPassword(name, password);
		if (customer.isEmpty())
			throw new GlobalMartException("No customer with the provided data. Try again with correct details.");
		return customer;
	}

}
