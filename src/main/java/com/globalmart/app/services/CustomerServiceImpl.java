package com.globalmart.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalmart.app.dao.CustomerRepo;
import com.globalmart.app.dto.Customer;
import com.globalmart.app.exception.GlobalMartException;

/************************************************************************************
 * @author 		Anand Kumar Kanojia 
 * Description  It is a service class that provides
 *         		the operations for customer class like add customer, get customer,
 *        		delete customer, update customer 
 * Version 		1.1 
 * Created Date 08-AUG-2022
 ************************************************************************************/
@Service
public class CustomerServiceImpl implements CustomerServices {

	@Autowired
	private CustomerRepo customerRepo;

	/************************************************************************************
	 * Method: getCustomerById 
	 * Description: fetches customer(s) data from the application.
	 * @param id - id of the customer to be searched.
	 * @returns customer - container object of the fetched customer class or throws exception.
	 * @throws GlobalMartException - It is raised due to no details of the customer to be fetched or wrong input. 
	 * Created By - AnandKumar Kanojia 
	 * Created Date - 08-AUG-2022
	 ************************************************************************************/
	@Override
	public Optional<Customer> getCustomerById(Integer id) throws GlobalMartException {
		Optional<Customer> customer = customerRepo.findById(id);
		if (customer.isEmpty()) {
			throw new GlobalMartException("User with user id " + id + " does not exist");
		}
		return customer;
	}

	/************************************************************************************
	 * Method: addCustomer 
	 * Description: add customer(s) data for the application.
	 * @param customer - customer data of type customer class.
	 * @returns customer - saved or added customer class or throws exception.
	 * @throws GlobalMartException - It is raised due to no details of the customer to be added.
	 * Created By - Anand Kumar Kanojia
	 * Created Date - 08-AUG-2022
	 ************************************************************************************/
	@Override
	public Customer addCustomer(Customer customer) throws GlobalMartException {
		if (customer == null)
			throw new GlobalMartException("Feilds cannot be left empty. Please fill in the necesaary details.");
//		if (customerRepo.findByUserName(customer.getUserName()) != null )
//			throw new GlobalMartException("User name already in use!! Use a different username.");
//		if (customerRepo.findByUserPhoneNumber(customer.getUserPhoneNumber()) != null || customerRepo.findByUserEmail(customer.getUserEmail()) != null)
//			throw new GlobalMartException("User already exists. Log into your account!");
		customer = customerRepo.save(customer);
		if (customer == null) {
			throw new GlobalMartException("Customer could not be added!! Try again.");
		}
		return customer;
	}

	/************************************************************************************
	 * Method: updateCustomer 
	 * Description: update customer(s) data for the application.
	 * @param customer - customer data of type customer class.
	 * @returns customer - updated customer data class or throws exception.
	 * @throws GlobalMartException - It is raised due to no details of the customer or wrong input. 
	 * Created By - Anand Kumar Kanojia
	 * Created Date - 08-AUG-2022
	 ************************************************************************************/
	@Override
	public Customer updateCustomer(Customer customer) throws GlobalMartException {
		if (customer == null) {
			throw new GlobalMartException("Provide details to update");
		}
		int x = customer.getCustomerId();
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

	/************************************************************************************
	 * Method: deleteCustomerById 
	 * Description: delete customer(s) data from the application.
	 * @param id - id of the customer to be deleted.
	 * @returns boolean - true, if deleted successfully or throw exception.
	 * @throws GlobalMartException - It is raised due to no details of the customer to be added. 
	 * Created By - Anand Kumar Kanojia
	 * Created Date - 08-AUG-2022
	 ************************************************************************************/
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

	/************************************************************************************
	 * Method: getCustomerById 
	 * Description: get all customers data from the application.
	 * @returns List<customer> - List of saved customer details or throws exception.
	 * @throws GlobalMartException - It is raised due to no details of the customer to be added. 
	 * Created By - Anand Kumar Kanojia
	 * Created Date - 08-AUG-2022
	 ************************************************************************************/
	@Override
	public List<Customer> getAllCustomers() throws GlobalMartException {
		List<Customer> allCustomers = customerRepo.findAll();
		if (allCustomers.isEmpty()) {
			throw new GlobalMartException("No customers yet!!");
		}
		return allCustomers;
	}

	/************************************************************************************
	 * Method: getcustomerByNameAndPassword Description: fetch customer(s) data
	 * using name and password.
	 * @param name     - name of the customer.
	 * @param password - password of the customer's account.
	 * @returns customer - customer class found or throws exception.
	 * @throws GlobalMartException - It is raised due to no details of the customer are found or wrong details. 
	 * Created By - Anand Kumar Kanojia 
	 * Created Date - 08-AUG-2022
	 ************************************************************************************/
	@Override
	public List<Customer> getCustomerByUserNameAndUserPassword(String name, String password) throws GlobalMartException {
		List<Customer> customer = new ArrayList<>();
		if (name == null || password == null) {
			throw new GlobalMartException("Username and password are required!! ");
		}
		customer = customerRepo.findByUserNameAndUserPassword(name, password);
		if (customer.isEmpty())
			throw new GlobalMartException(
					"No customer with the provided username and password. Try again with correct details.");
		return customer;
	}

}
